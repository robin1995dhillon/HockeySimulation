package dhl.stateMachineNew.states;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ILeague;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.StateMachine;

public class PlayerChoiceState implements IStateMachine {

    private final IUserOutput output;
    private final IUserInput input;
    private final StateMachine stateMachine;
    private int totalSeasons = 0;
    private int currentSeason = 0;
    private ILeague machineLeague;

    public PlayerChoiceState(StateMachine machine){

        this.stateMachine = machine;
        output = new UserOutput();
        input = new UserInput();
        machineLeague = machine.getLeague();
    }

    public IStateMachine entry() {

        return doTask();
    }

    public IStateMachine doTask() {
        output.setOutput("How many seasons do you want to simulate?");
        output.sendOutput();
        input.setInput();
        totalSeasons = Integer.parseInt(input.getInput());
//        for (int i = 0; i < totalSeasons; i++) {
//            currentSeason = i;
//            boolean seasonIncomplete = true;
//            output.setOutput("Simulating season " + (i + 1) + " for " + machineLeague + " ...");
//            output.sendOutput();
//        }
        machineLeague.setTotalSeasons(totalSeasons);
        machineLeague.setSeason(0);
        return stateMachine.getInitializeSeason();
    }

    public void exit() {

    }
}

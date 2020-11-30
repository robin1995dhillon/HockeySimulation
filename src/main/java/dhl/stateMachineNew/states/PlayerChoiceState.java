package dhl.stateMachineNew.states;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ILeague;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.StateMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerChoiceState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(PlayerChoiceState.class);
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
        machineLeague.setTotalSeasons(totalSeasons);
        machineLeague.setSeason(0);
        logger.info("You want to simulate " + totalSeasons + " seasons");
        return stateMachine.getInitializeSeason();
    }

    public void exit() {

    }
}

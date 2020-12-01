package dhl.stateMachine.states;

import dhl.presentation.inputOutput.*;
import dhl.leagueModel.ILeague;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerChoiceState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(PlayerChoiceState.class);
    private final IUserOutput output;
    private final IUserInput input;
    private final StateMachine stateMachine;
    private int totalSeasons = 0;
    private ILeague machineLeague;
    InputOutputAbstractFactory inputOutputAbstractFactory;

    public PlayerChoiceState(StateMachine machine){
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.stateMachine = machine;
        output = inputOutputAbstractFactory.createUserOutput();
        input = inputOutputAbstractFactory.createUserInput();
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

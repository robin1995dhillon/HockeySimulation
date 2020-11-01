package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.ILeague;

public class InjuryCheckState implements INestedState {

    private static String stateName;
    private static String nextStateName;
    private ILeague league;
    private Scheduler timeTracker;
    private Scheduler schedule;
    private String currentDate;
    private IUserInput input;
    private IUserOutput output;
    private NestedStateContext context;

    public InjuryCheckState(ILeague league, Scheduler schedule, Scheduler timeTracker, String currentDate, IUserInput input, IUserOutput output, NestedStateContext context) {
        this.league = league;
        this.schedule = schedule;
        this.timeTracker = timeTracker;
        this.currentDate = currentDate;
        this.output = output;
        this.input = input;
        this.context = context;
        this.stateName = "SimulateGames";
        this.nextStateName = "InjuryCheck";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return InjuryCheckState.stateName;
    }

    public String getNextState() {
        return InjuryCheckState.nextStateName;
    }
}

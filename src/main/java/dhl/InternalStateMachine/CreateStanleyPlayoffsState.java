package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

public class CreateStanleyPlayoffsState implements INestedState {

    private Scheduler timeTracker;
    private NestedStateContext context;
    private ILeague league;
    private String currDate;
    private int currentYear;
    private IUserInput input;
    private IUserOutput output;
    private String stateName;
    private String nextState;
    private boolean finalDay;

    public CreateStanleyPlayoffsState(ILeague league, Scheduler timeTracker, String currDate, IUserInput input, IUserOutput output, NestedStateContext context) {
        this.league = league;
        this.currDate = currDate;
        this.timeTracker = timeTracker;
        this.context = context;
        this.input = input;
        this.output = output;
        this.stateName = "CreateStanleyPlayoffsState";
        this.nextState = "Training";
    }

    public void forward(NestedStateContext context) {
        //TODO: Set appropriate context.
    }

    public void runState() {
        //TODO: Execute state-related processes.
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextState;
    }
}

package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.ILeague;

public class CreateStanleyPlayoffsState implements INestedState {

    private Scheduler timeTracker;
    private NestedStateContext context;
    private ILeague league;
    private String currDate;
    private int currentYear;
    private IUserInput input;
    private IUserOutput output;
    private String stateName;
    private Scheduler schedule;
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
        this.nextState = "TrainingState";
        context.setState(new TrainingState(league, schedule, timeTracker, currDate, input, output, context));
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

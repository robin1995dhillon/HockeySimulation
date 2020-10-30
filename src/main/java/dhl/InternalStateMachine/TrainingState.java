package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

import java.util.List;
import java.util.Map;

public class TrainingState implements INestedState {

    private NestedStateContext context;
    private String currentDate;
    private Scheduler timeTracker;
    private Scheduler schedule;
    private ILeague league;
    private IUserOutput output;
    private IUserInput input;
    private String stateName;
    private String nextStateName;
    private Boolean unPlayedGames = true;
    private Boolean tradeEnded = true;

    public TrainingState(ILeague league, Scheduler schedule, Scheduler timeTracker, String currentDate, IUserInput input, IUserOutput output, NestedStateContext context) {
        this.league = league;
        this.schedule = schedule;
        this.timeTracker = timeTracker;
        this.currentDate = currentDate;
        this.output = output;
        this.input = input;
        this.context = context;
        this.stateName = "Training";
    }

    @Override
    public void forward(NestedStateContext context) {
        //TODO: set appropriate context
    }

    @Override
    public void runState() {
        //TODO: Execute state-related processing
    }

    @Override
    public String getStateName() {
        return this.stateName;
    }

    @Override
    public String getNextState() {
        return this.nextStateName;
    }
}

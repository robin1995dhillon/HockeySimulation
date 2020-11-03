package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.league.ILeague;

public class SimulateGamesState implements INestedState {

    private String stateName;
    private String nextStateName;
    private ILeague league;
    private Scheduler timeTracker;
    private Scheduler schedule;
    private String currentDate;
    private IUserInput input;
    private IUserOutput output;
    private NestedStateContext context;

    public SimulateGamesState(ILeague league, Scheduler schedule, Scheduler timeTracker, String currentDate, IUserInput input, IUserOutput output, NestedStateContext context) {
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
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }
}

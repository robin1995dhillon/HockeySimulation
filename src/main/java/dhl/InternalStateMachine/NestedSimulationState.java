package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

import java.util.Calendar;

public class NestedSimulationState implements INestedState {

    private int season;
    private int totalSeasons;
    private int currentSeason;
    private String teamName;
    private String stateName;
    private String nextStateName;

    private IUserInput input;
    private IUserOutput output;
    private ILeague league;

    private NestedStateContext context;
    private Scheduler schedule;
    private Scheduler timeTracker;
    private Calendar calendar;
    private String currentDate;
    private CreateFullSeasonScheduleState createFullSeasonScheduleState;
    private CreateStanleyPlayoffsState createStanleyPlayoffsState;
    private TrainingState trainingState;
    private AdvanceTimeState advanceTimeState;
    private SimulateGamesState simulateGame;
    private AgePlayersState agingState;
    private TradePlayersState tradingState;
    private InjuryCheckState injuryCheck;
    private AdvanceToNextSeasonState advanceToNextSeason;
    private PersistState persistState;


    public NestedSimulationState(ILeague league, NestedStateContext context, IUserInput input, IUserOutput output, int totalSeasons, String teamName) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.totalSeasons = totalSeasons;
        this.currentSeason = 0;
        this.teamName = teamName;
        this.stateName = "NestedSimulationState";
    }

    public void forward(NestedStateContext context) {
        this.nextStateName = "NestedEndState";
        context.setState(new NestedEndState(input, output));
    }

    public void runState() {
        for (int i = 0; i < totalSeasons; i++) {
            this.currentSeason = i;
            boolean seasonIncomplete = true;
            output.setOutput("Simulating season " + i + 1 + " for " + teamName + " ...");
            output.sendOutput();
            // TODO: Simulate
        }

    }


    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }

}

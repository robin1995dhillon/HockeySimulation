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
            CreateFullSeasonScheduleState createFullSeasonScheduleState = new CreateFullSeasonScheduleState(league, input, output, currentSeason, context);
            createFullSeasonScheduleState.runState();
            this.schedule = createFullSeasonScheduleState.getSchedule();
            String startDate = createFullSeasonScheduleState.getRegularSeasonEndDate();
            String endDate = createFullSeasonScheduleState.getRegularSeasonEndDate();
            this.currentDate = startDate;
            this.calendar = Calendar.getInstance();
            do {
                this.timeTracker = new Scheduler(calendar, currentSeason);
                advanceTimeState = new AdvanceTimeState(league, schedule, timeTracker, currentDate, endDate, input, output, context);
                advanceTimeState.runState();
                this.currentDate = advanceTimeState.getCurrentDate();

                output.setOutput("Current day is: " + this.currentDate);
                output.sendOutput();
                boolean lastDayOfSeason = advanceTimeState.ifLastDayOfSeason();

                if (lastDayOfSeason) {
                    createStanleyPlayoffsState = new CreateStanleyPlayoffsState(league, timeTracker, currentDate, input, output, context);
                    createStanleyPlayoffsState.runState();
//                    schedule = createStanleyPlayoffsState.getSchedule();
                    trainingState = new TrainingState(league, schedule, timeTracker, currentDate, input, output, context);
                } else {
                    trainingState = new TrainingState(league, schedule, timeTracker, currentDate, input, output, context);
                }
                trainingState.runState();
                boolean unplayedGames = trainingState.checkPendingGames();

                while (unplayedGames) {
                    simulateGame = new SimulateGamesState(league, schedule, timeTracker, currentDate, input, output, context);
                    simulateGame.runState();

                    injuryCheck = new InjuryCheckState(league, schedule, timeTracker, currentDate, input, output, context);
                    injuryCheck.runState();
                    unplayedGames = trainingState.checkPendingGames();
                }
                if (timeTracker.isLastDayOfTrade(this.currentDate)) {
                    tradingState = new TradePlayersState(league, schedule, timeTracker, currentDate, input, output, context);
                    tradingState.runState();
                }

                agingState.runState();
                agingState = new AgePlayersState(league, schedule, timeTracker, currentDate, input, output, context);

                if (timeTracker.getSeasonOverStatus() | timeTracker.isLastDayOfSeason(currentDate)) {
                    advanceToNextSeason = new AdvanceToNextSeasonState(league, schedule, timeTracker, currentDate, input, output, context);
                    advanceToNextSeason.runState();
                    seasonIncomplete = false;
                }
                persistState = new PersistState(league, schedule, timeTracker, currentDate, input, output, context);
                persistState.runState();
            } while (seasonIncomplete);
            output.setOutput("Winner team for season " + i + " is " + timeTracker.getSeasonWinner());
            output.sendOutput();
        }

    }


    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }

}

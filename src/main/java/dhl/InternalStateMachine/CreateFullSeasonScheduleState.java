package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

import java.util.Calendar;

public class CreateFullSeasonScheduleState implements INestedState {

    private ILeague league;
    private NestedStateContext context;
    private IUserInput input;
    private IUserOutput output;
    private int currentSeason;
    private String stateName;
    private String nextStateName;
    private String startDate;
    private String endDate;
    private int currentYear;
    private Calendar calendar;
    private Scheduler schedule;
    private Scheduler timeTracker;

    public CreateFullSeasonScheduleState(ILeague league, IUserInput input, IUserOutput output, int currentSeason, NestedStateContext context) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.currentSeason = currentSeason;
        this.league = league;
        this.stateName = "CreateFullSeasonScheduleState";
        this.calendar = Calendar.getInstance();
        this.schedule = new Scheduler(calendar, output);
        this.timeTracker = new Scheduler(calendar, currentSeason);
        this.startDate = timeTracker.getStartDayOfSeason();
        this.endDate = timeTracker.getLastDayOfSeason();
    }

    public Scheduler getSchedule() {
        return schedule;
    }

    public String getRegularSeasonEndDate() {
        return this.endDate;
    }

    public String getRegularSeasonStartDate() {
        return this.startDate;
    }

    @Override
    public void forward(NestedStateContext context) {
        this.nextStateName = "AdvanceTimeState";
//        context.setState(new AdvanceTimeState(this.league, this.schedule, this.timeTracker, this.startDate, this.endDate, this.input, this.output, context));
    }

    @Override
    public void runState() {

//        standings.initializeStandings();
        if(league == null) {
            output.setOutput("No league found!");
            output.sendOutput();
            return;
        }

        schedule.generateSchedule(league);
        output.setOutput("Regular season scheduled.");
        output.sendOutput();

        schedule.setCurrentDay(timeTracker.getFirstDayOfSeason());
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

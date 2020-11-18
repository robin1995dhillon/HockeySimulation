package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdvanceTimeState implements INestedState {

    private NestedStateContext context;
    private Scheduler timeTracker;
    private String stateName;
    private ILeague league;
    private String nextStateName;
    private Calendar calendar;
    private boolean lastDayOfSeason;
    private String currDate;
    private IUserOutput output;
    private IUserInput input;
    private String endDate;
    private Scheduler schedule;

    public AdvanceTimeState(ILeague league, Scheduler schedule, Scheduler timeTracker, String currentDate, String endDate, IUserInput input, IUserOutput output, NestedStateContext context) {
        this.league = league;
        this.schedule = schedule;
        this.timeTracker = timeTracker;
        this.currDate = currentDate;
        this.endDate = endDate;
        this.input = input;
        this.output = output;
        this.context = context;
        this.stateName = "AdvanceTime";
        this.lastDayOfSeason = false;
        this.calendar = Calendar.getInstance();

    }

    public String getCurrentDate() {
        return this.currDate;
    }

    public void setCurrentDate(String date) {
        this.currDate = date;
    }

    public boolean ifLastDayOfSeason() {
        return lastDayOfSeason;
    }

    @Override
    public void forward(NestedStateContext context) {
        if (lastDayOfSeason) {
            this.nextStateName = "CreateStanleyPlayoffs";
            context.setState(new CreateStanleyPlayoffsState(league, timeTracker, currDate, input, output, context));
        } else {
            this.nextStateName = "Training";
            context.setState(new TrainingState(league, schedule, timeTracker, currDate, input, output, context));
        }
    }

    @Override
    public void runState() {
        this.lastDayOfSeason = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            calendar.setTime(dateFormat.parse(currDate));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            this.currDate = dateFormat.format(calendar.getTime());
            if (this.currDate.equals(this.endDate)) {
                this.lastDayOfSeason = true;
            }
        } catch (ParseException e) {
            output.setOutput("Couldn't get current date in AdvanceTimeState.");
            output.sendOutput();
        }
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

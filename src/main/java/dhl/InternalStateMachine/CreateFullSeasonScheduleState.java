package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

import java.util.Calendar;

public class CreateFullSeasonScheduleState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;
    private static String startDate;
    private static String endDate;
    private static ILeague league;
    private static Calendar schedule;
    private static Integer startYear;
    private static Integer endYear;
    private static String endDayMonth;
    private static IUserInput input;
    private static IUserOutput output;
    private static String startDayMonth = "30-09-";

    public CreateFullSeasonScheduleState(ILeague league, IUserInput input, IUserOutput output) {
        CreateFullSeasonScheduleState.input = input;
        CreateFullSeasonScheduleState.league = league;
        CreateFullSeasonScheduleState.output = output;
        CreateFullSeasonScheduleState.stateName = "CreateFullSeasonSchedule";
        CreateFullSeasonScheduleState.schedule = Calendar.getInstance();
        CreateFullSeasonScheduleState.startYear = CreateFullSeasonScheduleState.schedule.get(Calendar.YEAR);
        String startYear = Integer.toString(CreateFullSeasonScheduleState.startYear);
        CreateFullSeasonScheduleState.startDate = CreateFullSeasonScheduleState.startDayMonth + startYear;
        System.out.println("Season start date is: " + startDate);
        CreateFullSeasonScheduleState.endYear = CreateFullSeasonScheduleState.startYear + 1;
        CreateFullSeasonScheduleState.endDayMonth = getSeasonEndDay() + "-04-";
        CreateFullSeasonScheduleState.endDate = CreateFullSeasonScheduleState.endDayMonth + Integer.toString(CreateFullSeasonScheduleState.endYear);
        System.out.println("Season end date is: " + endDate);
    }

    /**
     * Season end date: First Saturday in April
     **/
    public String getSeasonEndDay() {
        schedule.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        schedule.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        schedule.set(Calendar.MONTH, Calendar.APRIL);
        schedule.set(Calendar.YEAR, CreateFullSeasonScheduleState.endYear);
        return String.valueOf(schedule.get(Calendar.DATE));
    }

    /**
     * Trade deadline: Last Monday in February
     **/
    public String getTradeDeadline() {
        schedule.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        schedule.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4);
        schedule.set(Calendar.MONTH, Calendar.FEBRUARY);
        schedule.set(Calendar.YEAR, CreateFullSeasonScheduleState.endYear);
        return String.valueOf(schedule.get(Calendar.DATE));
    }

    /**
     * Stanley Playoffs start data: Second Wednesday in April
     **/
    public String getPlayoffsStartDate() {
        schedule.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        schedule.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
        schedule.set(Calendar.MONTH, Calendar.APRIL);
        schedule.set(Calendar.YEAR, CreateFullSeasonScheduleState.endYear);
        return String.valueOf(schedule.get(Calendar.DATE));
    }

    public String getSeasonEndDate() {
        return this.endDate;
    }

    public String getSeasonStartDate() {
        return this.startDate;
    }

    @Override
    public void forward(NestedStateContext context) {
        context.currentDate = this.startDate;
        this.nextStateName = "AdvanceTime";
        context.setState(new AdvanceTimeState(schedule, CreateFullSeasonScheduleState.startDate, CreateFullSeasonScheduleState.endDate, CreateFullSeasonScheduleState.input, CreateFullSeasonScheduleState.output));
    }

    @Override
    public void runState() {

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

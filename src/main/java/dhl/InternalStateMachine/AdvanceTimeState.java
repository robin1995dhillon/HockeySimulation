package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdvanceTimeState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;
    private static boolean lastDayOfSeason;
    private static String currDate;
    private static String startDate;
    private static IUserOutput output;
    private static IUserInput input;
    private static String endDate;
    private static Calendar schedule;

    public AdvanceTimeState(Calendar schedule, String startDate, String endDate, IUserInput input, IUserOutput output) {
        AdvanceTimeState.stateName = "AdvanceTime";
        AdvanceTimeState.endDate = endDate;
        AdvanceTimeState.schedule = schedule;
        AdvanceTimeState.currDate = startDate;
        AdvanceTimeState.input = input;
        AdvanceTimeState.output = output;
        AdvanceTimeState.lastDayOfSeason = checkIfLastDayOfSeason(currDate, endDate);
    }

    public boolean checkIfLastDayOfSeason(String currDate, String endDate) {
        boolean lastday = currDate.equals(endDate);
        return lastday;
    }

    @Override
    public void forward(NestedStateContext context) {
        if (AdvanceTimeState.lastDayOfSeason) {
            AdvanceTimeState.nextStateName = "CreateStanleyPlayoffs";
            context.setState(new CreateStanleyPlayoffsState());
        } else {
            this.nextStateName = "Training";
            context.setState(new TrainingState());
        }
    }

    @Override
    public void runState() {
        //TODO:state related processsing
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            schedule.setTime(dateFormat.parse(currDate));
        } catch (ParseException e) {
            output.setOutput("Exception while getting current date in Advance Time state");
            output.sendOutput();
        }

        // add a day to current date
        schedule.add(Calendar.DATE, 1);
        AdvanceTimeState.currDate = dateFormat.format(schedule.getTime());
    }

    public String getCurrentDate() {
        return AdvanceTimeState.currDate;
    }
    @Override
    public String getStateName() {
        return AdvanceTimeState.stateName;
    }

    @Override
    public String getNextState() {
        return AdvanceTimeState.nextStateName;
    }
}

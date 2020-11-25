package dhl.stateMachineNew;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LeagueTimeConcept implements ITime{

    private IUserOutput output;

    LeagueTimeConcept(){
        output = new UserOutput();
    }

    public String nextDate(String currentDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(dateFormat.parse(currentDate));
        } catch (ParseException e) {
            output.setOutput("Exception while getting current date");
            output.sendOutput();
        }
        // add a day to current date if it is not last date for the season
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String currentDay = dateFormat.format(calendar.getTime());
        return currentDay;

    }
}

package dhl.stateMachine;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LeagueTimeConcept implements ITime{
    private static final Logger logger = LogManager.getLogger(LeagueTimeConcept.class);
    private IUserOutput output;
    private InputOutputAbstractFactory inputOutputAbstractFactory;

    public LeagueTimeConcept(){
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        output = inputOutputAbstractFactory.createUserOutput();
    }

    public String nextDate(String currentDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(currentDate));
        } catch (ParseException e) {
            logger.error("You set the wrong date.");
            output.setOutput("Exception while getting current date");
            output.sendOutput();
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String currentDay = dateFormat.format(calendar.getTime());
        return currentDay;
    }
}

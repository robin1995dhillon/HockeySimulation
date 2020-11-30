package dhl.stateMachineNewTest;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTimeConceptTest {

    @Test
    public void nextDateTest(){
        IUserOutput output = new UserOutput();
        String currentDate = "01-02-2020";
        String expectedDate = "02-02-2020";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(dateFormat.parse(currentDate));
        } catch (ParseException e) {
            output.setOutput("Exception while getting current date");
            output.sendOutput();
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String currentDay = dateFormat.format(calendar.getTime());

        assertEquals(expectedDate,currentDay);
    }
}

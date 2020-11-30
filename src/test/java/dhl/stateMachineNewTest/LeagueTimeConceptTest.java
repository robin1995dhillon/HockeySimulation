package dhl.stateMachineNewTest;

import dhl.stateMachineNew.ITime;
import dhl.stateMachineNew.StateMachineAbstractFactory;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTimeConceptTest {

    @Test
    public void nextDateTest() throws ParseException {
        ITime timeConcept = StateMachineAbstractFactory.instance().getTime();
        String currentDate = "01-02-2020";
        String expectedDate = "02-02-2020";
        String dateOutput ="";
        try {
            dateOutput = timeConcept.nextDate(currentDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(expectedDate,dateOutput);


    }
}

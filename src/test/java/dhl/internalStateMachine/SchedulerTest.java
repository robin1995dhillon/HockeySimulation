package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class SchedulerTest {
    private IUserInput input;
    private Calendar calendar;
    private IUserOutput output;
    private NestedStateContext context;
    private Scheduler schedule;
    private Scheduler timeTracker;
    private ILeague league;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        context = new NestedStateContext(input, output);
        calendar = Calendar.getInstance();
        timeTracker = new Scheduler(calendar, 0);
        schedule = new Scheduler(calendar, output);
    }

    @Test
    public void getStartDayOfSeasonTest() {
        assertEquals("30-09-2020", timeTracker.getStartDayOfSeason());
    }

    @Test
    public void getFirstDayOfSeasonTest() {
        assertEquals("1-10-2020", timeTracker.getFirstDayOfSeason());
    }

    @Test
    public void getLastDayOfSeasonTest() {
        assertEquals("3-04-2021", timeTracker.getLastDayOfSeason());
    }

    @Test
    public void getFirstDayOfStanleyPlayoffsTest() {
        assertEquals("14", timeTracker.getFirstDayOfStanleyPlayoffs());
    }

    @Test
    public void getLastDayOfStanleyPlayoffsTest() {
        assertEquals("1-06-2021", timeTracker.getLastDayOfStanleyPlayoffs());
    }

    @Test
    public void getLastDayOfTradeTest() {
        assertEquals("22", timeTracker.getLastDayOfTrade());
    }

    @Test
    public void isLastDayOfTradeTest() {
        assertEquals(false, timeTracker.isLastDayOfTrade("10-02-2021"));
        assertEquals(true, timeTracker.isLastDayOfTrade("22-02-2021"));
    }

    @Test
    public void isLastDayOfSeasonTest() {
        assertEquals(false, timeTracker.isLastDayOfSeason("1-04-2021"));
        assertEquals(true, timeTracker.isLastDayOfSeason("1-6-2021"));
    }

    @Test
    public void setCurrentDayTest() {
        schedule.setCurrentDay("01-10-2020");
        assertEquals("01-10-2020", schedule.getCurrentDay());
    }

    @Test
    public void incrementCurrentDayTest() {
        timeTracker.setCurrentDay("1-10-2020");
        assertEquals(true, timeTracker.incrementCurrentDay());
    }

}
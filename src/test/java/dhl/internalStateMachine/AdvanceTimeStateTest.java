package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvanceTimeStateTest {
    private IUserInput input;
    private IUserOutput output;
    private NestedStateContext context;
    private AdvanceTimeState state;
    private Scheduler schedule;
    private ILeague league;
    private Scheduler timeTracker;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        state = new AdvanceTimeState(league, schedule, timeTracker, "30-09-2020", "01-10-2020", input, output, context);
        context = new NestedStateContext(input, output);
    }

    @Test
    public void ifLastDayOfSeasonTest() {
        assertEquals(false, state.ifLastDayOfSeason());
        state.runState();
        assertEquals(true, state.ifLastDayOfSeason());
    }

    @Test
    public void getCurrentDateTest() {
        assertEquals("30-09-2020", state.getCurrentDate());
        state.runState();
        assertEquals("01-10-2020", state.getCurrentDate());
    }

    @Test
    public void setCurrentDateTest() {
        state.setCurrentDate("15-10-2020");
        assertEquals("15-10-2020", state.getCurrentDate());
    }

    @Test
    public void forwardTest() {
        context.setState(state);
        context.forward();
        assertEquals("Training", state.getNextState());
    }

    @Test
    public void runStateTest() {
        state.runState();
        assertEquals("01-10-2020", state.getCurrentDate());
    }

    @Test
    public void getStateNameTest() {
        assertEquals("AdvanceTime", state.getStateName());
    }

    @Test
    public void getNextStateTest() {
        state.forward(context);
        assertEquals("Training", state.getNextState());
    }
}
package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class AdvanceTimeStateTest {
    private static IUserInput input;
    private static IUserOutput output;
    private static NestedStateContext context;
    private static AdvanceTimeState state;
    private static Calendar schedule;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        schedule = Calendar.getInstance();
        state = new AdvanceTimeState(schedule, "30-09-2020", "01-10-2020", input, output);
        context = new NestedStateContext(input, output);
    }

    @org.junit.Test
    public void checkIfLastDayOfSeason() {
        assertEquals(false, state.checkIfLastDayOfSeason("30-09-2020", "01-10-2020"));
    }

    @org.junit.Test
    public void forward() {
        context.setState(state);
        context.forward();
        assertEquals("Training", state.getNextState());
    }

    @org.junit.Test
    public void runStateTest() {
        state.runState();
        assertEquals("01-10-2020", state.getCurrentDate());
    }

    @org.junit.Test
    public void getStateName() {
        assertEquals("AdvanceTime", state.getStateName());
    }

    @org.junit.Test
    public void getNextState() {
        state.forward(context);
        assertEquals("Training", state.getNextState());
    }
}
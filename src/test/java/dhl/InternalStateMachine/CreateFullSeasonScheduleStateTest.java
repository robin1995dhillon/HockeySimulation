package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import static org.junit.Assert.*;


public class CreateFullSeasonScheduleStateTest {
    private static CreateFullSeasonScheduleState state;
    private static IUserInput input;
    private static IUserOutput output;
    private static NestedStateContext context;

    @Before
    public void setUp() throws Exception {
        input = new UserInput();
        output = new UserOutput();
        state = new CreateFullSeasonScheduleState(null, input, output);
        context = new NestedStateContext(input, output);
    }

    @org.junit.Test
    public void forward() {
        context.setState(state);
        context.forward();
        assertEquals("AdvanceTime", state.getNextState());
    }

    @org.junit.Test
    public void runState() {
        // TODO - once we finalize the scheduling algo
    }

    @org.junit.Test
    public void getSeasonEndDay() {
        assertEquals("3", state.getSeasonEndDay());
    }

    @org.junit.Test
    public void getTradeDeadline() {
        assertEquals("22", state.getTradeDeadline());
    }

    @org.junit.Test
    public void getPlayoffsStartDate() {
        assertEquals("14", state.getPlayoffsStartDate());
    }
    @org.junit.Test
    public void getSeasonEndDate() {
        assertEquals("3-04-2021", state.getSeasonEndDate());
    }
    @org.junit.Test
    public void getSeasonStartDate() {
        assertEquals("30-09-2020", state.getSeasonStartDate());
    }

    @org.junit.Test
    public void getStateNameTest() {
        assertEquals("CreateFullSeasonSchedule", state.getStateName());
    }

    @org.junit.Test
    public void getNextStateNameTest() {
        state.forward(context);
        assertEquals("AdvanceTime", state.getNextState());
    }
}
package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CreateFullSeasonScheduleStateTest {
    private CreateFullSeasonScheduleState state;
    private IUserInput input;
    private IUserOutput output;
    private NestedStateContext context;

    @Before
    public void setUp() throws Exception {
        input = new UserInput();
        output = new UserOutput();
        context = new NestedStateContext(input, output);
        state = new CreateFullSeasonScheduleState(null, input, output, 0, context);

    }

    @Test
    public void forwardTest() {
        context.setState(state);
        context.forward();
        assertEquals("AdvanceTimeState", state.getNextState());
    }

    @Test
    public void runStateTest() {
    }

    @Test
    public void getStateNameTest() {
        assertEquals("CreateFullSeasonScheduleState", state.getStateName());
    }

    @Test
    public void getNextStateTest() {
        state.forward(context);
        assertEquals("AdvanceTimeState", state.getNextState());
    }

//    @Test
//    void getScheduleTest() {
//    }

    @Test
    public void getRegularSeasonStartDateTest() {
        assertEquals("30-09-2020", state.getRegularSeasonStartDate());
    }

    @Test
    public void getRegularSeasonEndDateTest() {
        assertEquals("3-04-2021", state.getRegularSeasonEndDate());
    }
}
//    @org.junit.Test
//    public void getSeasonEndDay() {
//        assertEquals("3", state.getSeasonEndDay());
//    }
//
//    @org.junit.Test
//    public void getTradeDeadline() {
//        assertEquals("22", state.getTradeDeadline());
//    }
//
//    @org.junit.Test
//    public void getPlayoffsStartDate() {
//        assertEquals("14", state.getPlayoffsStartDate());
//    }
//    @org.junit.Test
//    public void getSeasonEndDate() {
//        assertEquals("3-04-2021", state.getSeasonEndDate());
//    }
//    @org.junit.Test
//    public void getSeasonStartDate() {

//        assertEquals("30-09-2020", state.getSeasonStartDate());

//    }
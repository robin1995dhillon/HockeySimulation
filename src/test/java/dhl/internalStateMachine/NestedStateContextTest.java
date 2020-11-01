package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NestedStateContextTest {

    INestedState state;
    IUserInput input;
    IUserOutput output;
    NestedStateContext context;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        state = new NestedStartState(null, context, input, output, "Hawks");
        context = new NestedStateContext(input, output);
        context.setState(state);
    }

    @Test
    public void forwardTest() {
        context.forward();
        assertEquals("NestedSimulationState", context.currentStateName);
        context.setState(state);
    }

    @Test
    public void setStateTest() {
        context.setState(state);
        assertEquals("NestedStartState", context.currentStateName);
    }

//    @Test
//    public void runStateTest() {
//        context.setState(new NestedEndState(input, output));
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        context.runState();
//        String expected = "Thanks for using our simulation :). See you around.";
//        String actual = out.toString().replaceAll("\n", "");
//        assertEquals(expected, actual);
//    }
}
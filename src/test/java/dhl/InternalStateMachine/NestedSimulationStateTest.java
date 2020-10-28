package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NestedSimulationStateTest {
    NestedSimulationState state;
    IUserInput input;
    IUserOutput output;
    NestedStateContext context;

    @Before
    public void config() throws Exception {
        input = new UserInput();
        output = new UserOutput();
        context = new NestedStateContext(input, output);
        state = new NestedSimulationState(null, context, input, output, 1, "Rob's team");
    }

    @Test
    public void forwardTest() {
        context.setState(state);
        context.forward();
        assertEquals("NestedEndState", context.currentStateName);
    }

    @Test
    public void getStateNameTest() {
        assertEquals("NestedSimulationState", state.getStateName());
    }


    @Test
    public void runStateTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String expected = "Simulating season 1 for Rob's team ...";

        state.runState();

        String gotOutput = out.toString().replaceAll("\n", "");
        gotOutput = gotOutput.replaceAll("\r", "");
        assertEquals(expected, gotOutput);
    }
}
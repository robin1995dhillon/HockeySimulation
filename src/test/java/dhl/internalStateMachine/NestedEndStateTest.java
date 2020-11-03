package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NestedEndStateTest {
    NestedEndState state;
    IUserInput input;
    IUserOutput output;
    NestedStateContext context;

    @Before
    public void setUp() {
        input = new UserInput();
        output = new UserOutput();
        state = new NestedEndState(input, output);
        context = new NestedStateContext(input, output);
    }

    @Test
    public void forward() {
        context.setState(state);
        context.forward();
        assertEquals("None", state.getNextState());
    }

    @Test
    public void runStateTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        state.runState();

        String expected = "Thanks for using our simulation :). See you around.";
        String gotOutput = out.toString().replaceAll("\n", "");
        gotOutput = gotOutput.replaceAll("\r", "");
        assertEquals(expected, gotOutput);
    }

    @Test
    public void getStateNameTest() {
        assertEquals("NestedEndState", state.getStateName());
    }

    @Test
    public void getNextStateTest() {
        state.forward(context);
        assertEquals("None", state.getNextState());
    }
}
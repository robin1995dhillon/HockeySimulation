package dhl.InternalStateMachine;

import dhl.InternalStateMachine.NestedEndState;
import dhl.InternalStateMachine.NestedStateContext;
import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
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
        assertEquals("None", state.getNextStateName());
    }

    @Test
    public void getStateName() {
        assertEquals("End", state.getStateName());
    }

    @Test
    public void getNextStateName() {
        state.forward(context);
        assertEquals("None", state.getNextStateName());
    }

    @Test
    public void runState(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        state.runState();

        String expected  = "Thanks for using our simulation :). See you around.";
        String gotOutput = out.toString().replaceAll("\n", "");
        gotOutput = gotOutput.replaceAll("\r", "");
        assertEquals(expected, gotOutput);
    }
}
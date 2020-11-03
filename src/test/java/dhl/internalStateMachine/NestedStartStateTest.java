package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class NestedStartStateTest {

    NestedStartState state;
    IUserInput input;
    IUserOutput output;
    NestedStateContext context;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        state = new NestedStartState(null, context, input, output, "");
        context = new NestedStateContext(input, output);
    }

    @Test
    public void forwardTest() {
        state.forward(context);
        assertEquals("NestedSimulationState", context.currentStateName);
    }

    @Test
    public void runStateTest() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.input.setInput();
        assertEquals("2", this.input.getInput());
    }

    @Test
    public void getStateNameTest() {
        assertEquals("NestedStartState", state.getStateName());
    }

    @Test
    public void getNextStateTest() {
        state.forward(context);
        assertEquals("NestedSimulationState", state.getNextState());
    }


}
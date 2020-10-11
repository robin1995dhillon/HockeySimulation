package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import dhl.InternalStateMachine.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NestedSimulationStateTest {
    NestedSimulationState st;
    IUserInput inp;
    IUserOutput out;
    NestedStateContext con;

    @Before
    public void config() throws Exception {
        inp = new UserInput();
        out = new UserOutput();
        st = new NestedSimulationState(inp, out, 1, "Rob's team");
        con = new NestedStateContext(inp, out);
    }

    @Test
    public void nextStateTest() {
        con.setState(st);
        con.forward();
        assertEquals("End", con.currentStateName);
    }

    @Test
    public void getStateNameTest() {
        assertEquals("Simulate", st.getStateName());
    }


    @Test
    public void doProcessing() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String expected = "Simulating season 1 for Rob's team ...";

        st.runState();

        String gotOutput = out.toString().replaceAll("\n", "");
        gotOutput = gotOutput.replaceAll("\r", "");
        assertEquals(expected, gotOutput);
    }
}
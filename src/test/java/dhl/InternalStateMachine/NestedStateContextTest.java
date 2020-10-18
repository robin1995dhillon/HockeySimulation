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

public class NestedStateContextTest {

    ISimulationState st;
    IUserInput inp;
    IUserOutput out;
    NestedStateContext con;

    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        st = new NestedStartState(inp, out, "");
        con = new NestedStateContext(inp, out);
        con.setState(st);
    }

    @Test
    public void forward() {
        con.forward();
        assertEquals("Simulate", con.currentStateName);
        con.setState(st);
    }

    @Test
    public void setState() {
        con.setState(st);
        assertEquals("Start", con.currentStateName);
    }

//    @Test
//    public void runState() {
//        con.setState(new NestedEndState(inp, out));
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        con.runState();
//        String expected = "Thanks for using our simulation :). See you around.";
//        String gotOutput = out.toString().replaceAll("\n", "");
//        assertEquals(expected, gotOutput);
//    }
}
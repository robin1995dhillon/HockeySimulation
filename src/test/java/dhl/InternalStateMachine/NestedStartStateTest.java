package dhl.InternalStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NestedStartStateTest {

    NestedStartState st;
    IUserInput inp;
    IUserOutput out;
    NestedStateContext con;

    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        st = new NestedStartState(inp, out, "");
        con = new NestedStateContext(inp, out);
    }

    @Test
    public void forward() {
        st.forward(con);
        assertEquals("Simulate", con.currentStateName);
    }

    @Test
    public void runState() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.inp.setInput();
        assertEquals("0", String.valueOf(st.numOfSeasons));
    }

    @Test
    public void getStateName() {
        assertEquals("Start", st.getStateName());
    }


}
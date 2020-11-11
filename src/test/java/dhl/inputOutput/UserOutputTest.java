package dhl.InOut;

import dhl.inputOutput.UserOutput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserOutputTest {
    private static UserOutput out;

    @Before
    public void setUpClass() throws Exception {
        out = new UserOutput();
    }

    @Test
    public void setDefault() {
        out.setDefaultOutput();
        assertEquals("", out.sendOutput());
    }

    @Test
    public void setOutputTest() {
        out.setOutput("gibberish");
        assertEquals(out.sendOutput(), "gibberish");
    }

    @Test
    public void sendOutputTest() {
        out.setDefaultOutput();
        assertEquals(out.sendOutput(), "");
        out.setOutput("gibberish2");
        assertEquals(out.sendOutput(), "gibberish2");
    }

}

package dhl.inputOutput;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class UserInputTest {
    //    private static UserInput inp;
    private UserInput userInput;

    @Before
    public void config() {
        userInput = new UserInput();
    }

    @Test
    public void setDefaultInput() {
        userInput.setDefaultInput();
        assertEquals("", userInput.getInput());
    }

    @Test
    public void getInput() {
        String input = "Testing Get Input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        userInput.setInput();
        assertEquals("Testing Get Input", userInput.getInput());
    }

    @Test
    public void setInput() {
        String input = "Testing Set Input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        userInput.setInput();
        assertEquals("Testing Set Input", userInput.getInput());
    }

}

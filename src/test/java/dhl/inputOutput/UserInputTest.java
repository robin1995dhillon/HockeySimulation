//package dhl.InOut;
//
//import dhl.InOut.UserInput;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import static org.junit.Assert.assertEquals;
//
//public class UserInputTest {
//    private static UserInput inp;
//
//    @Before
//    public void config(){
//        inp = new UserInput();
//    }
//
//    @Test
//    public void setDefaultInput() {
//        inp.setDefaultInput();
//        assertEquals("", inp.getInput());
//    }
//    @Test
//    public void getInput() {
//        String input = "Testing Get Input";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        inp.setInput();
//        assertEquals("Testing Get Input", inp.getInput());
//    }
//
//    @Test
//    public void setInput() {
//        String input = "Testing Set Input";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        inp.setInput();
//        assertEquals("Testing Set Input", inp.getInput());
//    }
//
//}
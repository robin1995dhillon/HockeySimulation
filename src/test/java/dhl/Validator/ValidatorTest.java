package dhl.Validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void valueIsPresent() {
        String val = "Eastern";
        Validator validator = new Validator();
        boolean result = validator.valueIsPresent(val);
        assertEquals(true,result);
    }
    @Test
    void falseValueIsPresent() {
        String val = "";
        Validator validator = new Validator();
        boolean result = validator.valueIsPresent(val);
        assertEquals(false,result);
    }
}
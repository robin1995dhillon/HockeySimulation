package dhl.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    ValidatorAbstractFactory validatorAbstractFactory;
    IValidator validator;

    public ValidatorTest() {
        validatorAbstractFactory = ValidatorAbstractFactory.instance();
        validator = validatorAbstractFactory.getValidator();
    }

    @Test
    void valueIsPresent() {
        String val = "Eastern";
        boolean result = validator.valueIsPresent(val);
        assertEquals(true, result);
    }

    @Test
    void falseValueIsPresent() {
        String val = "";
        boolean result = validator.valueIsPresent(val);
        assertEquals(false, result);
    }
}

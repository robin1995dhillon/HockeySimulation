package dhl.validator;

public interface IValidator {
    boolean valueIsPresent(String val);

    boolean valueIsPresent(double val);

    boolean checkRange(int val);

    boolean checkBirthDay(int val);

    boolean checkBirthYear(int val);

    boolean checkBirthMonth(int val);
}

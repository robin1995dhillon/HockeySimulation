package dhl.validator;

public class Validator implements IValidator {

    @Override
    public boolean valueIsPresent(String val) {
        return !(val.isEmpty());
    }

    @Override
    public boolean valueIsPresent(double val) {
        String val_string = Double.toString(val);
        return !(val_string.isEmpty());
    }

    @Override
    public boolean checkRange(int val) {
        if (val >= 0 && val <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkBirthDay(int val) {
        if (val>= 0 && val<=31) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkBirthYear(int val) {
        if (val>= 0 && val<=2020) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkBirthMonth(int val) {
        if(val>=1 && val<=12) {
            return true;
        }
        return false;
    }


}

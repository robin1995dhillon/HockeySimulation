package dhl.validator;

public class Validator {

    public boolean valueIsPresent(String val) {
        return !(val.isEmpty());
    }

    public boolean valueIsPresent(double val) {
        String val_string = Double.toString(val);
        return !(val_string.isEmpty());
    }

    public boolean checkRange(int val) {
        if(val>=0 && val<=20) {
            return true;
        }
        return false;
    }



}

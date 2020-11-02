package dhl.inputOutput;

public class UserOutput implements IUserOutput {

    private String OutValue;

    public UserOutput() {
        setDefaultOutput();
    }

    @Override
    public void setDefaultOutput() {
        OutValue = "";
    }

    @Override
    public void setOutput(String outvalue) {
        this.OutValue = outvalue;
    }

    @Override
    public String sendOutput() {
        System.out.println(this.OutValue);
        return this.OutValue;
    }

    @Override
    public String sendErrorOutput() {
        System.err.println(this.OutValue);
        return this.OutValue;
    }
}
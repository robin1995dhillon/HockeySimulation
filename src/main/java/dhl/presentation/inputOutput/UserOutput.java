package dhl.presentation.inputOutput;

public class UserOutput implements IUserOutput {

    private String outValue;

    public UserOutput() {
        setDefaultOutput();
    }

    @Override
    public void setDefaultOutput() {
        outValue = "";
    }

    @Override
    public void setOutput(String outValue) {
        this.outValue = outValue;
    }

    @Override
    public String sendOutput() {
        System.out.println(this.outValue);
        return this.outValue;
    }

    @Override
    public String sendErrorOutput() {
        System.err.println(this.outValue);
        return this.outValue;
    }

}

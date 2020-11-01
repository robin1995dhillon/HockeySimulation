package dhl.inputOutput;

public class UserOutput implements IUserOutput {

    private String OutValue;

    public UserOutput() {
        setDefaultOutput();
    }

    public void setDefaultOutput() {
        OutValue = "";
    }

    public void setOutput(String outvalue) {
        this.OutValue = outvalue;
    }

    public String sendOutput() {
        System.out.println(this.OutValue);
        return this.OutValue;
    }
}

// UserOutput userOutput = new UserOutput();
// userOutput.setOutput("Value");
// userOutput.sendOutput();
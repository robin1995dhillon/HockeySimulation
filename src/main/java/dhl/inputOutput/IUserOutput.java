package dhl.inputOutput;

public interface IUserOutput {
    abstract void setOutput(String outvalue);

    abstract String sendOutput();

    abstract void setDefaultOutput();

    String sendErrorOutput();
}

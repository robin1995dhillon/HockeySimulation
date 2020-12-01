package dhl.presentation.inputOutput;

public class InputOutputConcrete extends InputOutputAbstractFactory{

    IUserInput userInput;
    IUserOutput userOutput;


    @Override
    public IUserInput createUserInput() {
        if (userInput == null) {
            userInput = new UserInput();
        }
        return userInput;
    }

    @Override
    public void setUserInput(IUserInput userInput) {
        this.userInput = userInput;
    }

    @Override
    public IUserOutput createUserOutput() {
        if (userOutput == null) {
            userOutput = new UserOutput();
        }
        return userOutput;
    }

    @Override
    public void setUserOutput(IUserOutput userOutput) {
        this.userOutput = userOutput;
    }

}

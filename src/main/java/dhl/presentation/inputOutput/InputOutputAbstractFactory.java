package dhl.presentation.inputOutput;


public abstract class InputOutputAbstractFactory {

    private static InputOutputAbstractFactory instance = null;

    public static InputOutputAbstractFactory instance() {

        if (instance == null) {
            instance = new InputOutputConcrete();
        }
        return instance;
    }


    public abstract IUserInput createUserInput();

    public abstract void setUserInput(IUserInput userInput);

    public abstract IUserOutput createUserOutput();

    public abstract void setUserOutput(IUserOutput userOutput);
}

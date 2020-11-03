package dhl.internalStateMachine;


import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;

public class NestedStateContext {

    public static INestedState currentState;
    public String currentStateName;
    private static IUserOutput output;
    private static IUserInput input;
    public String currentDate;

    public NestedStateContext(IUserInput input, IUserOutput output) {
        this.currentStateName = "";
        NestedStateContext.input = input;
        NestedStateContext.output = output;
    }

    public void runState() {
        NestedStateContext.currentState.runState();
    }

    public void forward() {
        NestedStateContext.currentState.forward(this);
    }

    public void setState(INestedState state) {
        this.currentStateName = state.getStateName();
        NestedStateContext.currentState = state;
    }
}

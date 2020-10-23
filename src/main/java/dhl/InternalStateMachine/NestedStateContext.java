package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

public class NestedStateContext {

    public static ISimulationState currentState;
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

    public void setState(ISimulationState state) {
        this.currentStateName = state.getStateName();
        NestedStateContext.currentState = state;
    }
}

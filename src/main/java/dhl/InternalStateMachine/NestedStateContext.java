package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

public class NestedStateContext {

    public static ISimulationState currentState;
    public String currentStateName;
    private static IUserOutput output;
    private static IUserInput input;

    public NestedStateContext(IUserInput input, IUserOutput output) {
        this.currentStateName = "";
        this.input = input;
        this.output = output;
    }

    public void runState() {
        this.currentState.runState();
    }

    public void forward() {
        this.currentState.forward(this);
    }

    public void setState(ISimulationState state) {
        this.currentStateName = state.getStateName();
        this.currentState = state;
    }
}

package dhl.simulationStateMachine;


import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;

public class StateContext{
    private static IState currentState;
    private static IUserOutput output;
    private static IUserInput input;
    public String currentStateName;

    public StateContext(IUserInput input, IUserOutput output) {
        this.input = input;
        this.output = output;
        this.currentStateName = "";
    }

    public void forward() {
        this.currentState.forward(this);
    }

    public void setState(IState state) {
        this.currentStateName = state.getStateName();
        this.currentState = state;
    }

    public void runState() {
        this.currentState.runState();
    }

}

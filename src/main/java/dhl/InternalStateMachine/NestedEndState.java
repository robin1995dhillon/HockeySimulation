package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

public class NestedEndState implements ISimulationState {

    private static IUserInput input;
    private static IUserOutput output;
    private static String stateName;
    private static String nextStateName;


    public NestedEndState(IUserInput input, IUserOutput output) {
        this.input = input;
        this.output = output;
        this.stateName = "End";
    }

    public void forward(NestedStateContext context) {
        this.nextStateName = "None";
        return;
    }

    public void runState() {
        output.setOutput("Thanks for using our simulation :). See you around.");
        output.sendOutput();
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextStateName() {
        return this.nextStateName;
    }
}

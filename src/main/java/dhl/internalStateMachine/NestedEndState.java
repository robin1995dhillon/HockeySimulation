package dhl.internalStateMachine;


import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;

public class NestedEndState implements INestedState {

    private static IUserInput input;
    private static IUserOutput output;
    private static String stateName;
    private static String nextStateName;


    public NestedEndState(IUserInput input, IUserOutput output) {
        NestedEndState.input = input;
        NestedEndState.output = output;
        NestedEndState.stateName = "NestedEndState";
    }

    public void forward(NestedStateContext context) {
        NestedEndState.nextStateName = "None";
        return;
    }

    public void runState() {
        output.setOutput("Thanks for using our simulation :). See you around.");
        output.sendOutput();
    }

    public String getStateName() {
        return NestedEndState.stateName;
    }

    public String getNextState() {
        return NestedEndState.nextStateName;
    }
}
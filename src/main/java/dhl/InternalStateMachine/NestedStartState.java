package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

public class NestedStartState implements ISimulationState {

    private static IUserInput input;
    private static IUserOutput output;
    private static String teamName;
    public int numOfSeasons;
    private static String stateName;
    private static String nextStateName;

    public NestedStartState(IUserInput input, IUserOutput output, String teamName) {
        NestedStartState.input = input;
        NestedStartState.output = output;
        NestedStartState.teamName = teamName;
        NestedStartState.stateName = "Start";
        this.numOfSeasons = 0;
    }

    public void forward(NestedStateContext context) {
        NestedStartState.nextStateName = "Simulate";
        context.setState(new NestedSimulationState(input, output, numOfSeasons, teamName));
    }

    public void runState() {
        output.setOutput("How many seasons do you want to simulate?");
        output.sendOutput();

        input.setInput();
        this.numOfSeasons = Integer.parseInt(input.getInput());
    }

    public String getStateName() {
        return NestedStartState.stateName;
    }

    public String getNextState() {
        return NestedStartState.nextStateName;
    }

}

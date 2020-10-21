package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;

public class NestedSimulationState implements ISimulationState {

    private static IUserInput input;
    private static IUserOutput output;
    private static int totalSeasons;
    private static String teamName;
    private static String stateName;
    private static String nextStateName;

    public NestedSimulationState(IUserInput input, IUserOutput output, int seasons, String teamName) {
        NestedSimulationState.input = input;
        NestedSimulationState.output = output;
        NestedSimulationState.totalSeasons = seasons;
        NestedSimulationState.teamName = teamName;
        NestedSimulationState.stateName = "Simulate";
    }

    public void forward(NestedStateContext context) {
        //TODO: Hook it up to the nested machine scheduler
        NestedSimulationState.nextStateName = "End";
        context.setState(new NestedEndState(input, output));
    }

    public void runState() {
        for (int i = 1; i <= totalSeasons; i++) {
            output.setOutput("Simulating season " + i + " for " + teamName + " ...");
            output.sendOutput();
        }
    }

    public String getStateName() {
        return NestedSimulationState.stateName;
    }

    public String getNextState() {
        return NestedSimulationState.nextStateName;
    }

}

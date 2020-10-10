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
        this.input = input;
        this.output = output;
        this.totalSeasons = seasons;
        this.teamName = teamName;
        this.stateName = "Simulate";
    }

    public void forward(NestedStateContext context) {
        this.nextStateName = "End";
        context.setState(new NestedEndState(input, output));
    }

    public void runState() {
        for (int i = 1; i <= totalSeasons; i++) {
            output.setOutput("Simulating season " + i + " for " + teamName + " ...");
            output.sendOutput();
        }
    }

    public String getStateName() {
        return this.stateName;
    }

}

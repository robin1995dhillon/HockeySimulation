package dhl.SimulationStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InternalStateMachine.NestedStartState;
import dhl.InternalStateMachine.NestedStateContext;

public class SimulateLeagueState {
    private static IUserInput input;
    private static IUserOutput output;
    private static String teamName;

    public SimulateLeagueState(IUserInput input, IUserOutput output, String teamName) {
        this.input = input;
        this.output = output;
        this.teamName = teamName;
    }

    public void simulateLeague() {
        NestedStateContext stateContext = new NestedStateContext(input, output);
        stateContext.setState(new NestedStartState(input, output, teamName)); //Nested state machine start state
        stateContext.runState(); // Run the logic in the nested state
        stateContext.forward(); // Move forward to the next state i.e. Nested Sim State
        stateContext.runState(); // Run the logic in the nested state
        stateContext.forward(); // Move to the next state i.e. End State
        stateContext.runState(); // End state
    }
}

package dhl.InternalStateMachine;

public class CreateStanleyPlayoffsState implements ISimulationState {

    private static String stateName;
    private static String nextState;
    private static boolean finalDay;

    public CreateStanleyPlayoffsState() {
        CreateStanleyPlayoffsState.stateName = "CreateStanleyPlayoffsState";
        CreateStanleyPlayoffsState.nextState = "Training";
    }

    public void forward(NestedStateContext context) {
        //TODO: Set appropriate context.
    }

    public void runState() {
        //TODO: Execute state-related processes.
    }

    public String getStateName() {
        return CreateStanleyPlayoffsState.stateName;
    }

    public String getNextState() {
        return CreateStanleyPlayoffsState.nextState;
    }
}

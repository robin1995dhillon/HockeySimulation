package dhl.InternalStateMachine;

public class SimulatePlayoffsState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public SimulatePlayoffsState() {

        SimulatePlayoffsState.stateName = "SimulatePlayoffs";
        SimulatePlayoffsState.nextStateName = "InjuryCheck";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return SimulatePlayoffsState.stateName;
    }

    public String getNextState() {
        return SimulatePlayoffsState.nextStateName;
    }
}

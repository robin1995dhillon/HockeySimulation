package dhl.InternalStateMachine;

public class PersistState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public PersistState(boolean cupWinnerDeclared) {

        PersistState.stateName = "Persist";
        if (cupWinnerDeclared) {
            PersistState.nextStateName = "GenerateRegularSeasonSchedule";
        } else {
            PersistState.nextStateName = "AdvanceTime";
        }

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return PersistState.stateName;
    }

    public String getNextState() {
        return PersistState.nextStateName;
    }
}

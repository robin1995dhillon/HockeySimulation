package dhl.InternalStateMachine;

public class AdvanceToNextSeasonState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;
    private static boolean cupWinnerDeclared;

    public AdvanceToNextSeasonState(boolean cupWinnerDeclared) {

        AdvanceToNextSeasonState.stateName = "NextSeason";
        AdvanceToNextSeasonState.nextStateName = "Persist";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return AdvanceToNextSeasonState.stateName;
    }

    public String getNextState() {
        return AdvanceToNextSeasonState.nextStateName;
    }
}

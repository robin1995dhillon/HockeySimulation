package dhl.InternalStateMachine;

public class InjuryCheckState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public InjuryCheckState(boolean unPlayedGames, boolean tradedEnded) {

        InjuryCheckState.stateName = "InjuryCheck";

        if (unPlayedGames)
            InjuryCheckState.nextStateName = "SimulatePlayoffGame";
        else if (tradedEnded)
            InjuryCheckState.nextStateName = "AgePlayers";
        else
            InjuryCheckState.nextStateName = "TradePlayers";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return InjuryCheckState.stateName;
    }

    public String getNextState() {
        return InjuryCheckState.nextStateName;
    }
}

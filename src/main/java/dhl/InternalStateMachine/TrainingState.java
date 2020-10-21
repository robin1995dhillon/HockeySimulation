package dhl.InternalStateMachine;

public class TrainingState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public TrainingState(boolean unPlayedGames, boolean tradeEnded) {
        TrainingState.stateName = "Training";

        if (unPlayedGames) {
            TrainingState.nextStateName = "SimulatePlayoffs";
        } else if (tradeEnded)
            TrainingState.nextStateName = "AgePlayers";
        else
            TrainingState.nextStateName = "TradePlayers";

    }

    public void forward(NestedStateContext context) {
        //TODO: set appropriate context
    }

    public void runState() {
        //TODO: Execute state-related processing
    }

    public String getStateName() {
        return TrainingState.stateName;
    }

    public String getNextState() {
        return TrainingState.nextStateName;
    }
}

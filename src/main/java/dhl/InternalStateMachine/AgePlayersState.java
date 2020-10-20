package dhl.InternalStateMachine;

public class AgePlayersState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public AgePlayersState(boolean StanleyCupWinner) {

        AgePlayersState.stateName = "AgePlayers";
        if (StanleyCupWinner) {
            AgePlayersState.nextStateName = "NextSeason";
        } else {
            AgePlayersState.nextStateName = "Persist";
        }

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return AgePlayersState.stateName;
    }

    public String getNextState() {
        return AgePlayersState.nextStateName;
    }
}

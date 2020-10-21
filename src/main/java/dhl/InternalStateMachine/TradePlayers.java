package dhl.InternalStateMachine;

public class TradePlayers implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public TradePlayers() {

        TradePlayers.stateName = "TradePlayers";
        TradePlayers.nextStateName = "AgePlayers";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return TradePlayers.stateName;
    }

    public String getNextState() {
        return TradePlayers.nextStateName;
    }

}

package dhl.InternalStateMachine;

public class AdvanceTimeState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;
    private static boolean lastDayOfSeason;

    public AdvanceTimeState(boolean lastDayOfSeason) {
        AdvanceTimeState.stateName = "AdvanceTime";

        if (lastDayOfSeason)
            AdvanceTimeState.nextStateName = "CreateStanleyPlayoffs";
        else
            AdvanceTimeState.nextStateName = "Training";

    }

    public void forward(NestedStateContext context) {
        //TODO:set appropriate context
//        if (nextStateName=="CreateStanleyPlayoffs")
//            context.setState(new CreateStanleyPlayoffsState());
//        else
//            context.setState(new TrainingState(unPlayedGames, tradeEnded));
    }

    public void runState() {
        //TODO:state related processsing
    }

    public String getStateName() {
        return AdvanceTimeState.stateName;
    }

    public String getNextState() {
        return AdvanceTimeState.nextStateName;
    }
}

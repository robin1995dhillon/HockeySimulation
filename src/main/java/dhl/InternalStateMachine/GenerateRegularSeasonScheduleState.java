package dhl.InternalStateMachine;

public class GenerateRegularSeasonScheduleState implements ISimulationState {

    private static String stateName;
    private static String nextStateName;

    public GenerateRegularSeasonScheduleState() {
        GenerateRegularSeasonScheduleState.stateName = "GenerateRegularSeasonSchedule";
        GenerateRegularSeasonScheduleState.nextStateName = "ToBeDetermined";

    }

    public void forward(NestedStateContext context) {

    }

    public void runState() {

    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }

}

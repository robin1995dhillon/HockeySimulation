package dhl.InternalStateMachine;


public interface ISimulationState {
    public void forward(NestedStateContext context);

    public void runState();

    public String getStateName();
}

package dhl.internalStateMachine;


public interface INestedState {
    public void forward(NestedStateContext context);

    public void runState();

    public String getStateName();

    public String getNextState();
}
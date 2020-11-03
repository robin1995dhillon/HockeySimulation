package dhl.simulationStateMachine;

public interface IState {
    public void forward(StateContext context);

    public void runState();

    public String getStateName();

    public String getNextState();
}


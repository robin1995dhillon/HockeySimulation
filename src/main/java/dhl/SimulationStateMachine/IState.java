package dhl.SimulationStateMachine;

import dhl.InternalStateMachine.NestedStateContext;

public interface IState {
    public void forward(StateContext context);

    public void runState();

    public String getStateName();

    public String getNextState();
}


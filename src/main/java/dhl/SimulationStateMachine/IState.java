package dhl.SimulationStateMachine;

public interface IState {
    public void stepForward();

    public void doWork();
}
//TODO Implement concrete classes implementing this interface.

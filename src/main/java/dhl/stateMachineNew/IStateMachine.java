package dhl.stateMachineNew;

public interface IStateMachine {

    void entry();
    IStateMachine doTask();
    void exit();
}

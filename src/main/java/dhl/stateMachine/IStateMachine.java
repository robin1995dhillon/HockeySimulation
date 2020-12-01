package dhl.stateMachine;

public interface IStateMachine {

    IStateMachine entry() throws Exception;
    IStateMachine doTask() throws Exception;
    void exit();
}

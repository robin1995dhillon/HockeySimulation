package dhl.stateMachineNew.states;

import dhl.stateMachineNew.IStateMachine;

public class PersistState implements IStateMachine {
    public IStateMachine entry() {

        return doTask();
    }

    public IStateMachine doTask() {

        return null;
    }

    public void exit() {

    }
}

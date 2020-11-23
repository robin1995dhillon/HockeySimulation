package dhl.stateMachineNew;

public class TrainingState implements IStateMachine{

    StateMachine machine;

    public TrainingState(StateMachine machine){
        this.machine = machine;
    }
    public void entry() {

    }

    public IStateMachine doTask() {

        return null;
    }

    public void exit() {

    }
}

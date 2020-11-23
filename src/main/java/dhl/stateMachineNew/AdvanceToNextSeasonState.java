package dhl.stateMachineNew;

public class AdvanceToNextSeasonState implements IStateMachine{

    StateMachine machine;

    public AdvanceToNextSeasonState(StateMachine stateMachine){

        this.machine = stateMachine;

    }

    public void entry() {

    }

    public IStateMachine doTask() {

        ISchedulerSeason season = new SchedulerSeason();
        String date = machine.getLeague().getDate();
       // String simulationDate = season.
        return null;
    }

    public void exit() {

    }
}

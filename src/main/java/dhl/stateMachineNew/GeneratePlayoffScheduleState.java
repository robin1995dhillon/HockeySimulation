package dhl.stateMachineNew;

import java.text.ParseException;

public class GeneratePlayoffScheduleState implements IStateMachine{

    StateMachine machine;

    public GeneratePlayoffScheduleState(StateMachine stateMachine){
        this.machine = stateMachine;
    }

    public void entry() throws ParseException {
        doTask();

    }

    public IStateMachine doTask() throws ParseException {

        ISchedulerSeason scheduler = new SchedulerSeason();
        scheduler.playoffSchedule(machine);

        return machine.getTraining();
    }

    public void exit() {

    }
}

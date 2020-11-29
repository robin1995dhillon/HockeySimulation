package dhl.stateMachineNew;

import java.text.ParseException;

public class GeneratePlayoffScheduleState implements IStateMachine{

    StateMachine machine;

    public GeneratePlayoffScheduleState(StateMachine stateMachine){
        this.machine = stateMachine;
    }

    public IStateMachine entry() throws ParseException {

        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        ISchedulerSeason scheduler = new SchedulerSeason();
        scheduler.playoffSchedule(machine);

        return machine.getTraining();
    }

    public void exit() {

    }
}

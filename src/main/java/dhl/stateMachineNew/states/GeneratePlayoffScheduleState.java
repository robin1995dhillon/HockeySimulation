package dhl.stateMachineNew.states;

import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.SchedulerSeason;
import dhl.stateMachineNew.StateMachine;

import java.text.ParseException;

public class GeneratePlayoffScheduleState implements IStateMachine {

    StateMachine machine;

    public GeneratePlayoffScheduleState(StateMachine stateMachine){
        this.machine = stateMachine;
    }

    public IStateMachine entry() throws ParseException {
        System.out.println("We are in Game Play Off Schedule State");
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

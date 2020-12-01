package dhl.stateMachine.states;

import dhl.stateMachine.*;

import java.text.ParseException;

public class GeneratePlayoffScheduleState implements IStateMachine {

    StateMachine machine;
    StateMachineAbstractFactory stateMachineAbstractFactory;
    ISchedulerSeason schedulerSeason;

    public GeneratePlayoffScheduleState(StateMachine stateMachine){
        this.machine = stateMachine;
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        schedulerSeason = stateMachineAbstractFactory.getSchedulerSeason();
    }

    public IStateMachine entry() throws ParseException {
        return doTask();
    }

    public IStateMachine doTask() throws ParseException {
        schedulerSeason.playoffSchedule(machine);
        return machine.getTraining();
    }

    public void exit() {
    }
}

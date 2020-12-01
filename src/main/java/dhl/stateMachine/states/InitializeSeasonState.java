package dhl.stateMachine.states;

import dhl.stateMachine.*;

import java.text.ParseException;

public class InitializeSeasonState implements IStateMachine {
    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    StateMachineAbstractFactory stateMachineAbstractFactory;

    public InitializeSeasonState(StateMachine stateMachine) {
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        this.machine = stateMachine;
        schedulerSeason = stateMachineAbstractFactory.getSchedulerSeason();
    }

    public IStateMachine entry() throws ParseException {
        return doTask();
    }

    public IStateMachine doTask() throws ParseException {
        schedulerSeason.generateSchedule(machine);
        return machine.getAdvanceTime();
    }

    public void exit() {

    }
}

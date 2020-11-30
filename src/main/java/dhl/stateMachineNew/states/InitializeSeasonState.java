package dhl.stateMachineNew.states;

import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.SchedulerSeason;
import dhl.stateMachineNew.StateMachine;

import java.text.ParseException;

public class InitializeSeasonState implements IStateMachine {

    StateMachine machine;

    public InitializeSeasonState(StateMachine stateMachine) {
        this.machine = stateMachine;

    }

    public IStateMachine entry() throws ParseException {
        System.out.println("We are in Initialize Season State");

        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        ISchedulerSeason schedule = new SchedulerSeason();
        //schedule.generateSchedule(machine);
        //return machine.getAdvanceTime();
        return machine.getPlayerDraft();
    }

    public void exit() {

    }
}

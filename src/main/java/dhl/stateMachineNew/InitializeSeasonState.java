package dhl.stateMachineNew;

import java.text.ParseException;

public class InitializeSeasonState implements IStateMachine {

    StateMachine machine;

    public InitializeSeasonState(StateMachine stateMachine) {
        this.machine = stateMachine;

    }

    public IStateMachine entry() throws ParseException {


        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        ISchedulerSeason schedule = new SchedulerSeason();
        schedule.generateSchedule(machine);
        return machine.getAdvanceTime();
    }

    public void exit() {

    }
}

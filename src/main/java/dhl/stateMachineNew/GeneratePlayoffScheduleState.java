package dhl.stateMachineNew;

import java.text.ParseException;

public class GeneratePlayoffScheduleState implements IStateMachine{

    StateMachine machine;

    public GeneratePlayoffScheduleState(StateMachine stateMachine){
        this.machine = stateMachine;
    }

    public void entry() {

    }

    public IStateMachine doTask() throws ParseException {

        ISchedulerSeason scheduler = new SchedulerSeason();
        scheduler.playoffSchedule(machine);

        return null;
    }

    public void exit() {

    }
}

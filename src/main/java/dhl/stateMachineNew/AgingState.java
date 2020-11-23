package dhl.stateMachineNew;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;

import java.text.ParseException;
import java.util.Collections;

public class AgingState implements IStateMachine{

    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    private IUserOutput output;

    AgingState(StateMachine stateMachine){
        this.machine = stateMachine;
        schedulerSeason = new SchedulerSeason();
        output = new UserOutput();
    }

    public void entry() {

    }

    public IStateMachine doTask() throws ParseException {

        String currentDate = machine.getLeague().getDate();
        String endDate = schedulerSeason.getLastDayOfStanleyPlayoffs();
        if(currentDate.equalsIgnoreCase(endDate)){
            machine.getLeague().getTeamStandingList().sort(Collections.reverseOrder((team1, team2)-> Integer.compare(team1.getTotalPoints(),team2.getTotalPoints())));
            output.setOutput("Winner of Stanley cup season "+(machine.getLeague().getSeason()+1)+" is : "+machine.getLeague().getTeamStandingList().get(0).getTeam().getTeamName());
            output.sendOutput();
            machine.setCurrentState(machine.getAdvanceToNextSeason());
            machine.getCurrentState().entry();
            return machine.getInitializeSeason();
        }
        else{
            return machine.getAdvanceTime();
        }
    }

    public void exit() {

    }
}

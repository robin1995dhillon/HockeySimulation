package dhl.stateMachineNew;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.IAllPlayers;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.text.ParseException;
import java.util.Collections;

public class AgingState implements IStateMachine{

    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    private IUserOutput output;
   // private List<ITeam> allTeams;

    AgingState(StateMachine stateMachine){
        this.machine = stateMachine;
        schedulerSeason = new SchedulerSeason();
        output = new UserOutput();
       // this.allTeams = this.machine.getTotalTeamList();
    }

    public IStateMachine entry() throws ParseException {
        for(ITeam team : this.machine.getTotalTeamList()){
            for(IPlayers player : team.getPlayers()){
                player.agePlayer(1,this.machine.getLeague().getGameplayConfig());
            }
        }
//        for(IFreeAgents agent : machine.getLeague().getFreeAgents()){
//            //age free agent
//        }
        for(IAllPlayers agent: machine.getLeague().getFreeAgents2()) {
            agent.agePlayer(1, this.machine.getLeague().getGameplayConfig());
        }

        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        String currentDate = machine.getLeague().getDate();
        String endDate = schedulerSeason.getLastDayOfStanleyPlayoffs();
        if(currentDate.equalsIgnoreCase(endDate)){
            machine.getLeague().getTeamStandingList().sort(Collections.reverseOrder((team1, team2)-> Integer.compare(team1.getTotalPoints(),team2.getTotalPoints())));
            output.setOutput("Winner of Stanley cup season "+(machine.getLeague().getSeason()+1)+" is : "+machine.getLeague().getTeamStandingList().get(0).getTeam().getTeamName());
            output.sendOutput();
//            machine.setCurrentState(machine.getAdvanceToNextSeason());
//            machine.getCurrentState().entry();
            return machine.getAdvanceToNextSeason();
        }
        else{
            return machine.getAdvanceTime();
        }
    }

    public void exit() {

    }
}

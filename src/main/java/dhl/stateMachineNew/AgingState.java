package dhl.stateMachineNew;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public class AgingState implements IStateMachine{

    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    private IUserOutput output;
    private List<ITeam> allTeams;

    AgingState(StateMachine stateMachine, List<ITeam> allTeams){
        this.machine = stateMachine;
        schedulerSeason = new SchedulerSeason();
        output = new UserOutput();
        this.allTeams = allTeams;
    }

    public void entry() throws ParseException {
        for(ITeam team : allTeams){
            for(IPlayers player : team.getPlayers()){
                player.agePlayer(1);
            }
        }
        for(IFreeAgents agent : machine.getLeague().getFreeAgents()){
            //age free agent
        }
        doTask();

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

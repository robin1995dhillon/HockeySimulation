package dhl.stateMachineNew.states;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.IAllPlayers;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.SchedulerSeason;
import dhl.stateMachineNew.StateMachine;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgingState implements IStateMachine {

    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    private IUserOutput output;
   // private List<ITeam> allTeams;

    public AgingState(StateMachine stateMachine){
        this.machine = stateMachine;
        schedulerSeason = new SchedulerSeason();
        output = new UserOutput();
       // this.allTeams = this.machine.getTotalTeamList();
    }

    public IStateMachine entry() throws ParseException {
        System.out.println("We are in Aging State");
        List<IFreeAgents> newFreeAgentList = new ArrayList<>();
        for(ITeam team : this.machine.getTotalTeamList()){
            for(IPlayers player : team.getPlayers()){
                player.agePlayer(1,this.machine.getLeague().getGameplayConfig());
                if(player.isRetired()) {
                    IFreeAgents freeAgents = player.replacePlayerWithFreeAgent(player,machine.getLeague().getFreeAgents());
                    IPlayers players = player.convertFreeAgentToPlayer(freeAgents);
                    team.addPlayerToTeam(players);
                }
            }
        }
        for(IFreeAgents agent: machine.getLeague().getFreeAgents()) {
            agent.agePlayer(1, this.machine.getLeague().getGameplayConfig());
            if(agent.isRetired()) {
                newFreeAgentList = agent.retireFreeAgents(machine.getLeague().getFreeAgents());
            }
        }

        machine.getLeague().setFreeAgents(newFreeAgentList);

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

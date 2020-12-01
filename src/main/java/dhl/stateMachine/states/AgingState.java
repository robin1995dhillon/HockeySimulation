package dhl.stateMachine.states;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.stateMachine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class AgingState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(AgingState.class);
    StateMachine machine;
    ISchedulerSeason schedulerSeason;
    private IUserOutput output;
    private InputOutputAbstractFactory inputOutputAbstractFactory;
    StateMachineAbstractFactory stateMachineAbstractFactory;
    public AgingState(StateMachine stateMachine){
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.machine = stateMachine;
        schedulerSeason = stateMachineAbstractFactory.getSchedulerSeason();
        output = inputOutputAbstractFactory.createUserOutput();
    }

    public IStateMachine entry() {
        List<ITeam> allTeams = machine.getTotalTeamList();
        for(int i = 0; i < allTeams.size(); i++) {
            List<IPlayers> players = allTeams.get(i).getPlayers();
            for(int j = 0; j < players.size(); j++) {
                players.get(j).agePlayer(1, this.machine.getLeague().getGameplayConfig());
                if(players.get(j).isRetired()) {
                    output.setOutput("Player RETIRED - " + players.get(j).getPlayerName());
                    output.sendOutput();
                    logger.info(players.get(j).getPlayerName() + " is going to retire.");
                    IFreeAgents convertedFreeAgent = players.get(j).replacePlayerWithFreeAgent(players.get(j),machine.getLeague().getFreeAgents());
                    output.setOutput("Selected Free Agent is (For Replacement) - " + convertedFreeAgent.getPlayerName());
                    output.sendOutput();
                    IPlayers playerToBeAdded = players.get(j).convertFreeAgentToPlayer(convertedFreeAgent);
                    allTeams.get(i).addPlayerToTeam(playerToBeAdded);
                    allTeams.get(i).removePlayerFromTeam(players.get(j));
                    machine.getLeague().setFreeAgents(convertedFreeAgent.removeFreeAgents(machine.getLeague().getFreeAgents()));
                    logger.info(players.get(j).getPlayerName() + " is going to retire. He will be replaced by " + playerToBeAdded.getPlayerName());
                }
            }
        }
        List<IFreeAgents> freeAgentList = machine.getLeague().getFreeAgents();
        for(int i = 0; i < freeAgentList.size(); i++) {
            freeAgentList.get(i).agePlayer(1, this.machine.getLeague().getGameplayConfig());
            if(freeAgentList.get(i).isRetired()) {
                machine.getLeague().setFreeAgents(freeAgentList.get(i).removeFreeAgents(machine.getLeague().getFreeAgents()));
            }
        }

        return doTask();
    }

    public IStateMachine doTask() {

        String currentDate = machine.getLeague().getDate();
        String endDate = schedulerSeason.getLastDayOfStanleyPlayoffs();
        if(currentDate.equalsIgnoreCase(endDate)){
            machine.getLeague().getTeamStandingList().sort(Collections.reverseOrder((team1, team2)-> Integer.compare(team1.getTotalPoints(),team2.getTotalPoints())));
            output.setOutput("Winner of Stanley cup season "+(machine.getLeague().getSeason()+1)+" is : "+machine.getLeague().getTeamStandingList().get(0).getTeam().getTeamName());
            output.sendOutput();
            logger.info("Winner of Stanley cup season " + (machine.getLeague().getSeason() + 1) + " is " + machine.getLeague().getTeamStandingList().get(0).getTeam().getTeamName());
            return machine.getAdvanceToNextSeason();
        }
        else{
            return machine.getAdvanceTime();
        }
    }

    public void exit() {

    }
}

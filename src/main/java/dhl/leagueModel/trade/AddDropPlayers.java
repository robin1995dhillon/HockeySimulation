package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.leagueModel.*;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.StateMachine;
import dhl.stateMachineNew.StateMachineAbstractFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddDropPlayers implements IAddDropPlayers {

    private IFreeAgentListAdd freeAgentLists;
    private IFreeAgentListDrop freeAgentListsDrop;
    private int totalGoalies;
    private int totalForward;
    private int totalDefense;
    private StateMachine stateMachine;
    private IAllPlayers allPlayers;

    public AddDropPlayers() {
        allPlayers = new AllPlayers();
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        totalGoalies = Integer.parseInt(Configurables.TOTAL_GOALIES.getAction());
        totalDefense = Integer.parseInt(Configurables.TOTAL_DEFENSE.getAction());
        totalForward = Integer.parseInt(Configurables.TOTAL_FORWARD.getAction());

        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
    public void addDropPlayers(ITeam team, int totalPlayers) {

        int noOfGoalies = 0;
        int noOfForwards = 0;
        int noOfDefense = 0;


        for (IPlayers player : team.getPlayers()) {
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                noOfGoalies++;
            } else if (player.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction())) {
                noOfForwards++;
            } else if (player.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())) {
                noOfDefense++;
            }
        }

            if (noOfGoalies > totalGoalies) {
                hireFreeAgents(team, noOfGoalies - totalGoalies, Configurables.GOALIE.getAction());
            } else if (noOfGoalies < totalGoalies) {
                dropToFreeAgents(team,totalGoalies - noOfGoalies, Configurables.GOALIE.getAction());
            }
            if (noOfDefense > totalDefense) {
                hireFreeAgents(team, noOfDefense - totalDefense, Configurables.DEFENSE.getAction());
            } else if (noOfDefense < totalDefense) {
                dropToFreeAgents(team,totalDefense - noOfDefense, Configurables.DEFENSE.getAction());
            }
            if (noOfForwards > totalForward) {
                hireFreeAgents(team, noOfForwards - totalForward, Configurables.FORWARD.getAction());
            } else if (noOfForwards < totalForward) {
                dropToFreeAgents(team,totalForward - noOfForwards, Configurables.FORWARD.getAction());
            }

//        int playersToBeAdded;
//        int playersToBeDropped;
//        int totalNumberOfPlayers = Integer.parseInt(Configurables.TOTAL_PLAYERS.getAction());
//
//        if (totalPlayers < totalNumberOfPlayers) {
//            playersToBeAdded = totalNumberOfPlayers - totalPlayers;
//
//            freeAgentLists.aiAgentListAdd(team, playersToBeAdded);
//        } else if (totalPlayers > totalNumberOfPlayers) {
//
//            playersToBeDropped = totalPlayers - totalNumberOfPlayers;
//            freeAgentListsDrop.agentListDrop(team, playersToBeDropped);
//        }
        }


    public void dropToFreeAgents(ITeam team, int count, String position) {
        List<IPlayers> players = new ArrayList<>(team.getPlayers());
        List<IPlayers> playersToBeDropped = new ArrayList<>();
        players.sort(Comparator.comparingDouble(IPlayers::calculateStrength));
        int playersCount = 0;
        for (IPlayers player: players){
            if (player.getPosition().equalsIgnoreCase(position)){
                playersCount++;
                playersToBeDropped.add(player);
                if (playersCount == count){
                    break;
                }
            }
        }
        for (int i=0; i< playersToBeDropped.size(); i++){
            stateMachine.getLeague().getFreeAgents()
                    .add(allPlayers.convertPlayerToFreeAgent(playersToBeDropped.get(i)));
        }
        team.getPlayers().removeAll(playersToBeDropped);
    }


    public void hireFreeAgents(ITeam team, int count, String position) {
        List<IFreeAgents> freeAgents = new ArrayList<>(stateMachine.getLeague().getFreeAgents());
        List<IFreeAgents> freeAgentsToBeHired = new ArrayList<>();
        freeAgents.sort(Comparator.comparingDouble(IFreeAgents::calculateStrength).reversed());
        int freeAgentsCount = 0;
        for (IFreeAgents freeAgent: freeAgents){
            if (freeAgent.getPosition().equalsIgnoreCase(position)){
                freeAgentsCount++;
                freeAgentsToBeHired.add(freeAgent);
                if (freeAgentsCount == count){
                    break;
                }
            }
        }
        for (int i=0; i< freeAgentsToBeHired.size(); i++){
            team.addPlayerToTeam(allPlayers.convertFreeAgentToPlayer(freeAgentsToBeHired.get(i)));
        }
        stateMachine.getLeague().getFreeAgents().removeAll(freeAgentsToBeHired);
    }
}

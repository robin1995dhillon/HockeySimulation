package dhl.Trade;

import dhl.LeagueModel.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.players.PlayersStrength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FreeAgentListDrop implements iFreeAgentListDrop{

    private PlayersStrength playerStrength;
    private FreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private Players playerToDrop;



    FreeAgentListDrop(){
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToDrop = new Players();
        playerStrength = new PlayersStrength();

    }

    @Override
    public void agentListDrop(ITeam2 team, int playersToBeDropped) {
        int goalieCount=0;
        for(IPlayers p:team.getPlayers()){
            if(p.getPosition().equalsIgnoreCase("goalie")) {
                goalieCount++;
            }
        }
        if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("ai")){
            dropSkater(team.getPlayers(),playersToBeDropped);
        }
        else if(goalieCount>2 && team.getTeamType().equalsIgnoreCase("ai")){
            dropGoalie(team.getPlayers(),goalieCount);
        }
        else if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("user")){

            //addSkaterUser
        }

        else if(goalieCount>2 && team.getTeamType().equalsIgnoreCase("user")){
            //addGoalieUser
        }



    }

    @Override
    public void dropSkater(List<IPlayers> players, int playersToBeDropped) {
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        playerList = sortedPLayerSkaterList(players,playersToBeDropped);

        for(IPlayers p: playerList){
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);

        }

    }

    @Override
    public void dropGoalie(List<IPlayers> players, int goalieCount) {

        int goaliesToBeDropped =goalieCount - 2;
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> goalieList = new ArrayList<>();
        goalieList = sortedPLayerGoalieList(players,goaliesToBeDropped);
        for(IPlayers p: goalieList){
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);

        }

    }

    public List<IPlayers> sortedPLayerSkaterList(List<IPlayers> players, int playersToBeDropped){
        List<IPlayers> playerSkaterList = new ArrayList<>();
        for(IPlayers p: players){
            if(p.getPosition().equalsIgnoreCase("goalie")){
                continue;
            }
            else{
                playerSkaterList.add(p);
            }
        }
        Collections.sort(playerSkaterList,(p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2)));
        return playerSkaterList.subList(0,playersToBeDropped);
    }

    public List<IPlayers> sortedPLayerGoalieList(List<IPlayers> players,int goaliesToBeDropped){
        List<IPlayers> playerGoalieList = new ArrayList<>();
        for(IPlayers p: players){
            if(p.getPosition().equalsIgnoreCase("goalie")){
                playerGoalieList.add(p);
            }

        }
        Collections.sort(playerGoalieList,(p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2)));
        return playerGoalieList.subList(0,goaliesToBeDropped);
    }
}

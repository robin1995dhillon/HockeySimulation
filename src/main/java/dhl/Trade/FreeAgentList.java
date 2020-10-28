package dhl.Trade;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.players.PlayersStrength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class FreeAgentList implements iFreeAgentListAdd{
    private PlayersStrength playerStrength;
    private FreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private Players playerToAdd;



    FreeAgentList(){
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToAdd = new Players();
        playerStrength = new PlayersStrength();

    }

    @Override
    public void aiAgentListAdd(ITeam2 team, int playersToBeAdded) {

        int goalieCount=0;
        for(IPlayers p:team.getPlayers()){
            if(p.getPosition().equalsIgnoreCase("goalie")) {
                goalieCount++;
            }
        }
        if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("ai")){
            addSkater(team.getPlayers(),playersToBeAdded);
        }
        else if(goalieCount<2 && team.getTeamType().equalsIgnoreCase("ai")){
            addGoalie(team.getPlayers(),goalieCount);
        }
        else if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("user")){

            //addSkaterUser
        }

        else if(goalieCount<2 && team.getTeamType().equalsIgnoreCase("user")){
            //addGoalieUser
        }

    }

    public void addSkater(List<IPlayers> players, int playersToBeAdded){
        IPlayers agentToPlayer = new Players();
        List<IFreeAgents> agentList = new ArrayList<>();
        agentList = sortedAgentsSkaterList(playersToBeAdded);

        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            players.add(agentToPlayer);

        }

    }

    public void addGoalie(List<IPlayers> players, int goalieCount){

        int goaliesToBeAdded = 2- goalieCount;
        IPlayers agentToPlayer = new Players();
        List<IFreeAgents> agentList = new ArrayList<>();
        agentList = sortedAgentsGoalieList(goaliesToBeAdded);
        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            players.add(agentToPlayer);

        }

    }

    public List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded){
        List<IFreeAgents> agentSkaterList = new ArrayList<>();
        for(IFreeAgents a: availableAgents){
            if(a.getPosition().equalsIgnoreCase("goalie")){
                continue;
            }
            else{
                agentSkaterList.add(a);
            }
        }
        Collections.sort(agentSkaterList, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1),agents.calculateStrength(p2))));
        return agentSkaterList.subList(0,playersToBeAdded);
    }

     public List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded){
         List<IFreeAgents> agentGoalieList = new ArrayList<>();
         for(IFreeAgents a: availableAgents){
             if(a.getPosition().equalsIgnoreCase("goalie")){
                 agentGoalieList.add(a);
             }

         }
         Collections.sort(agentGoalieList, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1),agents.calculateStrength(p2))));
         return agentGoalieList.subList(0,goaliesToBeAdded);
     }


     //continue this
     public void addSkaterUser(List<IPlayers> players, int playersToBeAdded){
         Scanner sc = new Scanner(System.in);

         IPlayers agentToPlayer = new Players();
         List<IFreeAgents> agentList = new ArrayList<>();
         agentList = sortedAgentsSkaterList(playersToBeAdded);


     }
}

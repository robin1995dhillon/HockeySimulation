package dhl.Trade;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.players.PlayersStrength;
import dhl.Presentation.TradePrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FreeAgentList implements iFreeAgentListAdd {
    private PlayersStrength playerStrength;
    private FreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private Players playerToAdd;
    private TradePrompt prompt;


    public FreeAgentList() {
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToAdd = new Players();
        playerStrength = new PlayersStrength();
        prompt = new TradePrompt();
    }

    @Override
    public void aiAgentListAdd(ITeam team, int playersToBeAdded) {

        int goalieCount = 0;
        for (IPlayers p : team.getPlayers()) {
            if (p.getPosition().equalsIgnoreCase("goalie")) {
                goalieCount++;
            }
        }
        if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase("ai")) {
            addSkater(team.getPlayers(), playersToBeAdded);
        } else if (goalieCount < 2 && team.getTeamType().equalsIgnoreCase("ai")) {
            addGoalie(team.getPlayers(), goalieCount);
        } else if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase("user")) {

            addSkaterUser(team.getPlayers(), playersToBeAdded);

        } else if (goalieCount < 2 && team.getTeamType().equalsIgnoreCase("user")) {

            addGoalieUser(team.getPlayers(), playersToBeAdded);
        }

    }

    public void addSkater(List<IPlayers> player, int playersToBeAdded) {
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        agentList = sortedAgentsSkaterList(playersToBeAdded);

        for (IFreeAgents a : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            player.add(agentToPlayer);
            availableAgents.remove(a);

        }

    }

    public void addGoalie(List<IPlayers> player, int goalieCount) {

        int goaliesToBeAdded = 2 - goalieCount;
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        agentList = sortedAgentsGoalieList(goaliesToBeAdded);
        for (IFreeAgents a : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            player.add(agentToPlayer);
            availableAgents.remove(a);
        }

    }

    public List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded) {
        List<IFreeAgents> agentSkaterList = new ArrayList<>();
        for (IFreeAgents a : availableAgents) {
            if (a.getPosition().equalsIgnoreCase("goalie")) {
                continue;
            } else {
                agentSkaterList.add(a);
            }
        }
        Collections.sort(agentSkaterList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(p1), p2.calculateStrength(p2))));
        return agentSkaterList.subList(0, playersToBeAdded);
    }

    public List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded) {
        List<IFreeAgents> agentGoalieList = new ArrayList<>();
        for (IFreeAgents a : availableAgents) {
            if (a.getPosition().equalsIgnoreCase("goalie")) {
                agentGoalieList.add(a);
            }
        }
        Collections.sort(agentGoalieList, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1), agents.calculateStrength(p2))));
        return agentGoalieList.subList(0, goaliesToBeAdded);
    }


    public void addSkaterUser(List<IPlayers> player, int playersToBeAdded) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String agentAddName;
        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList;

        agentList = strongestAgentsList(availableAgents);

        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeAdded != 0) {
            System.out.println("Enter Free Agent name To add");
            agentAddName = sc.nextLine();

            for(IFreeAgents a: agentList) {
                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if(a.getPosition().equalsIgnoreCase("goalie")){
                        System.out.println("Cannot select goalie");
                        continue;
                    }
                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
                    player.add(agentToPlayer);
                    playersToBeAdded--;
                    availableAgents.remove(a);
                    flag = false;
                    break;
                }
                else {
                    flag=true;
                    continue;
                }
            }
            if(flag){
                System.out.println("invalid! try again");
            }
        }
    }

    public void addGoalieUser(List<IPlayers> player, int playersToBeAdded) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String agentAddName;
        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList;

        agentList = strongestAgentsList(availableAgents);

        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeAdded != 0) {
            System.out.println("Enter Free Agent name To add");
            agentAddName = sc.nextLine();

            for(IFreeAgents a: agentList) {
                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if(a.getPosition().equalsIgnoreCase("goalie")){

                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
                    player.add(agentToPlayer);
                    playersToBeAdded--;
                    availableAgents.remove(a);
                    flag = false;
                    break;
                    }
                }
                else {
                    flag=true;

                }
            }
            if(flag){
                System.out.println("invalid! try again");
            }
        }

    }

    public boolean checkPlayerInList(List<IPlayers> playerList,String agentName){
        for(IPlayers p: playerList){
            if(agentName.equalsIgnoreCase(p.getPlayerName())){
                return true;
            }
        }
        return false;
    }

    public List<IFreeAgents> strongestAgentsList(List<IFreeAgents> list){

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1), agents.calculateStrength(p2))));
        return list;
    }

    public List<IPlayers> strongestPlayersList(List<IPlayers> list){

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2))));
        return list;
    }
}

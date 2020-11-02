package dhl.trade;

import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.players.PlayersStrength;
import dhl.presentation.TradePrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeAgentList implements iFreeAgentListAdd {
    private PlayersStrength playerStrength;
    private FreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private Players playerToAdd;
    private TradePrompt prompt;
    private UserOutput userOutput;
    private UserInput userInput;


    public FreeAgentList() {
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToAdd = new Players();
        playerStrength = new PlayersStrength();
        prompt = new TradePrompt();
        userOutput = new UserOutput();
        userInput = new UserInput();
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
            userOutput.setOutput("Enter Free Agent name To add");
            userOutput.sendOutput();
            userInput.setInput();
            agentAddName = userInput.getInput();

            for(IFreeAgents a: agentList) {
                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if(a.getPosition().equalsIgnoreCase("goalie")){
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
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
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
    }

    public void addGoalieUser(List<IPlayers> player, int playersToBeAdded) {
        boolean flag = false;
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
            userOutput.setOutput("Enter Free Agent name To add");
            userOutput.sendOutput();
            userInput.setInput();
            agentAddName = userInput.getInput();


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
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
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

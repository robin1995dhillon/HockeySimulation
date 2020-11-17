package dhl.trade;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.Configurables;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeAgentList implements IFreeAgentListAdd {
    private IPlayers playerStrength;
    private IFreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private IPlayers playerToAdd;
    private ITradePrompt prompt;
    private IUserOutput userOutput;
    private IUserInput userInput;


    public FreeAgentList() {
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToAdd = new Players();
        playerStrength = new Players();
        prompt = new TradePrompt();
        userOutput = new UserOutput();
        userInput = new UserInput();
    }

    @Override
    public void aiAgentListAdd(ITeam team, int playersToBeAdded) {

        int goalieCount = 0;
        for (IPlayers player : team.getPlayers()) {
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                goalieCount++;
            }
        }
        if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            addSkater(team.getPlayers(), playersToBeAdded);
        } else if (goalieCount < 2 && team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            addGoalie(team.getPlayers(), goalieCount);
        } else if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            addSkaterUser(team.getPlayers(), playersToBeAdded);
        } else if (goalieCount < 2 && team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            addGoalieUser(team.getPlayers(), playersToBeAdded);
        }

    }

    public void addSkater(List<IPlayers> player, int playersToBeAdded) {
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        agentList = sortedAgentsSkaterList(playersToBeAdded);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            player.add(agentToPlayer);
            availableAgents.remove(agent);

        }

    }

    public void addGoalie(List<IPlayers> player, int goalieCount) {

        int goaliesToBeAdded = 2 - goalieCount;
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        agentList = sortedAgentsGoalieList(goaliesToBeAdded);
        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            player.add(agentToPlayer);
            availableAgents.remove(agent);
        }

    }

    public List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded) {
        List<IFreeAgents> agentSkaterList = new ArrayList<>();
        for (IFreeAgents agent : availableAgents) {
            if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                continue;
            } else {
                agentSkaterList.add(agent);
            }
        }
        Collections.sort(agentSkaterList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(p1), p2.calculateStrength(p2))));
        return agentSkaterList.subList(0, playersToBeAdded);
    }

    public List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded) {
        List<IFreeAgents> agentGoalieList = new ArrayList<>();
        for (IFreeAgents agent : availableAgents) {
            if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                agentGoalieList.add(agent);
            }
        }
        Collections.sort(agentGoalieList, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1), agents.calculateStrength(p2))));
        return agentGoalieList.subList(0, goaliesToBeAdded);
    }


    public void addSkaterUser(List<IPlayers> player, int playersToBeAdded) {
        boolean isPlayerNotAdded = false;
        int playersAdded = 0;
        String agentAddName;
        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList;

        agentList = strongestAgentsList(availableAgents);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersAdded < playersToBeAdded) {
            userOutput.setOutput("Enter Free Agent name To add");
            userOutput.sendOutput();
            userInput.setInput();
            agentAddName = userInput.getInput();

            for (IFreeAgents agent : agentList) {
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
                        continue;
                    }
                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
                    player.add(agentToPlayer);
                    playersAdded++;
                    availableAgents.remove(agent);
                    isPlayerNotAdded = false;
                    break;
                } else {
                    isPlayerNotAdded = true;
                    continue;
                }
            }
            if (isPlayerNotAdded) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
    }

    public void addGoalieUser(List<IPlayers> player, int playersToBeAdded) {
        boolean isPlayerNotAdded = false;
        int playersAdded = 0;
        String agentAddName;
        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList;

        agentList = strongestAgentsList(availableAgents);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersAdded < playersToBeAdded) {
            userOutput.setOutput("Enter Free Agent name To add");
            userOutput.sendOutput();
            userInput.setInput();
            agentAddName = userInput.getInput();


            for (IFreeAgents agent : agentList) {
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {

                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
                        player.add(agentToPlayer);
                        playersAdded++;
                        availableAgents.remove(agent);
                        isPlayerNotAdded = false;
                        break;
                    }
                } else {
                    isPlayerNotAdded = true;

                }
            }
            if (isPlayerNotAdded) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }

    }

    public boolean checkPlayerInList(List<IPlayers> playerList, String agentName) {
        for (IPlayers player : playerList) {
            if (agentName.equalsIgnoreCase(player.getPlayerName())) {
                return true;
            }
        }
        return false;
    }

    public List<IFreeAgents> strongestAgentsList(List<IFreeAgents> list) {

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1), agents.calculateStrength(p2))));
        return list;
    }

    public List<IPlayers> strongestPlayersList(List<IPlayers> list) {

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2))));
        return list;
    }
}

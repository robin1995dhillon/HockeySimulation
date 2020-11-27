package dhl.trade;

import dhl.Configurables;
import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.FreeAgents;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;
import dhl.stateMachineNew.StateMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeAgentList implements IFreeAgentListAdd {
    private StateMachine machine;
    private ILeague league;
    private IPlayers playerStrength;
    private IFreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private IPlayers playerToAdd;
    private ITradePrompt prompt;
    private IUserOutput userOutput;
    private IUserInput userInput;


    public FreeAgentList() {
        machine = new StateMachine();
        league = machine.getLeague();
        agents = new FreeAgents();
        availableAgents = league.getFreeAgents();
       // availableAgents = new ArrayList<>();
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
        if (team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            addPlayer(team.getPlayers(), playersToBeAdded, goalieCount);
        } else if (goalieCount <= 2 && team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            addPlayerUser(team.getPlayers(), playersToBeAdded, goalieCount);
        }

    }

    public void addPlayer(List<IPlayers> player, int playersToBeAdded, int goalieCount) {
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        agentList = sortedAgentsList(playersToBeAdded, goalieCount);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            player.add(agentToPlayer);
            availableAgents.remove(agent);

        }

    }

//    public void addGoalie(List<IPlayers> player, int goalieCount) {
//
//        int goaliesToBeAdded = 2 - goalieCount;
//        IPlayers agentToPlayer;
//        List<IFreeAgents> agentList;
//        agentList = sortedAgentsGoalieList(goaliesToBeAdded);
//        for (IFreeAgents agent : agentList) {
//            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
//            player.add(agentToPlayer);
//            availableAgents.remove(agent);
//        }
//
//    }

    public List<IFreeAgents> sortedAgentsList(int playersToBeAdded, int goalieCount) {
        List<IFreeAgents> agentList = new ArrayList<>();
        for (IFreeAgents agent : availableAgents) {
            if (goalieCount == 2) {
                if (agent.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction())) {
                    agentList.add(agent);
                } else {
                    continue;
                }

            } else {
                if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                    agentList.add(agent);
                    goalieCount++;
                    if (goalieCount == 2) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (agentList.get(0).getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
            Collections.sort(agentList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return agentList.subList(0, goalieCount);
        } else {
            Collections.sort(agentList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return agentList.subList(0, playersToBeAdded);
        }

    }

//    public List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded) {
//        List<IFreeAgents> agentGoalieList = new ArrayList<>();
//        for (IFreeAgents agent : availableAgents) {
//            if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//                agentGoalieList.add(agent);
//            }
//        }
//        Collections.sort(agentGoalieList, Collections.reverseOrder((p1, p2) -> Double.compare(agents.calculateStrength(p1), agents.calculateStrength(p2))));
//        return agentGoalieList.subList(0, goaliesToBeAdded);
//    }


    public void addPlayerUser(List<IPlayers> player, int playersToBeAdded, int goalieCount) {
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
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName) && goalieCount < 2) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        addPlayer(agent, player);
//                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
//                        player.add(agentToPlayer);
                        playersAdded++;
                        //availableAgents.remove(agent);
                        isPlayerNotAdded = false;
                        break;
                    } else {
                        userOutput.setOutput("Cannot select forward");
                        userOutput.sendOutput();
                        break;

                    }

                } else if (agent.getPlayerName().equalsIgnoreCase(agentAddName) && goalieCount >= 2) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction())) {
                        addPlayer(agent, player);
                        //agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
                        //player.add(agentToPlayer);
                        playersAdded++;
                        // availableAgents.remove(agent);
                        isPlayerNotAdded = false;
                        break;

                    } else {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
                        break;

                    }

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

    public void addPlayer(IFreeAgents agent, List<IPlayers> player) {

        IPlayers agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
        player.add(agentToPlayer);
        availableAgents.remove(agent);
    }

//    public void addGoalieUser(List<IPlayers> player, int playersToBeAdded) {
//        boolean isPlayerNotAdded = false;
//        int playersAdded = 0;
//        String agentAddName;
//        IPlayers agentToPlayer;
//        List<IPlayers> playerList = new ArrayList<>();
//        List<IFreeAgents> agentList;
//
//        agentList = strongestAgentsList(availableAgents);
//
//        for (IFreeAgents agent : agentList) {
//            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
//            playerList.add(agentToPlayer);
//        }
//
//        prompt.userAcceptRejectTrade(playerList);
//
//        while (playersAdded < playersToBeAdded) {
//            userOutput.setOutput("Enter Free Agent name To add");
//            userOutput.sendOutput();
//            userInput.setInput();
//            agentAddName = userInput.getInput();
//
//
//            for (IFreeAgents agent : agentList) {
//                if (agent.getPlayerName().equalsIgnoreCase(agentAddName)) {
//                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//
//                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
//                        player.add(agentToPlayer);
//                        playersAdded++;
//                        availableAgents.remove(agent);
//                        isPlayerNotAdded = false;
//                        break;
//                    }
//                } else {
//                    isPlayerNotAdded = true;
//
//                }
//            }
//            if (isPlayerNotAdded) {
//                userOutput.setOutput("invalid! try again");
//                userOutput.sendOutput();
//            }
//        }
//
//    }

    public boolean checkPlayerInList(List<IPlayers> playerList, String agentName) {
        for (IPlayers player : playerList) {
            if (agentName.equalsIgnoreCase(player.getPlayerName())) {
                return true;
            }
        }
        return false;
    }

    public List<IFreeAgents> strongestAgentsList(List<IFreeAgents> list) {

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
        return list;
    }

    public List<IPlayers> strongestPlayersList(List<IPlayers> list) {

        Collections.sort(list, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
        return list;
    }
}

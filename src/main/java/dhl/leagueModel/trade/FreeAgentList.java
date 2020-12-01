package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.presentation.inputOutput.IUserInput;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.UserInput;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.*;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;
import dhl.stateMachine.StateMachine;
import dhl.stateMachine.StateMachineAbstractFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeAgentList implements IFreeAgentListAdd {
    private ILeague league;
    private IPlayers playerStrength;
    private IFreeAgents agents;
    //private List<IFreeAgents> availableAgents;
    private IPlayers playerToAdd;
    private ITradePrompt prompt;
    private IUserOutput userOutput;
    private IUserInput userInput;
    private StateMachine stateMachine;
    int totalGoalies;


    public FreeAgentList() {
        totalGoalies = Integer.parseInt(Configurables.TOTAL_GOALIES.getAction());
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        league = stateMachine.getLeague();
        agents = new FreeAgents();
        playerToAdd = new Players();
        playerStrength = new Players();
        prompt = new TradePrompt();
        userOutput = new UserOutput();
        userInput = new UserInput();
    }

    public void setAvailableLeague(ILeague league){
        this.league = league;

    }

    @Override
    public void aiAgentListAdd(ITeam team, int playersToBeAdded) {

        int noOfGoalies = 0;
        int noOfForwards = 0;
        int noOfDefense = 0;

        for (IPlayers player: team.getPlayers()){
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())){
                noOfGoalies++;
            }
            else if (player.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction())){
                noOfForwards++;
            }
            else if (player.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())){
                noOfDefense++;
            }

            if (noOfGoalies > totalGoalies){
//                hireFreeAgents(noOfGoalies - totalGoalies, Configurables.GOALIE.getAction());
            }
            else if (noOfGoalies < totalGoalies){
//                dropToFreeAgents(totalGoalies - noOfGoalies, Configurables.GOALIE.getAction());
            }
        }









//        int goalieCount = 0;
//        for (IPlayers player : team.getPlayers()) {
//            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//                goalieCount++;
//            }
//        }
//        if (team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
//            addPlayer(team.getPlayers(), playersToBeAdded, goalieCount);
//        } else if (team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
//            addPlayerUser(team.getPlayers(), playersToBeAdded, goalieCount);
//        }

    }

    public void addPlayer(List<IPlayers> player, int playersToBeAdded, int goalieCount) {

//        IPlayers agentToPlayer;
//        List<IFreeAgents> agentList;
//        agentList = sortedAgentsList(playersToBeAdded, goalieCount);
//
//        for (IFreeAgents agent : agentList) {
//            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
//            player.add(agentToPlayer);
//            league.getFreeAgents().remove(agent);
//
//        }
//        System.out.println("--------------team size is------------- "+player.size());

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

    public List<IFreeAgents> sortedAgentsList(int playersToBeAdded, int pla) {













//        System.out.println("------------------------------------goaliessssss count: "+goalieCount);
        List<IFreeAgents> agentsList = new ArrayList<>();
        for (IFreeAgents agent : league.getFreeAgents()) {
//            if (goalieCount == totalGoalies) {
//                if (agent.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction()) || agent.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())) {
//                    agentsList.add(agent);
//                } else {
//                    continue;
//                }
//
//            } else {
//                if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//                    agentsList.add(agent);
//                    goalieCount++;
//                    System.out.println("goalie added, count is : "+goalieCount);
//                    if (goalieCount == totalGoalies) {
//                        System.out.println("inside adding goalie");
//                        //continue;  //changed from break
//                        break;
//                    }
//                } else {
//                    continue;
//                }
//            }
        }
//        System.out.println("------------------------------------goalie count: "+goalieCount);
        System.out.println("------------------------------------players to be added are: "+playersToBeAdded);
        System.out.println("------------------------------------agents are: "+agentsList.size());
        System.out.println("------------------------------------actual agents are: "+league.getFreeAgents().size());
        if (agentsList.get(0).getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
            Collections.sort(agentsList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return agentsList.subList(0, playersToBeAdded);
        } else {
            Collections.sort(agentsList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return agentsList.subList(0, playersToBeAdded);
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

        agentList = strongestAgentsList(league.getFreeAgents());

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
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName) && goalieCount < totalGoalies) {
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

                } else if (agent.getPlayerName().equalsIgnoreCase(agentAddName) && goalieCount >= totalGoalies) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction()) || agent.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())) {
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
        league.getFreeAgents().remove(agent);
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

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        return list;
    }

    public List<IPlayers> strongestPlayersList(List<IPlayers> list) {

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        return list;
    }
}

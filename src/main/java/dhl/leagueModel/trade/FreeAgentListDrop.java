package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.Players;
import dhl.leagueModel.league.League;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;
import dhl.stateMachineNew.StateMachine;
import dhl.stateMachineNew.StateMachineAbstractFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FreeAgentListDrop implements IFreeAgentListDrop {

    private IPlayers playerStrength;
    private List<IFreeAgents> availableAgents;
    private IPlayers playerToDrop;
    private ITradePrompt prompt;
    private IFreeAgentListAdd freeAgent;
    private IUserOutput userOutput;
    private IUserInput userInput;
    private StateMachine machine;
    private ILeague league;
    private StateMachine stateMachine;

    public FreeAgentListDrop() {
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        league = stateMachine.getLeague();
        availableAgents = league.getFreeAgents();
        // availableAgents = new ArrayList<>();
        playerToDrop = new Players();
        playerStrength = new Players();
        prompt = new TradePrompt();
        freeAgent = new FreeAgentList();
        userOutput = new UserOutput();
        userInput = new UserInput();

    }

    @Override
    public void agentListDrop(ITeam team, int playersToBeDropped) {
        int goalieCount = 0;
        for (IPlayers player : team.getPlayers()) {
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                goalieCount++;
            }
        }
        if (team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            dropAi(team.getPlayers(), playersToBeDropped, goalieCount);
        } else if (team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            dropUser(team.getPlayers(), playersToBeDropped, goalieCount);
        }


    }

    @Override
    public void dropAi(List<IPlayers> players, int playersToBeDropped, int goalieCount) {
        int goaliesToBeDropped = goalieCount - 2;
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;
        playerList = sortedPlayerList(players, playersToBeDropped, goaliesToBeDropped);

        for (IPlayers player : playerList) {
            players.remove(player);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
            availableAgents.add(playerToAgent);
        }
    }

//    @Override
//    public void dropGoalieAi(List<IPlayers> players, int goalieCount) {
//
//        int goaliesToBeDropped = goalieCount - 2;
//        IFreeAgents playerToAgent;
//        List<IPlayers> goalieList;
//        goalieList = sortedPlayerGoalieList(players, goaliesToBeDropped);
//        for (IPlayers player : goalieList) {
//            players.remove(player);
//            playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
//            availableAgents.add(playerToAgent);
//        }
//    }

    @Override
    public List<IPlayers> sortedPlayerList(List<IPlayers> players, int playersToBeDropped, int goaliesToBeDropped) {
        int dropGoalies = goaliesToBeDropped;
        List<IPlayers> playerList = new ArrayList<>();
        for (IPlayers player : players) {
            if (dropGoalies > 0) {
                if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                    playerList.add(player);
                    dropGoalies--;
                    if (dropGoalies == 0) {
                        break;
                    }
                } else {
                    continue;
                }

            } else {
                if (player.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction()) || player.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())) {
                    playerList.add(player);
                } else {
                    continue;
                }

            }

        }
        if (playerList.get(0).getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
            Collections.sort(playerList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return playerList.subList(0, goaliesToBeDropped);
        } else {
            Collections.sort(playerList, Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));
            return playerList.subList(0, playersToBeDropped);
        }

    }

//    @Override
//    public List<IPlayers> sortedPlayerGoalieList(List<IPlayers> players, int goaliesToBeDropped) {
//        List<IPlayers> playerGoalieList = new ArrayList<>();
//        for (IPlayers player : players) {
//            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//                playerGoalieList.add(player);
//            }
//        }
//        Collections.sort(playerGoalieList, (p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));
//        return playerGoalieList.subList(0, goaliesToBeDropped);
//    }

    @Override
    public void dropUser(List<IPlayers> player, int playersToBeDropped, int goalieCount) {

        boolean isPlayerNotDropped = false;
        String playerDropName;
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(player);

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeDropped > 0) {
            userOutput.setOutput("Enter Player name To drop");
            userOutput.sendOutput();
            userInput.setInput();
            playerDropName = userInput.getInput();
            for (IPlayers players : playerList) {
                if (players.getPlayerName().equalsIgnoreCase(playerDropName) && goalieCount > 2) {
                    if (players.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        dropPlayerToAgentList(players, player);
//                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(players);
//                        player.remove(players);
                        playersToBeDropped--;
//                        availableAgents.add(playerToAgent);
                        isPlayerNotDropped = false;
                        break;

                    } else {
                        userOutput.setOutput("Cannot select forward");
                        userOutput.sendOutput();
                        break;
                    }
                } else if (players.getPlayerName().equalsIgnoreCase(playerDropName) && goalieCount == 2) {
                    if (players.getPosition().equalsIgnoreCase(Configurables.FORWARD.getAction()) || players.getPosition().equalsIgnoreCase(Configurables.DEFENSE.getAction())) {
                        dropPlayerToAgentList(players, player);
//                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(players);
//                        player.remove(players);
                        playersToBeDropped--;
//                        availableAgents.add(playerToAgent);
                        isPlayerNotDropped = false;
                        break;

                    } else {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
                        break;
                    }

                } else {
                    isPlayerNotDropped = true;
                }
            }
            if (isPlayerNotDropped) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
    }

    public void dropPlayerToAgentList(IPlayers players, List<IPlayers> player){

        IFreeAgents playerToAgent = playerToDrop.convertPlayerToFreeAgent(players);
        player.remove(players);
        availableAgents.add(playerToAgent);
    }
}


//    @Override
//    public void dropGoalieUser(List<IPlayers> player, int goalieCount) {
//
//        int playersToBeDropped = goalieCount - 2;
//        boolean isGoalieNotDropped = false;
//        String playerDropName;
//        IFreeAgents playerToAgent;
//        List<IPlayers> playerList;
//
//        playerList = freeAgent.strongestPlayersList(player);
//
//        prompt.userAcceptRejectTrade(playerList);
//
//        while (playersToBeDropped > 0) {
//            userOutput.setOutput("Enter Player name To drop");
//            userOutput.sendOutput();
//            userInput.setInput();
//            playerDropName = userInput.getInput();
//            for (IPlayers players : playerList) {
//                if (players.getPlayerName().equalsIgnoreCase(playerDropName)) {
//                    if (players.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
//
//                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(players);
//                        player.remove(players);
//                        playersToBeDropped--;
//                        availableAgents.add(playerToAgent);
//                        isGoalieNotDropped = false;
//                        break;
//                    }
//                } else {
//                    isGoalieNotDropped = true;
//                }
//            }
//            if (isGoalieNotDropped) {
//                userOutput.setOutput("invalid! try again");
//                userOutput.sendOutput();
//            }
//        }
//    }
//}

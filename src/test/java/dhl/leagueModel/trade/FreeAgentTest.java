package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.FreeAgents;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.Players;
import dhl.leagueModel.ITeam;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockLeague;
import dhl.mock.MockPlayer;
import dhl.mock.MockTeam;
import dhl.presentation.TradePrompt;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FreeAgentTest {
    FreeAgents agents = new FreeAgents();
    IFreeAgentListAdd freeAgent = new FreeAgentList();
    private IUserOutput userOutput = new UserOutput();

    @Test
    public void addSkaterUserTest() {
        boolean isSkaterNotAdded = false;

        List<IPlayers> players = new ArrayList<>();
        int playersToBeAdded = 1;
        int goalieCount = 1;
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        //  List<IFreeAgents> agentList = MockFreeAgent.createMockAgentList();
        Players playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        String agentAddName = "ABC";

        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();
        List<IFreeAgents> expectedAgentList = MockFreeAgent.createMockAgentListExpected();
        List<IFreeAgents> expectedPlayersList = new ArrayList<>();

        agentList.addAll(availableAgents);

        agentList = freeAgent.strongestAgentsList(availableAgents);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeAdded > 0) {

            for (IFreeAgents agent : agentList) {
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
                        continue;
                    }
                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
                    players.add(agentToPlayer);
                    playersToBeAdded--;
                    availableAgents.remove(agent);
                    isSkaterNotAdded = false;
                    break;
                } else {
                    isSkaterNotAdded = true;
                    continue;
                }
            }

            if (isSkaterNotAdded) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }

        }
        assertEquals(expectedAgentList.get(0).getPlayerName(), availableAgents.get(1).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(), availableAgents.get(0).getPlayerName());

    }

    @Test
    public void addGoalieUserTest() {

        boolean isGoalieNotAdded = false;

        List<IPlayers> players = new ArrayList<>();
        int playersToBeAdded = 1;
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        IPlayers playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        String agentAddName = "GHI";

        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();
        List<IFreeAgents> expectedAgentList = MockFreeAgent.createMockAgentGoalieListExpected();

        agentList.addAll(availableAgents);

        agentList = freeAgent.strongestAgentsList(availableAgents);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeAdded > 0) {

            for (IFreeAgents agent : agentList) {
                if (agent.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {

                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
                        players.add(agentToPlayer);
                        playersToBeAdded--;
                        availableAgents.remove(agent);
                        isGoalieNotAdded = false;
                        break;
                    }
                } else {
                    isGoalieNotAdded = true;
                }
            }
            if (isGoalieNotAdded) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
        assertEquals(expectedAgentList.get(0).getPlayerName(), availableAgents.get(1).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(), availableAgents.get(0).getPlayerName());
    }

//    @Test
//    public void aiAgentListAddPlayerTest() {
//
//        int playersToBeAdded = 1;
//        String playerName = "";
//        freeAgent.setAvailableLeague(MockLeague.createMock());
//        ITeam team = MockTeam.MockOffensiveTeam();
//        freeAgent.aiAgentListAdd(team, playersToBeAdded);
//
//        for (IPlayers player : team.getPlayers()) {
//            if (player.getPlayerName().equalsIgnoreCase(MockLeague.createMock().getFreeAgents().get(0).getPlayerName())) {
//                playerName = player.getPlayerName();
//            }
//        }
//        assertEquals(MockLeague.createMock().getFreeAgents().get(0).getPlayerName(), playerName);
//    }

//    @Test
//    public void aiAgentListAddPlayerUserTest() {
//
//        int playersToBeAdded = 1;
//        String playerName = "";
//        freeAgent.setAvailableLeague(MockLeague.createMock());
//        ITeam team = MockTeam.MockUserTeam();
//        freeAgent.aiAgentListAdd(team, playersToBeAdded);
//
////        for (IPlayers player : team.getPlayers()) {
////            if (player.getPlayerName().equalsIgnoreCase(MockLeague.createMock().getFreeAgents().get(0).getPlayerName())) {
////                playerName = player.getPlayerName();
////            }
////        }
////        assertEquals(MockLeague.createMock().getFreeAgents().get(0).getPlayerName(), playerName);
//    }



    @Test
    public void addGoalieTest() {

        int goaliesToBeAdded = 1;
        List<IPlayers> player = new ArrayList<>();
        Players playerToAdd = new Players();
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        List<IFreeAgents> agentGoalieList = new ArrayList<>();
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        List<IFreeAgents> expectedAgents = MockFreeAgent.createMockAgentGoalieListExpected();

        for (IFreeAgents agent : availableAgents) {
            if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                agentGoalieList.add(agent);
            }
        }

        agentGoalieList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        agentList = agentGoalieList.subList(0, goaliesToBeAdded);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            player.add(agentToPlayer);
            availableAgents.remove(agent);
        }

        assertEquals(expectedAgents.get(1).getPlayerName(), availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgents.get(0).getPlayerName(), availableAgents.get(1).getPlayerName());
    }

    @Test
    public void checkPlayerInListTest() {

        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        String player = "ABC";
        boolean isPlayerExist = freeAgent.checkPlayerInList(availablePlayers,player);
        assertEquals(true,isPlayerExist);
    }

    @Test
    public void strongestAgentListTest() {
        List<IFreeAgents> list = MockFreeAgent.createMockAgentList();

        freeAgent.strongestAgentsList(list);

        assertEquals(9.6, list.get(0).getStrength());
    }

    @Test
    public void strongestPlayerListTest() {
        List<IPlayers> list = MockPlayer.createMockPlayerList();

        freeAgent.strongestPlayersList(list);

        assertEquals(8.3, list.get(0).getStrength());

    }
}

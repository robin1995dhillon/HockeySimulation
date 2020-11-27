package dhl.trade;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockPlayer;
import dhl.presentation.TradePrompt;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FreeAgentTest {
    FreeAgents agents = new FreeAgents();
    FreeAgentList freeAgent = new FreeAgentList();
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
        assertEquals(expectedAgentList.get(0).getPlayerName(), availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(), availableAgents.get(1).getPlayerName());

    }

    @Test
    public void addGoalieUserTest() {

        boolean isGoalieNotAdded = false;

        List<IPlayers> players = new ArrayList<>();
        int playersToBeAdded = 1;
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        Players playerToAdd = new Players();
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
        assertEquals(expectedAgentList.get(0).getPlayerName(), availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(), availableAgents.get(1).getPlayerName());
    }

    @Test
    public void addSkaterTest() {

        int playersToBeAdded = 1;
        List<IPlayers> player = new ArrayList<>();
        Players playerToAdd = new Players();
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        List<IFreeAgents> agentSkaterList = new ArrayList<>();
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        List<IFreeAgents> expectedAgents = MockFreeAgent.createMockAgentListExpected();

        for (IFreeAgents agent : availableAgents) {
            if (agent.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                continue;
            } else {
                agentSkaterList.add(agent);
            }
        }

        agentSkaterList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        agentList = agentSkaterList.subList(0, playersToBeAdded);

        for (IFreeAgents agent : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(agent);
            player.add(agentToPlayer);
            availableAgents.remove(agent);
        }

        assertEquals(expectedAgents.get(0).getPlayerName(), availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgents.get(0).getPlayerName(), availableAgents.get(0).getPlayerName());
    }

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
        String player = "";

        for (IPlayers players : availablePlayers) {
            if (players.getPlayerName().equalsIgnoreCase("ABC")) {
                player = "exists";
            }
        }
        assertEquals(player, "exists");
    }

    @Test
    public void strongestAgentTest() {
        List<IFreeAgents> list = MockFreeAgent.createMockAgentList();

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));

        assertEquals(9.6, list.get(0).getStrength());
    }

    @Test
    public void strongestPlayerTest() {
        List<IPlayers> list = MockPlayer.createMockPlayerList();

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));

        assertEquals(8.3, list.get(0).getStrength());

    }
}

package dhl.trade;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.mock.MockPlayer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeAgentDropListTest {

    FreeAgentList freeAgent = new FreeAgentList();
    Players playerToDrop = new Players();
    private IUserOutput userOutput = new UserOutput();
    @Test
    public void dropSkaterAiTest() {

        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        List<IPlayers> playerSkaterList = new ArrayList<>();
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;
        List<IFreeAgents> agents = new ArrayList<>();

        for (IPlayers player : availablePlayers) {
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                continue;
            } else {
                playerSkaterList.add(player);
            }
        }

        playerSkaterList.sort((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength()));
        playerList = playerSkaterList.subList(0, playersToBeDropped);

        for (IPlayers player : playerList) {
            availablePlayers.remove(player);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
            agents.add(playerToAgent);
        }

        assertEquals("JKL", agents.get(0).getPlayerName());
    }


    @Test
    public void dropGoalieAiTest() {

        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        List<IPlayers> playerGoalieList = new ArrayList<>();
        IFreeAgents playerToAgent;
        List<IPlayers> goalieList;
        List<IFreeAgents> agents = new ArrayList<>();

        for (IPlayers player : availablePlayers) {
            if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                playerGoalieList.add(player);
            }
        }

        playerGoalieList.sort((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength()));
        goalieList = playerGoalieList.subList(0, playersToBeDropped);


        for (IPlayers player : goalieList) {
            availablePlayers.remove(player);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
            agents.add(playerToAgent);
        }
        assertEquals("DEF", agents.get(0).getPlayerName());

    }

    @Test
    public void dropSkaterUserTest() {

        List<IFreeAgents> agentsFree = new ArrayList<>();
        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();

        boolean flag = false;
        String playerDropName = "JKL";
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(availablePlayers);

        while (playersToBeDropped != 0) {

            for (IPlayers player : playerList) {
                if (player.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
                        continue;
                    }
                    playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
                    availablePlayers.remove(player);
                    playersToBeDropped--;
                    agentsFree.add(playerToAgent);
                    flag = false;
                    break;

                } else {
                    flag = true;

                }
            }

            if (flag) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
        assertEquals(playerDropName, agentsFree.get(0).getPlayerName());

    }

    @Test
    public void dropGoalieUserTest() {

        List<IFreeAgents> agentsFree = new ArrayList<>();
        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        boolean isGoalieNotDropped = false;
        String playerDropName = "DEF";
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(availablePlayers);

        while (playersToBeDropped > 0) {

            for (IPlayers player : playerList) {
                if (player.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (player.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {

                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(player);
                        availablePlayers.remove(player);
                        playersToBeDropped--;
                        agentsFree.add(playerToAgent);
                        isGoalieNotDropped = false;
                        break;
                    }
                } else {
                    isGoalieNotDropped = true;
                }
            }

            if (isGoalieNotDropped) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }

        assertEquals(playerDropName, agentsFree.get(0).getPlayerName());
    }
}

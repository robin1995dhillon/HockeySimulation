package dhl.trade;

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

    @Test
    public void dropSkaterAiTest(){

        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        List<IPlayers> playerSkaterList = new ArrayList<>();
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;
        List<IFreeAgents> agents = new ArrayList<>();

        for(IPlayers p:availablePlayers){
            if (p.getPosition().equalsIgnoreCase("goalie")) {
                continue;
            } else {
                playerSkaterList.add(p);
            }
        }

        playerSkaterList.sort((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength()));
        playerList = playerSkaterList.subList(0, playersToBeDropped);

        for (IPlayers a : playerList) {
            availablePlayers.remove(a);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(a);
            agents.add(playerToAgent);
        }

        assertEquals("JKL",agents.get(0).getPlayerName());
    }


    @Test
    public void dropGoalieAiTest(){

            int playersToBeDropped = 1;
            List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
            List<IPlayers> playerGoalieList = new ArrayList<>();
            IFreeAgents playerToAgent;
            List<IPlayers> goalieList;
        List<IFreeAgents> agents = new ArrayList<>();

            for(IPlayers p:availablePlayers){
                if (p.getPosition().equalsIgnoreCase("goalie")) {
                    playerGoalieList.add(p);
                }
            }

        playerGoalieList.sort((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength()));
        goalieList = playerGoalieList.subList(0, playersToBeDropped);


        for(IPlayers p: goalieList){
            availablePlayers.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            agents.add(playerToAgent);
        }
        assertEquals("DEF",agents.get(0).getPlayerName());

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

            for (IPlayers p : playerList) {
                if(p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                if (p.getPosition().equalsIgnoreCase("goalie")) {
                    System.out.println("Cannot select goalie");
                    continue;
                }
                    playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
                    availablePlayers.remove(p);
                    playersToBeDropped--;
                    agentsFree.add(playerToAgent);
                    flag = false;
                    break;

                }
                else {
                    flag=true;

                }
            }

            if (flag) {
                System.out.println("invalid! try again");
            }
        }
        assertEquals(playerDropName,agentsFree.get(0).getPlayerName());

    }

    @Test
    public void dropGoalieUserTest(){

        List<IFreeAgents> agentsFree = new ArrayList<>();
        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        boolean flag = false;
        String playerDropName = "DEF";
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(availablePlayers);

        while (playersToBeDropped != 0) {

            for (IPlayers p : playerList) {
                if(p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (p.getPosition().equalsIgnoreCase("goalie")) {

                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
                        availablePlayers.remove(p);
                        playersToBeDropped--;
                        agentsFree.add(playerToAgent);
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("invalid! try again");
            }
        }

        assertEquals(playerDropName,agentsFree.get(0).getPlayerName());
    }
}

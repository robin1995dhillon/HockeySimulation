package trade;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.players.Players;
import dhl.presentation.TradePrompt;
import dhl.trade.FreeAgentList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreeAgentDropListTest {

    FreeAgents agents = new FreeAgents();
    FreeAgentList freeAgent = new FreeAgentList();
    Players playerToDrop = new Players();

    @Test
    public void dropSkaterAiTest(){

        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = new ArrayList<>();
        List<IPlayers> playerSkaterList = new ArrayList<>();
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;
        List<IPlayers> expectedPlayers = new ArrayList<>();
        List<IFreeAgents> agents = new ArrayList<>();

        IPlayers player1 = new Players();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IPlayers player2= new Players();
        player2.setPosition("forward");
        player2.setPlayerName("DEF");
        player2.setStrength(5.6);

        IPlayers player3 = new Players();
        player3.setPosition("goalie");
        player3.setPlayerName("GHI");
        player3.setStrength(6.7);

        availablePlayers.add(player1);
        availablePlayers.add(player2);
        availablePlayers.add(player3);

        expectedPlayers.add(player1);
        expectedPlayers.add(player3);

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

        assertEquals(expectedPlayers,availablePlayers);
    }


    @Test
    public void dropGoalieAiTest(){

            int playersToBeDropped = 1;
            List<IPlayers> availablePlayers = new ArrayList<>();
            List<IPlayers> playerGoalieList = new ArrayList<>();
            IFreeAgents playerToAgent;
            List<IPlayers> goalieList;
            List<IPlayers> expectedPlayers = new ArrayList<>();
            List<IFreeAgents> agents = new ArrayList<>();

            IPlayers player1 = new Players();
            player1.setPosition("forward");
            player1.setPlayerName("ABC");
            player1.setStrength(9.6);

            IPlayers player2= new Players();
            player2.setPosition("goalie");
            player2.setPlayerName("DEF");
            player2.setStrength(5.6);

            IPlayers player3 = new Players();
            player3.setPosition("goalie");
            player3.setPlayerName("GHI");
            player3.setStrength(6.7);

            availablePlayers.add(player1);
            availablePlayers.add(player2);
            availablePlayers.add(player3);

            expectedPlayers.add(player1);
            expectedPlayers.add(player3);

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
        assertEquals(expectedPlayers,availablePlayers);

        }

    @Test
    public void dropSkaterUserTest() {

        List<IFreeAgents> agentsFree = new ArrayList<>();
        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = new ArrayList<>();
        Players playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        List<IFreeAgents> expectedAgents = new ArrayList<>();

        IFreeAgents agent1 = new FreeAgents();
        IFreeAgents agent2 = new FreeAgents();

        IPlayers player1 = new Players();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setSkating(15);
        player1.setShooting(12);
        player1.setChecking(13);
        player1.setSaving(0);
        player1.setStrength(9.6);

        IPlayers player2 = new Players();
        player2.setPosition("forward");
        player2.setSkating(15);
        player2.setPlayerName("DEF");
        player2.setShooting(18);
        player2.setChecking(12);
        player2.setSaving(0);
        player2.setStrength(5.6);

        IPlayers player3 = new Players();
        player3.setPosition("goalie");
        player3.setSkating(15);
        player3.setPlayerName("GHI");
        player3.setShooting(16);
        player3.setChecking(17);
        player3.setSaving(0);
        player3.setStrength(6.7);

        availablePlayers.add(player1);
        availablePlayers.add(player2);
        availablePlayers.add(player3);

        agent1 = playerToDrop.convertPlayerToFreeAgent(player3);
        agent2 = playerToDrop.convertPlayerToFreeAgent(player2);
        expectedAgents.add(agent2);
        expectedAgents.add(agent1);

        boolean flag = false;
        String playerDropName = "ABC";
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();

        playerList = freeAgent.strongestPlayersList(availablePlayers);

        prompt.userAcceptRejectTrade(playerList);

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

       assertEquals(expectedAgents.get(0).getPlayerName(),availablePlayers.get(0).getPlayerName());
       assertEquals(expectedAgents.get(1).getPlayerName(),availablePlayers.get(1).getPlayerName());


    }

    @Test
    public void dropGoalieUserTest(){

        List<IFreeAgents> agentsFree = new ArrayList<>();
        int playersToBeDropped = 1;
        List<IPlayers> availablePlayers = new ArrayList<>();
        Players playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        List<IFreeAgents> expectedAgents = new ArrayList<>();

        IFreeAgents agent1 = new FreeAgents();
        IFreeAgents agent2 = new FreeAgents();

        IPlayers player1 = new Players();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setSkating(15);
        player1.setShooting(12);
        player1.setChecking(13);
        player1.setSaving(0);
        player1.setStrength(9.6);

        IPlayers player2 = new Players();
        player2.setPosition("forward");
        player2.setSkating(15);
        player2.setPlayerName("DEF");
        player2.setShooting(18);
        player2.setChecking(12);
        player2.setSaving(0);
        player2.setStrength(5.6);

        IPlayers player3 = new Players();
        player3.setPosition("goalie");
        player3.setSkating(15);
        player3.setPlayerName("GHI");
        player3.setShooting(16);
        player3.setChecking(17);
        player3.setSaving(0);
        player3.setStrength(6.7);

        availablePlayers.add(player1);
        availablePlayers.add(player2);
        availablePlayers.add(player3);

        agent1 = playerToDrop.convertPlayerToFreeAgent(player3);

        expectedAgents.add(agent1);

        boolean flag = false;
        String playerDropName = "GHI";
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();

        playerList = freeAgent.strongestPlayersList(availablePlayers);

        prompt.userAcceptRejectTrade(playerList);

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

        assertEquals(expectedAgents.get(0).getPlayerName(),agentsFree.get(0).getPlayerName());
    }
}

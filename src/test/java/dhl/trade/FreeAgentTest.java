package dhl.trade;

import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockPlayer;
import dhl.presentation.TradePrompt;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FreeAgentTest {
    FreeAgents agents = new FreeAgents();
    FreeAgentList freeAgent = new FreeAgentList();

    @Test
    public void addSkaterUserTest(){
        boolean flag = false;

        List<IPlayers> players = new ArrayList<>();
        int playersToBeAdded = 1;
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        Players playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        String agentAddName = "ABC";

        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();
        List<IFreeAgents>expectedAgentList = MockFreeAgent.createMockAgentListExpected();
        List<IFreeAgents>expectedPlayersList = new ArrayList<>();

        agentList.addAll(availableAgents);

      agentList = freeAgent.strongestAgentsList(availableAgents);

        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while(playersToBeAdded!=0) {

            for(IFreeAgents a: agentList) {
                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if(a.getPosition().equalsIgnoreCase("goalie")){
                        System.out.println("Cannot select goalie");
                        continue;
                    }
                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
                    players.add(agentToPlayer);
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
                System.out.println("Invalid! try again");
            }

        }
        assertEquals(expectedAgentList.get(0).getPlayerName(),availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(),availableAgents.get(1).getPlayerName());

    }

    @Test
    public void addGoalieUserTest(){

        boolean flag = false;

        List<IPlayers> players = new ArrayList<>();
        int playersToBeAdded = 1;
        List<IFreeAgents> availableAgents = MockFreeAgent.createMockAgentList();
        Players playerToAdd = new Players();
        TradePrompt prompt = new TradePrompt();
        String agentAddName = "GHI";

        IPlayers agentToPlayer;
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();
        List<IFreeAgents>expectedAgentList = MockFreeAgent.createMockAgentGoalieListExpected();

        agentList.addAll(availableAgents);

        agentList = freeAgent.strongestAgentsList(availableAgents);

        for(IFreeAgents a: agentList){
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            playerList.add(agentToPlayer);
        }

        prompt.userAcceptRejectTrade(playerList);

        while(playersToBeAdded!=0) {

            for(IFreeAgents a: agentList) {
                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
                    if(a.getPosition().equalsIgnoreCase("goalie")) {

                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
                        players.add(agentToPlayer);
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
                System.out.println("Invalid! try again");
            }
        }
        assertEquals(expectedAgentList.get(0).getPlayerName(),availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgentList.get(1).getPlayerName(),availableAgents.get(1).getPlayerName());
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

        for(IFreeAgents a:availableAgents){
            if (a.getPosition().equalsIgnoreCase("goalie")) {
                continue;
            } else {
                agentSkaterList.add(a);
            }
        }

        agentSkaterList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));
        agentList = agentSkaterList.subList(0, playersToBeAdded);

       for (IFreeAgents a : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            player.add(agentToPlayer);
            availableAgents.remove(a);
        }

       assertEquals(expectedAgents.get(0).getPlayerName(),availableAgents.get(0).getPlayerName());
       assertEquals(expectedAgents.get(0).getPlayerName(),availableAgents.get(0).getPlayerName());
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

        for(IFreeAgents a:availableAgents){
            if (a.getPosition().equalsIgnoreCase("goalie")) {
                agentGoalieList.add(a);
            }
        }

        agentGoalieList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));
        agentList = agentGoalieList.subList(0, goaliesToBeAdded);

        for (IFreeAgents a : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            player.add(agentToPlayer);
            availableAgents.remove(a);
        }

        assertEquals(expectedAgents.get(1).getPlayerName(),availableAgents.get(0).getPlayerName());
        assertEquals(expectedAgents.get(0).getPlayerName(),availableAgents.get(1).getPlayerName());
    }

    @Test
    public void checkPlayerInListTest() {

        List<IPlayers> availablePlayers = MockPlayer.createMockPlayerList();
        String player = "";

        for (IPlayers p : availablePlayers) {
            if (p.getPlayerName().equalsIgnoreCase("ABC")) {
                player = "exists";
            }
        }
        assertEquals(player,"exists");
    }

    @Test
    public void strongestAgentTest(){
        List<IFreeAgents> list = MockFreeAgent.createMockAgentList();

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));

        assertEquals(9.6,list.get(0).getStrength());
    }

    @Test
    public void strongestPlayerTest(){
        List<IPlayers> list = MockPlayer.createMockPlayerList();

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));

        assertEquals(8.3,list.get(0).getStrength());

    }
}

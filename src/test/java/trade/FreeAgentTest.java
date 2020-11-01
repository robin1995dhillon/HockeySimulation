package trade;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.players.Players;
import dhl.Presentation.TradePrompt;
import dhl.Trade.FreeAgentList;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FreeAgentTest {
    FreeAgents agents = new FreeAgents();
    FreeAgentList freeAgent = new FreeAgentList();

//    @Test
//    public void addSkaterUserTest(){
//        boolean flag = false;
//
//        List<IPlayers> players = new ArrayList<>();
//        int playersToBeAdded = 1;
//        List<IFreeAgents> availableAgents = new ArrayList<>();
//        Players playerToAdd = new Players();
//        TradePrompt prompt = new TradePrompt();
//
//        IFreeAgents player1 = new FreeAgents();
//        player1.setPosition("forward");
//        player1.setPlayerName("ABC");
//        player1.setSkating(15);
//        player1.setShooting(12);
//        player1.setChecking(13);
//        player1.setSaving(0);
//        player1.setStrength(9.6);
//
//        IFreeAgents player2 = new FreeAgents();
//        player2.setPosition("forward");
//        player2.setSkating(15);
//        player2.setPlayerName("DEF");
//        player2.setShooting(18);
//        player2.setChecking(12);
//        player2.setSaving(0);
//        player2.setStrength(5.6);
//
//        IFreeAgents player3 = new FreeAgents();
//        player3.setPosition("goalie");
//        player3.setSkating(15);
//        player3.setPlayerName("GHI");
//        player3.setShooting(16);
//        player3.setChecking(17);
//        player3.setSaving(0);
//        player3.setStrength(6.7);
//
//        availableAgents.add(player1);
//        availableAgents.add(player2);
//        availableAgents.add(player3);
//
//        String agentAddName = "ABC";
//
//        IPlayers agentToPlayer = new Players();
//        List<IPlayers> playerList = new ArrayList<>();
//        List<IFreeAgents> agentList = new ArrayList<>();
//        List<IFreeAgents>expectedAgentList = new ArrayList<>();
//        List<IFreeAgents>expectedPlayersList = new ArrayList<>();
//
//        agentList.addAll(availableAgents);
//        expectedAgentList.add(player2);
//        expectedAgentList.add(player3);
//        expectedPlayersList.add(player1);
//
//      agentList = freeAgent.strongestAgentsList(availableAgents);
//
//        for(IFreeAgents a: agentList){
//            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
//            playerList.add(agentToPlayer);
//        }
//
//        prompt.userAcceptRejectTrade(playerList);
//
//        while(playersToBeAdded!=0) {
//
//            for(IFreeAgents a: agentList) {
//                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
//                    if(a.getPosition().equalsIgnoreCase("goalie")){
//                        System.out.println("Cannot select goalie");
//                        continue;
//                    }
//                    agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
//                    players.add(agentToPlayer);
//                    playersToBeAdded--;
//                    availableAgents.remove(a);
//                    flag = false;
//                    break;
//                }
//                else {
//                    flag=true;
//                    continue;
//                }
//            }
//
//            if(flag){
//                System.out.println("Invalid! try again");
//            }
//
//        }
//        assertEquals(expectedAgentList,availableAgents);
//
//    }

//    @Test
//    public void addGoalieUserTest(){
//
//        boolean flag = false;
//
//        List<IPlayers> players = new ArrayList<>();
//        int playersToBeAdded = 1;
//        List<IFreeAgents> availableAgents = new ArrayList<>();
//        Players playerToAdd = new Players();
//        TradePrompt prompt = new TradePrompt();
//
//        IFreeAgents player1 = new FreeAgents();
//        player1.setPosition("forward");
//        player1.setPlayerName("ABC");
//        player1.setSkating(15);
//        player1.setShooting(12);
//        player1.setChecking(13);
//        player1.setSaving(0);
//        player1.setStrength(9.6);
//
//        IFreeAgents player2 = new FreeAgents();
//        player2.setPosition("forward");
//        player2.setSkating(15);
//        player2.setPlayerName("DEF");
//        player2.setShooting(18);
//        player2.setChecking(12);
//        player2.setSaving(0);
//        player2.setStrength(5.6);
//
//        IFreeAgents player3 = new FreeAgents();
//        player3.setPosition("goalie");
//        player3.setSkating(15);
//        player3.setPlayerName("GHI");
//        player3.setShooting(16);
//        player3.setChecking(17);
//        player3.setSaving(0);
//        player3.setStrength(6.7);
//
//        availableAgents.add(player1);
//        availableAgents.add(player2);
//        availableAgents.add(player3);
//
//        String agentAddName = "GHI";
//
//        IPlayers agentToPlayer = new Players();
//        List<IPlayers> playerList = new ArrayList<>();
//        List<IFreeAgents> agentList = new ArrayList<>();
//        List<IFreeAgents>expectedAgentList = new ArrayList<>();
//        List<IFreeAgents>expectedPlayersList = new ArrayList<>();
//
//        agentList.addAll(availableAgents);
//
//        expectedAgentList.add(player2);
//        expectedAgentList.add(player1);
//
//
//        agentList = freeAgent.strongestAgentsList(availableAgents);
//
//        for(IFreeAgents a: agentList){
//            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
//            playerList.add(agentToPlayer);
//        }
//
//        prompt.userAcceptRejectTrade(playerList);
//
//        while(playersToBeAdded!=0) {
//
//            for(IFreeAgents a: agentList) {
//                if(a.getPlayerName().equalsIgnoreCase(agentAddName)) {
//                    if(a.getPosition().equalsIgnoreCase("goalie")) {
//
//                        agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
//                        players.add(agentToPlayer);
//                        playersToBeAdded--;
//                        availableAgents.remove(a);
//                        flag = false;
//                        break;
//                    }
//                }
//                else {
//                    flag=true;
//                }
//            }
//            if(flag){
//                System.out.println("Invalid! try again");
//            }
//        }
//        assertEquals(expectedAgentList,availableAgents);
//    }

    @Test
    public void addSkaterTest() {

        int playersToBeAdded = 1;
        List<IPlayers> player = new ArrayList<>();
        Players playerToAdd = new Players();
        List<IFreeAgents> availableAgents = new ArrayList<>();
        List<IFreeAgents> agentSkaterList = new ArrayList<>();
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        List<IFreeAgents> expectedAgents = new ArrayList<>();

        IFreeAgents player1 = new FreeAgents();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("forward");
        player2.setPlayerName("DEF");
        player2.setStrength(5.6);

        IFreeAgents player3 = new FreeAgents();
        player3.setPosition("goalie");
        player3.setPlayerName("GHI");
        player3.setStrength(6.7);

        availableAgents.add(player1);
        availableAgents.add(player2);
        availableAgents.add(player3);

        expectedAgents.add(player2);
        expectedAgents.add(player3);

        for(IFreeAgents a:availableAgents){
            if (a.getPosition().equalsIgnoreCase("goalie")) {
                continue;
            } else {
                agentSkaterList.add(a);
            }
        }

        for(IFreeAgents a:agentSkaterList){
            System.out.println(a.getPlayerName());
        }
        System.out.println("--------------------------------------------");

        agentSkaterList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));
        agentList = agentSkaterList.subList(0, playersToBeAdded);


        for(IFreeAgents a:agentList){
            System.out.println(a.getPlayerName());
        }
        System.out.println("--------------------------------------------");

       for (IFreeAgents a : agentList) {
            agentToPlayer = playerToAdd.convertFreeAgentToPlayer(a);
            player.add(agentToPlayer);
            availableAgents.remove(a);
        }

       assertEquals(expectedAgents,availableAgents);
    }

    @Test
    public void addGoalieTest() {

        int goaliesToBeAdded = 1;
        List<IPlayers> player = new ArrayList<>();
        Players playerToAdd = new Players();
        List<IFreeAgents> availableAgents = new ArrayList<>();
        List<IFreeAgents> agentGoalieList = new ArrayList<>();
        IPlayers agentToPlayer;
        List<IFreeAgents> agentList;
        List<IFreeAgents> expectedAgents = new ArrayList<>();

        IFreeAgents player1 = new FreeAgents();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("goalie");
        player2.setPlayerName("DEF");
        player2.setStrength(5.6);

        IFreeAgents player3 = new FreeAgents();
        player3.setPosition("goalie");
        player3.setPlayerName("GHI");
        player3.setStrength(6.7);

        availableAgents.add(player1);
        availableAgents.add(player2);
        availableAgents.add(player3);

        expectedAgents.add(player1);
        expectedAgents.add(player2);

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

        assertEquals(expectedAgents,availableAgents);
    }

    @Test
    public void checkPlayerInListTest() {

        List<IPlayers> availablePlayers = new ArrayList<>();
        String player = "";

        IPlayers player1 = new Players();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IPlayers player2 = new Players();
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

        for (IPlayers p : availablePlayers) {
            if (p.getPlayerName().equalsIgnoreCase("ABC")) {
                player = "exists";
            }
        }
        assertEquals(player,"exists");
    }

    @Test
    public void strongestAgentsListTest(){
        List<IFreeAgents> list = new ArrayList<>();
        List<IFreeAgents> expectedList = new ArrayList<>();

        IFreeAgents player1 = new FreeAgents();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("goalie");
        player2.setPlayerName("DEF");
        player2.setStrength(5.6);

        IFreeAgents player3 = new FreeAgents();
        player3.setPosition("goalie");
        player3.setPlayerName("GHI");
        player3.setStrength(6.7);

        list.add(player1);
        list.add(player2);
        list.add(player3);

        expectedList.add(player1);
        expectedList.add(player3);
        expectedList.add(player2);

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));

        assertEquals(expectedList,list);
    }

    @Test
    public void strongestPlayersListTest(){
        List<IPlayers> list = new ArrayList<>();
        List<IPlayers> expectedList = new ArrayList<>();

        IPlayers player1 = new Players();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(9.6);

        IPlayers player2 = new Players();
        player2.setPosition("goalie");
        player2.setPlayerName("DEF");
        player2.setStrength(5.6);

        IPlayers player3 = new Players();
        player3.setPosition("goalie");
        player3.setPlayerName("GHI");
        player3.setStrength(6.7);

        list.add(player1);
        list.add(player2);
        list.add(player3);

        expectedList.add(player1);
        expectedList.add(player3);
        expectedList.add(player2);

        list.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength())));

        assertEquals(expectedList,list);

    }
}

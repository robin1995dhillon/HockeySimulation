package dhl.LeagueModel.players;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void agePlayer() {
        IPlayers player = new Players();
        player.setAge(20);
        player.setDaysToAge(20);
        int playerDays = player.getDaysToAge();
        System.out.println(playerDays);
        player.agePlayer(player, 250);
        System.out.println(player.getAge());
        System.out.println(player.getDaysToAge());
    }

    @Test
    void replacePlayerWithFreeAgent() {
        IPlayers players = new Players();
        players.setChecking(20);
        players.setSaving(15);
        players.setSkating(18);
        players.setPosition("forward");
        players.setPlayerName("Player1");

        IFreeAgents freeAgents_1 = new FreeAgents();
        freeAgents_1.setChecking(20);
        freeAgents_1.setSaving(15);
        freeAgents_1.setSkating(18);
        freeAgents_1.setPosition("forward");
        freeAgents_1.setPlayerName("Player1");

        IFreeAgents freeAgents_2 = new FreeAgents();
        freeAgents_2.setChecking(10);
        freeAgents_2.setSaving(20);
        freeAgents_2.setSkating(15);
        freeAgents_2.setPosition("forward");
        freeAgents_2.setPlayerName("Player2");

        IFreeAgents freeAgents_3 = new FreeAgents();
        freeAgents_3.setChecking(20);
        freeAgents_3.setSaving(20);
        freeAgents_3.setSkating(25);
        freeAgents_3.setPosition("defense");
        freeAgents_3.setPlayerName("Player3");

        ArrayList<IFreeAgents> freeAgentArrayList = new ArrayList<>();
        freeAgentArrayList.add(freeAgents_1);
        freeAgentArrayList.add(freeAgents_2);
        freeAgentArrayList.add(freeAgents_3);

        IFreeAgents bestFreeAgent = players.replacePlayerWithFreeAgent(players, freeAgentArrayList);
        assertEquals(bestFreeAgent.getPlayerName(), "Player1");
    }

    @Test
    void checkForPlayerInjury() {
        IPlayers players = new Players();
        players.setAge(50);
        players.setChecking(20);
        players.setSaving(15);
        players.setSkating(18);
        players.setPosition("forward");
        players.setPlayerName("Player1");

        players.agePlayer(players, 25);
        while(true) {
            players.checkForPlayerInjury(players);
            if(players.isInjured()) {
                break;
            }
        }

        System.out.println("Injury Days for Player is" + players.getInjuredDays());
        players.agePlayer(players, players.getInjuredDays() - 2);
        players.checkForPlayerInjury(players);
        System.out.println("After Aging" + players.isInjured());
        System.out.println("After Aging Player Injury Days" + players.getInjuredDays());
    }

    @Test
    void playerStillInjured() {

    }

//    @Test
//    void checkIfRetired() {
//        IPlayers player = new Players();
//        player.setAge(42);
//        player.
//        player.setDaysToAge(20);
//        int playerDays = player.getDaysToAge();
//        System.out.println(playerDays);
//        player.agePlayer(player, 250);
//        System.out.println(player.getAge());
//        System.out.println(player.getDaysToAge());
//    }

    @Test
    public void convertPlayerToFreeAgentTest(){

        IPlayers players = new Players();
        players.setAge(50);
        players.setChecking(20);
        players.setSaving(15);
        players.setSkating(18);
        players.setStrength(5.6);
        players.setPosition("forward");
        players.setPlayerName("Player1");

        IFreeAgents agent  = new FreeAgents();
        agent.setAge(players.getAge());
        agent.setChecking(players.getChecking());
        agent.setSaving(players.getSaving());
        agent.setSkating(players.getSkating());
        agent.setPosition(players.getPosition());
        agent.setPlayerName(players.getPlayerName());
        agent.setStrength(players.getStrength());

        assertEquals(agent.getPlayerName(),"Player1");
        assertEquals(agent.getStrength(),5.6);

    }

    @Test
    public void convertFreeAgentToPlayerTest(){

        IFreeAgents agent = new FreeAgents();
        agent.setAge(50);
        agent.setChecking(20);
        agent.setSaving(15);
        agent.setSkating(18);
        agent.setStrength(5.6);
        agent.setPosition("forward");
        agent.setPlayerName("Player1");

        IPlayers players  = new Players();
        players.setAge(agent.getAge());
        players.setChecking(agent.getChecking());
        players.setSaving(agent.getSaving());
        players.setSkating(agent.getSkating());
        players.setPosition(agent.getPosition());
        players.setPlayerName(agent.getPlayerName());
        players.setStrength(agent.getStrength());

        assertEquals(agent.getPlayerName(),"Player1");
        assertEquals(agent.getStrength(),5.6);

    }
}
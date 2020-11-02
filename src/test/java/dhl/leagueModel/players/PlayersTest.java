package dhl.leagueModel.players;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockPlayer;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Before
    void setValues() {
        IGamePlayConfig iGamePlayConfig = MockGamePlayConfig.createMock();
        System.out.println(iGamePlayConfig.getAging().getAverageRetirementAge());
    }

    @Test
    void agePlayer() {
        setValues();
        IPlayers players = MockPlayer.createMock();
        IGamePlayConfig gamePlayConfig = MockGamePlayConfig.createMock();
        players.agePlayer(200);
        assertEquals(201, players.getDaysToAge());
        assertEquals(25, players.getAge());
    }

    @Test
    void agePlayer2() {
        IPlayers players = MockPlayer.createMock();
        players.setAge(33);
        players.setDaysToAge(200);
        players.agePlayer(200);
        assertEquals(35, players.getDaysToAge());
        assertEquals(34, players.getAge());
    }

    @Test
    void replacePlayerWithFreeAgent() {
        IPlayers players = MockPlayer.createMock();
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        IFreeAgents freeAgents1 = MockFreeAgent.createMockTwo();
        IFreeAgents freeAgents2 = MockFreeAgent.createMockThree();

        ArrayList<IFreeAgents> freeAgentArrayList = new ArrayList<>();
        freeAgentArrayList.add(freeAgents);
        freeAgentArrayList.add(freeAgents1);
        freeAgentArrayList.add(freeAgents2);

        IFreeAgents bestFreeAgent = players.replacePlayerWithFreeAgent(players, freeAgentArrayList);
        assertEquals(bestFreeAgent.getPlayerName(), "FreeAgent1");
    }

    @Test
    void checkForPlayerInjury() {
        IPlayers players = MockPlayer.createMock();

        players.agePlayer(25);
        while(true) {
            players.checkForPlayerInjury();
            if(players.isInjured()) {
                break;
            }
        }
        assertTrue(players.isInjured());
    }

    @Test
    void playerStillInjured() {
        IPlayers players = MockPlayer.createMock();
        players.setInjured(true);
        players.setInjuredDays(50);
        players.playerStillInjured();
        assertTrue(players.isInjured());
    }

    @Test
    void playerStillInjuredFalse() {
        IPlayers players = MockPlayer.createMock();
        players.setInjured(true);
        players.setInjuredDays(50);
        players.agePlayer(55);
        players.playerStillInjured();
        assertFalse(players.isInjured());
    }

    @Test
    void checkIfRetired() {
        IPlayers player = MockPlayer.createMock();
        player.setAge(50);
        player.setDaysToAge(20);
        player.checkIfRetired();
        assertTrue(player.isRetired());
    }

    @Test
    public void convertPlayerToFreeAgentTest(){

        IPlayers players = MockPlayer.createMock();
        players.setStrength(40);
        IFreeAgents freeAgents = players.convertPlayerToFreeAgent(players);
        assertEquals(freeAgents.getPlayerName(), players.getPlayerName());
    }

    @Test
    void getPlayerName() {
        IPlayers players = MockPlayer.createMock();
        assertEquals("Player1", players.getPlayerName());
    }

    @Test
    void setPlayerName() {
        IPlayers players = MockPlayer.createMock();
        players.setPlayerName("Player2");
        assertEquals("Player2", players.getPlayerName());
    }

    @Test
    void getPosition() {
        IPlayers players = MockPlayer.createMock();
        assertEquals("forward", players.getPosition());
    }

    @Test
    void setPosition() {
        IPlayers players = MockPlayer.createMock();
        players.setPosition("defense");
        assertEquals("defense", players.getPosition());
    }

    @Test
    void getCaptain() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(true, players.getCaptain());
    }

    @Test
    void setCaptain() {
        IPlayers players = MockPlayer.createMock();
        players.setCaptain(false);
        assertEquals(false, players.getCaptain());
    }

    @Test
    void getAge() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(25, players.getAge());
    }

    @Test
    void setAge() {
        IPlayers players = MockPlayer.createMock();
        players.setAge(20);
        assertEquals(20, players.getAge());
    }

    @Test
    void getSkating() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(15, players.getSkating());
    }

    @Test
    void setSkating() {
        IPlayers players = MockPlayer.createMock();
        players.setSkating(20);
        assertEquals(20, players.getSkating());
    }

    @Test
    void getShooting() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(15, players.getShooting());
    }

    @Test
    void setShooting() {
        IPlayers players = MockPlayer.createMock();
        players.setShooting(20);
        assertEquals(20, players.getShooting());
    }

    @Test
    void getChecking() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(15, players.getChecking());
    }

    @Test
    void setChecking() {
        IPlayers players = MockPlayer.createMock();
        players.setChecking(20);
        assertEquals(20, players.getChecking());
    }

    @Test
    void getSaving() {
        IPlayers players = MockPlayer.createMock();
        assertEquals(15, players.getSaving());
    }

    @Test
    void setSaving() {
        IPlayers players = MockPlayer.createMock();
        players.setSaving(20);
        assertEquals(20, players.getSaving());
    }

    @Test
    void getStrength() {
        IPlayers players = MockPlayer.createMock();
        players.setStrength(50);
        assertEquals(50, players.getStrength());
    }

    @Test
    void setStrength() {
        IPlayers players = MockPlayer.createMock();
        players.setStrength(50);
        assertEquals(50, players.getStrength());
    }

    @Test
    void getDaysToAge() {
        IPlayers players = MockPlayer.createMock();
        players.setDaysToAge(20);
        assertEquals(20, players.getDaysToAge());
    }

    @Test
    void setDaysToAge() {
        IPlayers players = MockPlayer.createMock();
        players.setDaysToAge(20);
        assertEquals(20, players.getDaysToAge());
    }

    @Test
    void isRetired() {
        IPlayers players = MockPlayer.createMock();
        players.setRetired(true);
        assertEquals(true, players.isRetired());
    }

    @Test
    void setRetired() {
        IPlayers players = MockPlayer.createMock();
        players.setRetired(false);
        assertEquals(false, players.isRetired());
    }

    @Test
    void getInjuredDays() {
        IPlayers players = MockPlayer.createMock();
        players.setInjuredDays(20);
        assertEquals(20, players.getInjuredDays());
    }

    @Test
    void setInjuredDays() {
        IPlayers players = MockPlayer.createMock();
        players.setInjuredDays(20);
        assertEquals(20, players.getInjuredDays());
    }

    @Test
    void isInjured() {
        IPlayers players = MockPlayer.createMock();
        players.setInjured(true);
        assertEquals(true, players.isInjured());
    }

    @Test
    void setInjured() {
        IPlayers players = MockPlayer.createMock();
        players.setInjured(true);
        assertEquals(true, players.isInjured());
    }

    @Test
    void savePlayer() {
    }
}
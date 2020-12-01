package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    MockPlayer mockPlayer;
    MockFreeAgent mockFreeAgent;
    MockGamePlayConfig mockGamePlayConfig;
    IPlayers players;
    IGamePlayConfig gamePlayConfig;

    IFreeAgents freeAgents;
    IFreeAgents freeAgents2;
    IFreeAgents freeAgents3;

    public PlayersTest() {
        mockPlayer = new MockPlayer();
        mockFreeAgent = new MockFreeAgent();
        mockGamePlayConfig = new MockGamePlayConfig();
    }

    @Test
    void replacePlayerWithFreeAgent() {
        players = mockPlayer.createPlayerMockOne();
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents2 = mockFreeAgent.createFreeAgentMockTwo();
        freeAgents3 =mockFreeAgent.createFreeAgentMockThree();

        ArrayList<IFreeAgents> freeAgentArrayList = new ArrayList<>();
        freeAgentArrayList.add(freeAgents);
        freeAgentArrayList.add(freeAgents2);
        freeAgentArrayList.add(freeAgents3);

        IFreeAgents bestFreeAgent = players.replacePlayerWithFreeAgent(players, freeAgentArrayList);
        assertEquals(bestFreeAgent.getPlayerName(), "FreeAgent3");
    }

    @Test
    void checkForPlayerInjury() {
        players = mockPlayer.createPlayerMockOne();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        players.agePlayer(25, gamePlayConfig);
        while (true) {
            players.checkForPlayerInjury(gamePlayConfig);
            if (players.isInjured()) {
                break;
            }
        }
        assertTrue(players.isInjured());
    }

    @Test
    void playerStillInjured() {
        players = mockPlayer.createInjuredPlayerMock();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        players.playerStillInjured();
        assertTrue(players.isInjured());
        players.agePlayer(50, gamePlayConfig);
        assertFalse(players.isInjured());
    }
    @Test
    void checkIfRetired() {
        players = mockPlayer.createPlayerMockOne();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        players.setAge(60);
        players.setGamePlayConfig(gamePlayConfig);
        players.checkIfRetired();
        assertTrue(players.isRetired());
    }

    @Test
    public void convertPlayerToFreeAgent() {

        players = mockPlayer.createPlayerMockOne();
        IFreeAgents freeAgents = players.convertPlayerToFreeAgent(players);
        assertEquals(freeAgents.getPlayerName(), players.getPlayerName());
    }

    @Test
    void getPlayerName() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals("Player1", players.getPlayerName());
    }

    @Test
    void setPlayerName() {
        players = mockPlayer.createPlayerMockOne();
        players.setPlayerName("Player2");
        assertEquals("Player2", players.getPlayerName());
    }

    @Test
    void getPosition() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals("forward", players.getPosition());
    }

    @Test
    void setPosition() {
        players = mockPlayer.createPlayerMockOne();
        players.setPosition("defense");
        assertEquals("defense", players.getPosition());
    }

    @Test
    void getCaptain() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(false, players.getCaptain());
    }

    @Test
    void setCaptain() {
        IPlayers players = mockPlayer.createPlayerMockOne();
        players.setCaptain(true);
        assertEquals(true, players.getCaptain());
    }

    @Test
    void getSkating() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(17, players.getSkating());
    }

    @Test
    void setSkating() {
        players = mockPlayer.createPlayerMockOne();
        players.setSkating(20);
        assertEquals(20, players.getSkating());
    }

    @Test
    void getShooting() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(15, players.getShooting());
    }

    @Test
    void setShooting() {
        players = mockPlayer.createPlayerMockOne();
        players.setShooting(20);
        assertEquals(20, players.getShooting());
    }

    @Test
    void getChecking() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(16, players.getChecking());
    }

    @Test
    void setChecking() {
        players = mockPlayer.createPlayerMockOne();
        players.setChecking(20);
        assertEquals(20, players.getChecking());
    }

    @Test
    void getSaving() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(15, players.getSaving());
    }

    @Test
    void setSaving() {
        players = mockPlayer.createPlayerMockOne();
        players.setSaving(20);
        assertEquals(20, players.getSaving());
    }

    @Test
    void getStrength() {
        players = mockPlayer.createPlayerMockOne();
        players.setStrength(25);
        assertEquals(25, players.getStrength());
    }

    @Test
    void setStrength() {
        players = mockPlayer.createPlayerMockOne();
        players.setStrength(25);
        assertEquals(25, players.getStrength());
    }

    @Test
    void isRetired() {
        players = mockPlayer.createPlayerMockOne();
        assertEquals(false, players.isRetired());
    }

    @Test
    void setRetired() {
        players = mockPlayer.createPlayerMockOne();
        players.setRetired(true);
        assertEquals(true, players.isRetired());
    }

    @Test
    void getInjuredDays() {
        players = mockPlayer.createInjuredPlayerMock();
        assertEquals(40, players.getInjuredDays());
    }

    @Test
    void setInjuredDays() {
        players = mockPlayer.createInjuredPlayerMock();
        players.setInjuredDays(50);
        assertEquals(50, players.getInjuredDays());
    }

    @Test
    void isInjured() {
        players = mockPlayer.createInjuredPlayerMock();
        assertEquals(true, players.isInjured());
    }

    @Test
    void setInjured() {
        players = mockPlayer.createInjuredPlayerMock();
        players.setInjured(false);
        assertEquals(false, players.isInjured());
    }

    @Test
    public void convertFreeAgentToPlayer() {
        players = mockPlayer.createPlayerMockOne();
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        IPlayers newPlayer = players.convertFreeAgentToPlayer(freeAgents);
        assertEquals(freeAgents.getPlayerName(), newPlayer.getPlayerName());
    }

    @Test
    void agePlayer() {
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        players = mockPlayer.createPlayerMockOne();
        players.agePlayer(10, gamePlayConfig);
        assertEquals(11, players.getPlayerCurrentDate().getDayOfMonth());
    }

    @Test
    void statsDecayDueToBirthDay() {
        players = mockPlayer.createPlayerMockForStatsDecay();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        players.setGamePlayConfig(gamePlayConfig);
        while(players.getSkating() == 17) {
            players.statsDecayDueToBirthDay();
        }
        assertEquals(16, players.getSkating());
    }
}

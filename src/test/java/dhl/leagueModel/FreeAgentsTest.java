package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentsTest {
    MockFreeAgent mockFreeAgent;
    IGamePlayConfig gamePlayConfig;
    IFreeAgents freeAgents;
    IFreeAgents freeAgents2;
    IFreeAgents freeAgents3;
    MockGamePlayConfig mockGamePlayConfig;
    IPlayers players;
    MockPlayer mockPlayer;

    public FreeAgentsTest() {
        mockFreeAgent = new MockFreeAgent();
        mockGamePlayConfig = new MockGamePlayConfig();
        mockPlayer = new MockPlayer();
    }

    @Test
    void getPlayerName() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals("FreeAgent1", freeAgents.getPlayerName());
    }

    @Test
    void setPlayerName() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setPlayerName("FreeAgent2");
        assertEquals("FreeAgent2", freeAgents.getPlayerName());
    }

    @Test
    void getPosition() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals("forward", freeAgents.getPosition());
    }

    @Test
    void setPosition() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setPosition("defense");
        assertEquals("defense", freeAgents.getPosition());
    }

    @Test
    void getBirthDay() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(28, freeAgents.getBirthDay());
    }

    @Test
    void setBirthDay() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setBirthDay(28);
        assertEquals(28, freeAgents.getBirthDay());
    }

    @Test
    void getBirthMonth() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(6, freeAgents.getBirthMonth());
    }

    @Test
    void setBirthMonth() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setBirthMonth(6);
        assertEquals(6, freeAgents.getBirthMonth());
    }

    @Test
    void getBirthYear() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(1997, freeAgents.getBirthYear());
    }

    @Test
    void setBirthYear() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setBirthMonth(1997);
        assertEquals(1997, freeAgents.getBirthYear());
    }

    @Test
    void getAge() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setAge(23);
        assertEquals(23, freeAgents.getAge());
    }

    @Test
    void setAge() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setAge(25);
        assertEquals(25, freeAgents.getAge());
    }

    @Test
    void getStrength() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setStrength(23);
        assertEquals(23, freeAgents.getStrength());
    }

    @Test
    void setStrength() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setStrength(25);
        assertEquals(25, freeAgents.getStrength());
    }

    @Test
    void getInjuredDays() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        assertEquals(30, freeAgents.getInjuredDays());
    }

    @Test
    void setInjuredDays() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setInjuredDays(40);
        assertEquals(40, freeAgents.getInjuredDays());
    }

    @Test
    void isRetired() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(false, freeAgents.isRetired());
    }

    @Test
    void setRetired() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setRetired(true);
        assertEquals(true, freeAgents.isRetired());
    }

    @Test
    void isInjured() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        assertEquals(true, freeAgents.isInjured());
    }

    @Test
    void setInjured() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setInjured(false);
        assertEquals(false, freeAgents.isInjured());
    }

    @Test
    void getPlayerCurrentDate() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setPlayerCurrentDate(LocalDate.now());
        assertEquals(LocalDate.now(), freeAgents.getPlayerCurrentDate());
    }

    @Test
    void setPlayerCurrentDate() {
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setPlayerCurrentDate(LocalDate.now());
        assertEquals(LocalDate.now(), freeAgents.getPlayerCurrentDate());
    }

    @Test
    void getGamePlayConfig() {
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setGamePlayConfig(gamePlayConfig);
        assertEquals(gamePlayConfig, freeAgents.getGamePlayConfig());
    }

    @Test
    void setGamePlayConfig() {
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents = mockFreeAgent.createFreeAgentInjuredMock();
        freeAgents.setGamePlayConfig(gamePlayConfig);
        assertEquals(gamePlayConfig, freeAgents.getGamePlayConfig());
    }

    @Test
    void getSkating() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(17, freeAgents.getSkating());
    }

    @Test
    void setSkating() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setSkating(20);
        assertEquals(20, freeAgents.getSkating());
    }

    @Test
    void getShooting() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(15, freeAgents.getShooting());
    }

    @Test
    void setShooting() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setShooting(20);
        assertEquals(20, freeAgents.getShooting());
    }

    @Test
    void getChecking() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(16, freeAgents.getChecking());
    }

    @Test
    void setChecking() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setChecking(20);
        assertEquals(20, freeAgents.getChecking());
    }

    @Test
    void getSaving() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        assertEquals(14, freeAgents.getSaving());
    }

    @Test
    void setSaving() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.setSaving(20);
        assertEquals(20, freeAgents.getSaving());
    }

    @Test
    void agePlayer() {
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.agePlayer(10, gamePlayConfig);
        assertEquals(11, freeAgents.getPlayerCurrentDate().getDayOfMonth());
    }

    @Test
    void checkIfRetired() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents.setAge(60);
        freeAgents.setGamePlayConfig(gamePlayConfig);
        freeAgents.checkIfRetired();
        assertTrue(freeAgents.isRetired());
    }


    @Test
    void statsDecayDueToBirthDay() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents.setGamePlayConfig(gamePlayConfig);
        while(freeAgents.getSkating() == 17) {
            freeAgents.statsDecayDueToBirthDay();
        }
        assertEquals(16, freeAgents.getSkating());
    }

    @Test
    public void convertFreeAgentToPlayer() {
        players = mockPlayer.createPlayerMockOne();
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        IPlayers newPlayer = players.convertFreeAgentToPlayer(freeAgents);
        assertEquals(freeAgents.getPlayerName(), newPlayer.getPlayerName());
    }

    @Test
    void checkPosition() {

    }

    @Test
    void calculateStrength() {
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        freeAgents.calculateStrength();
        System.out.println(freeAgents.getStrength());
        assertEquals(40, freeAgents.getStrength());
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
        freeAgents = mockFreeAgent.createFreeAgentMockOne();
        gamePlayConfig = mockGamePlayConfig.createGamePlayConfig();
        freeAgents.agePlayer(25, gamePlayConfig);
        while (true) {
            freeAgents.checkForPlayerInjury(gamePlayConfig);
            if (freeAgents.isInjured()) {
                break;
            }
        }
        assertTrue(freeAgents.isInjured());
    }


    @Test
    void removeFreeAgents() {
        List<IFreeAgents> newList = new ArrayList<>();
        List<IFreeAgents> freeAgentsList = mockFreeAgent.retireFreeAgentMockList();
        IFreeAgents freeAgents = freeAgentsList.get(0);
        newList = freeAgents.removeFreeAgents(freeAgentsList);
        assertEquals(0,newList.size());
    }


}

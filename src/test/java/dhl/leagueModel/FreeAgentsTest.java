package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.mock.MockFreeAgent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentsTest {
    MockFreeAgent mockFreeAgent;
    IGamePlayConfig gamePlayConfig;
    IFreeAgents freeAgents;

    public FreeAgentsTest() {
        mockFreeAgent = new MockFreeAgent();
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
        assertEquals("forward", freeAgents.getPosition());
    }

    @Test
    void setBirthDay() {
    }

    @Test
    void getBirthMonth() {
    }

    @Test
    void setBirthMonth() {
    }

    @Test
    void getBirthYear() {
    }

    @Test
    void setBirthYear() {
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }

    @Test
    void getStrength() {
    }

    @Test
    void setStrength() {
    }

    @Test
    void getInjuredDays() {
    }

    @Test
    void setInjuredDays() {
    }

    @Test
    void isRetired() {
    }

    @Test
    void setRetired() {
    }

    @Test
    void isInjured() {
    }

    @Test
    void setInjured() {
    }

    @Test
    void getPlayerCurrentDate() {
    }

    @Test
    void setPlayerCurrentDate() {
    }

    @Test
    void getGamePlayConfig() {
    }

    @Test
    void setGamePlayConfig() {
    }

    @Test
    void getSkating() {
    }

    @Test
    void setSkating() {
    }

    @Test
    void getShooting() {
    }

    @Test
    void setShooting() {
    }

    @Test
    void getChecking() {
    }

    @Test
    void setChecking() {
    }

    @Test
    void getSaving() {
    }

    @Test
    void setSaving() {
    }

    @Test
    void agePlayer() {
    }

    @Test
    void checkIfRetired() {
    }

    @Test
    void playerStillInjured() {
    }

    @Test
    void statsDecayDueToBirthDay() {
    }

    @Test
    void convertFreeAgentToPlayer() {
    }

    @Test
    void checkPosition() {
    }

    @Test
    void strengthCalculator() {
    }

    @Test
    void calculateStrength() {
    }

    @Test
    void replacePlayerWithFreeAgent() {
    }

    @Test
    void checkForPlayerInjury() {
    }

    @Test
    void getFreeAgentFromList() {
    }

//    @Test
//    void retireFreeAgents() {
//        List<IFreeAgents> freeAgentsList= mockFreeAgent.retireFreeAgentMockList();
//        for(IFreeAgents freeAgents: freeAgentsList) {
//            freeAgentsList = freeAgents.retireFreeAgents(freeAgentsList);
//        }
//        assertEquals(2, freeAgentsList.size());
//    }
}

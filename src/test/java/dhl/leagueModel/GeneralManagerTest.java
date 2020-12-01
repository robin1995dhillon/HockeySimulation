package dhl.leagueModel;

import dhl.mock.MockGeneralManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralManagerTest {

    IGeneralManager generalManager;
    MockGeneralManager mockGeneralManager;

    public GeneralManagerTest() {
        mockGeneralManager = new MockGeneralManager();
    }

    @Test
    void getName() {
        generalManager = mockGeneralManager.createGeneralManager();
        assertEquals("General1", generalManager.getName());
    }

    @Test
    void setName() {
        generalManager = mockGeneralManager.createGeneralManager();
        generalManager.setName("Manager2");
        assertEquals("Manager2", generalManager.getName());
    }

    @Test
    void getPersonality() {
        generalManager = mockGeneralManager.createGeneralManager();
        assertEquals("gambler", generalManager.getPersonality());
    }

    @Test
    void setPersonality() {
        generalManager = mockGeneralManager.createGeneralManager();
        generalManager.setPersonality("shrewd");
        assertEquals("shrewd", generalManager.getPersonality());
    }

    @Test
    void getManagerFromList() {
        List<IGeneralManager> generalManagerList = mockGeneralManager.createGeneralManagerList();
        generalManager = mockGeneralManager.createGeneralManager();
        IGeneralManager selectedManager = generalManager.getManagerFromList(generalManagerList, "General1");
        assertEquals("General1", selectedManager.getName());
    }
}

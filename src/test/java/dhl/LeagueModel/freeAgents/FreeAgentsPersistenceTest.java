package dhl.LeagueModel.freeAgents;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentsPersistenceTest {

    @Test
    void saveFreeAgentsToDB() {
        IFreeAgentsPersistence freeAgentsPersistence = new FreeAgentsPersistence();
        int [] freeAgentAttributes= {15,16,17,18};
        JSONObject resultObject = freeAgentsPersistence.saveFreeAgentsToDB("Free1", "forward", 25,freeAgentAttributes,1);
        assertEquals(true, resultObject.get("Status"));
    }
}
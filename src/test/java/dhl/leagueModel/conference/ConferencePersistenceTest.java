package dhl.leagueModel.conference;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConferencePersistenceTest {

    @Test
    void saveConferenceToDB() {
        IConferencePersistence conferencePersistence = new ConferencePersistence();
        JSONObject returnObject = conferencePersistence.saveConferenceToDB("Western Conference!");
        assertEquals(true, returnObject.get("Status"));
    }

    @Test
    void saveConferenceToDBFail() {
        IConferencePersistence conferencePersistence = new ConferencePersistence();
        JSONObject returnObject = conferencePersistence.saveConferenceToDB("");
        assertEquals(false, returnObject.get("Status"));
    }
}
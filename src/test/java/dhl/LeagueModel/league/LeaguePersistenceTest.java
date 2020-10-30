package dhl.LeagueModel.league;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaguePersistenceTest {

    @Test
    void saveLeagueToDB() {
        ILeaguePersistence leaguePersistence = new LeaguePersistence();
        JSONObject result_object = leaguePersistence.saveLeagueToDB("Devam League");
        assertEquals(true,result_object.get("Status"));
    }

    @Test
    void saveLeagueToDBFail() {
        ILeaguePersistence leaguePersistence = new LeaguePersistence();
        JSONObject result_object = leaguePersistence.saveLeagueToDB("");
        assertEquals(false,result_object.get("Status"));
    }
}
package dhl.LeagueModel.division;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionPersistenceTest {

    @Test
    void saveDivisionToDB() {
        IDivisionPersistence divisionPersistence = new DivisionPersistence();
        JSONObject resultObject = divisionPersistence.saveDivisionToDB("Atlantic!");
        assertEquals(true, resultObject.get("Status"));
    }

}
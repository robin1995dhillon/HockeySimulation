package dhl.serializeAndDeserialize.deserialize;

import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeserializeJSONToModelTest {

    @Test
    void jsonToLeague() {
        ILeague league = new League();
        DeserializeJSONToModel deserializeJSONToModel = new DeserializeJSONToModel();
        ILeague league2 = deserializeJSONToModel.jsonToLeague("src/New_Data.json");
        assertEquals(league.getClass(), league2.getClass());
    }
}
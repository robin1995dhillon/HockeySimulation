package dhl.serializeAndDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import dhl.leagueModel.ILeague;
import dhl.mock.MockLeague;
import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SerializeModelToJSONTest {
    ISerializeModelToJSON toJSON = new SerializeModelToJSON();

    @Test
    void serializeModelToJSONTest(){
        ILeague league = MockLeague.createMock();
        try {
            String mapJackson = toJSON.serializeModelToJSON(league);
            assertTrue(mapJackson.indexOf("Dalhousie League") > 0);
            assertTrue(mapJackson.indexOf("Eastern Conference") > 0);
            assertTrue(mapJackson.indexOf("HalifaxTigers") > 0);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

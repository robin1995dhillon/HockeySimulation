package dhl.serializeAndDeserialize;

import dhl.leagueModel.league.ILeague;
import dhl.mock.MockLeague;
import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SerializeModelToJSONTest {

    @Test
    void serializeModelToJSONTest() throws IOException {
        ILeague league = MockLeague.createMock();
        ISerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}
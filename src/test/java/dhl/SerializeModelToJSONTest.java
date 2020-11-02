package dhl;

import dhl.leagueModel.league.ILeague;
import dhl.mock.MockLeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SerializeModelToJSONTest {

    @Test
    void serializeModelToJSONTest() throws IOException {
        ILeague league = MockLeague.createMock();
        SerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}
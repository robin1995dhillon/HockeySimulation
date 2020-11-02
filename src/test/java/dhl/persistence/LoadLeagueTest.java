package dhl.persistence;

import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
import dhl.leagueModel.league.ILeague;
import dhl.persistence.loading.ILoadLeague;
import dhl.persistence.loading.LoadLeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LoadLeagueTest {
    @Test
    public void loadLeagueTest() throws IOException, SQLException {
        ILoadLeague load = new LoadLeague();
        ILeague league = load.loadLeague("Detroit Warriors");
        ISerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}

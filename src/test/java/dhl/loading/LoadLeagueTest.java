package dhl.loading;

import dhl.SerializeModelToJSON;
import dhl.leagueModel.league.ILeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LoadLeagueTest {
    @Test
    public void loadLeagueTest() throws IOException, SQLException {
        ILoadLeague load = new LoadLeague();
        ILeague league = load.loadLeague("Detroit Warriors");
        SerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}

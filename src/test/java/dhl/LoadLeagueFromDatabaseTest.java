package dhl;

import dhl.leagueModel.league.ILeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LoadLeagueFromDatabaseTest {
    @Test
    public void loadLeagueFromDatabaseTest() throws IOException, SQLException {
        LoadLeagueFromDatabase l = new LoadLeagueFromDatabase();
        ILeague league = l.loadLeagueFromDatabase("Detroit Warriors");
        SerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}

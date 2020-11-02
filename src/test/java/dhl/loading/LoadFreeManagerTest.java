package dhl.loading;

import dhl.SerializeModelToJSON;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LoadFreeManagerTest {
    @Test
    public void loadFreeManagerTest() throws IOException, SQLException {
        ILoadFreeManager l = new LoadFreeManager();
        ILeague league = new League("abc");
        league.setGeneralManager(l.loadFreeManager(1));
        SerializeModelToJSON s = new SerializeModelToJSON();
        System.out.println(s.serializeModelToJSON(league));
    }
}

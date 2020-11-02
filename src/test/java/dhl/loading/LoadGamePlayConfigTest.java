package dhl.loading;

import dhl.SerializeModelToJSON;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class LoadGamePlayConfigTest {
    @Test
    public void loadGameConfigTest() throws IOException, SQLException {
        ILoadGamePlayConfig l = new LoadGamePlayConfig();
        ILeague league = new League("abc");
        league.setGameplayConfig(l.loadGameGonfig(1));
        SerializeModelToJSON s = new SerializeModelToJSON();
        System.out.println(s.serializeModelToJSON(league));
    }
}

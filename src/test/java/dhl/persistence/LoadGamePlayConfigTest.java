//package dhl.persistence;
//
//import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
//import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
//import dhl.leagueModel.league.ILeague;
//import dhl.leagueModel.league.League;
//import dhl.persistence.loading.ILoadGamePlayConfig;
//import dhl.persistence.loading.LoadGamePlayConfig;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class LoadGamePlayConfigTest {
//    @Test
//    public void loadGameConfigTest() throws IOException, SQLException {
//        ILoadGamePlayConfig l = new LoadGamePlayConfig();
//        ILeague league = new League("abc");
//        league.setGameplayConfig(l.loadGameConfig(1));
//        ISerializeModelToJSON s = new SerializeModelToJSON();
//        System.out.println(s.serializeModelToJSON(league));
//    }
//}

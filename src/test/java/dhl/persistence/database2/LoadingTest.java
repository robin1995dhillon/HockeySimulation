//package dhl.persistence.database2;
//
//import dhl.leagueModel.league.ILeague;
//import dhl.persistence.loading.ILoadLeague;
//import dhl.persistence.loading.LoadLeague;
//import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
//import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class LoadingTest {
//    @Test
//    public void loadLeagueTest(){
//        ILoadLeague load = new LoadLeague();
//        try {
//            ILeague league = load.loadLeague("Detroit Warriors");
//            ISerializeModelToJSON s = new SerializeModelToJSON();
//            System.out.println(s.serializeModelToJSON(league));
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}

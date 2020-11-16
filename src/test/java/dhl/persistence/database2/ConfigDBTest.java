//package dhl.persistence.database2;
//
//import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class ConfigDBTest {
////    @Test
////    public void createConfigTest(){
////        IConfigDB c = new ConfigDB();
////        IGamePlayConfig config = MockGamePlayConfig.createMock();
////        try {
////            c.createConfig(config, 3);
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getConfigTest(){
//        IConfigDB c = new ConfigDB();
//        try {
//            IGamePlayConfig config = c.getConfig(3);
//            System.out.println(config.getAging().getAverageRetirementAge());
//            System.out.println(config.getTrading().getMaxPlayersPerTrade());
//            System.out.println(config.getInjuries().getInjuryDaysHigh());
//            } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }
//}

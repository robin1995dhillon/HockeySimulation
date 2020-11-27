//package dhl.persistence.database2;
//
//import dhl.leagueModel.IPlayers;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class PlayerDBTest {
////    @Test
////    public void createPlayerTest(){
////        IPlayerDB p = new PlayerDB();
////        IPlayers player = MockPlayer.createMock();
////        try {
////            p.createPlayer(player, 50);
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getTeamPlayerTest(){
//        IPlayerDB p = new PlayerDB();
//        try {
//            List<IPlayers> playerList = p.getTeamPlayer(1);
//            for(IPlayers player : playerList){
//                System.out.print(player.getPlayerName() + "\t");
//                System.out.print(player.getPosition() + "\t");
//                System.out.println(player.getAge() + "\t");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }
//}

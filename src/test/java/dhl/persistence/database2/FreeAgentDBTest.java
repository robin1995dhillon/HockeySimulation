//package dhl.persistence.database2;
//
//import dhl.leagueModel.IFreeAgents;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class FreeAgentDBTest {
////    @Test
////    public void createFreeAgentTest(){
////        IFreeAgentDB f = new FreeAgentDB();
////        IFreeAgents freeAgent = MockFreeAgent.createMock();
////        try {
////            f.createFreeAgent(freeAgent, 2);
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getFreeAgentTest(){
//        IFreeAgentDB f = new FreeAgentDB();
//        try {
//            List<IFreeAgents> freeAgentList = f.getFreeAgent(1);
//            for(IFreeAgents freeAgent : freeAgentList){
//                System.out.print(freeAgent.getPlayerName() + "\t");
//                System.out.print(freeAgent.getPosition() + "\t");
//                System.out.println(freeAgent.getAge());
//            }
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}

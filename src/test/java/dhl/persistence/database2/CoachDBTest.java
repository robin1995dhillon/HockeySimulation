//package dhl.persistence.database2;
//
//import dhl.leagueModel.headCoach.IHeadCoach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class CoachDBTest {
////    @Test
////    public void createHeadCoach(){
////        ICoachDB c = new CoachDB();
////        IHeadCoach coach = MockHeadCoach.createMock();
////        try {
////            c.createHeadCoach(coach, 50);
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
////    @Test
////    public void createFreeCoach(){
////        ICoachDB c = new CoachDB();
////        IHeadCoach coach = MockHeadCoach.createMock();
////        try {
////            c.createFreeCoach(coach, 3);
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getHeadCoach(){
//        ICoachDB c = new CoachDB();
//        try {
//            IHeadCoach headcoach = c.getHeadCoach(1);
//            System.out.println(headcoach.getName());
//            System.out.println(headcoach.getSkating());
//            System.out.println(headcoach.getShooting());
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getFreeCoach(){
//        ICoachDB c = new CoachDB();
//        try {
//            List<IHeadCoach> coachList = c.getFreeCoach(1);
//            for(IHeadCoach freeCoach : coachList){
//                System.out.print(freeCoach.getName() + "\t");
//                System.out.print(freeCoach.getSkating() + "\t");
//                System.out.println(freeCoach.getShooting());
//            }
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}

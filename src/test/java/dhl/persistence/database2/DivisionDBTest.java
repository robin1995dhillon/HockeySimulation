//package dhl.persistence.database2;
//
//import dhl.leagueModel.division.IDivision;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class DivisionDBTest {
////    @Test
////    public void createDivisionTest(){
////        IDivisionDB d = new DivisionDB();
////        try {
////            System.out.println(d.createDivision("nasjn"));
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getAllDivisionInConferenceTest(){
//        IDivisionDB d = new DivisionDB();
//        try {
//            List<IDivision> divisionList = d.getAllDivisionInConference(1);
//            for(IDivision division : divisionList){
//                System.out.println(division.getDivisionName());
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }
//}

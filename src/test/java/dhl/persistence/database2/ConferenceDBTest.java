//package dhl.persistence.database2;
//
//import dhl.leagueModel.conference.IConference;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ConferenceDBTest {
////    @Test
////    public void createConferenceTest(){
////        IConferenceDB c = new ConferenceDB();
////        try {
////            System.out.println(c.createConference("zxc"));
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void getAllConferenceInLeague(){
//        IConferenceDB c = new ConferenceDB();
//        try {
//            List<IConference> conferenceList = c.getAllConferenceInLeague(1);
//            for(IConference conference : conferenceList){
//                System.out.println(conference.getConferenceName());
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }
//}

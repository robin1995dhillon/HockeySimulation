//package dhl.LeagueModel;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ConferenceTest {
//
//    @Test
//    void getConferenceName() {
//        IConference IConferenceTest = new Conference("Conference1");
//        assertEquals("Conference1", IConferenceTest.getConferenceName());
//    }
//
//    @Test
//    void setConferenceName() {
//        IConference IConference = new Conference("Eastern");
//        IConference.setConferenceName("Western");
//        assertEquals("Western", IConference.getConferenceName());
//    }
//
//    @Test
//    void getDivisions() {
//        IDivision d = new Division();
//        d.setDivisionName("Atlantic");
//        d.setTeams(new ArrayList<Teams>());
//        ArrayList<IDivision> div_array = new ArrayList<>();
//        div_array.add(d);
//        IConference IConference = new Conference("Eastern",div_array);
//        IConference.getDivisions();
//        assertEquals(d, IConference.getDivisions().get(0));
//    }
//
//    @Test
//    void setDivisions() {
//        IDivision d = new Division();
//        d.setDivisionName("Atlantic");
//        d.setTeams(new ArrayList<Teams>());
//        ArrayList<IDivision> div_array = new ArrayList<>();
//        div_array.add(d);
//        IConference IConference = new Conference("Eastern",div_array);
//        IConference.getDivisions();
//        IDivision d2 = new Division();
//        d2.setDivisionName("Metropolitian");
//        ArrayList<IDivision> div_array_2 = new ArrayList<>();
//        div_array_2.add(d2);
//        IConference.setDivisions(div_array_2);
//        assertEquals(d2, IConference.getDivisions().get(0));
//    }
//}
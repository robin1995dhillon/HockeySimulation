//import dhl.StoredProcedure;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//public class StoredProcedureTest {
//    @Test
//    public void storedProcedureTest(){
//        try{
//            StoredProcedure s = new StoredProcedure("create_league");
//        }catch(Exception e){
//            assertTrue(false);
//        }
//    }
//    @Test
//    public void addParameterTest(){
//        StoredProcedure s = new StoredProcedure("create_what");
//        s.addParameter("DHL");
//        assertEquals("DHL", s.getName());
//        s.addParameter("group1","Rob","Ruhul");
//        assertEquals("group1", s.getName());
//        assertEquals("Rob", s.getManager());
//        assertEquals("Ruhul", s.getCoach());
//        s.addParameter("zongyu", "goalie", false, 1);
//        assertEquals("zongyu", s.getName());
//        assertEquals("goalie", s.getPosition());
//        assertEquals(false, s.getCaptain());
//        s.addParameter(1,1,1,1);
//        assertEquals(1, s.getLeagueId());
//        assertEquals(1, s.getConferenceId());
//        assertEquals(1, s.getDivisionId());
//        assertEquals(1, s.getTeamId());
//        s.addParameter(1);
//        assertEquals(1, s.getTeamId());
//    }
//}

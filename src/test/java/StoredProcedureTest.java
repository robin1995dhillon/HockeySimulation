/*import dhl.StoredProcedure;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
public class StoredProcedureTest {
    @Test
    public void storedProcedureTest(){
        try{
            StoredProcedure s = new StoredProcedure("create_league");
        }catch(Exception e){
            assertTrue(false);
        }
    }
    @Test
    public void addParameterTest(){
        StoredProcedure s = new StoredProcedure("create_what");
        s.addParameter("DHL");
        assertEquals("DHL", s.getName());
        s.addParameter("group1","Rob","Ruhul");
        assertEquals("group1", s.getName());
        assertEquals("Rob", s.getManager());
        assertEquals("Ruhul", s.getCoach());
        s.addParameter("zongyu", "goalie", false, 1);
        assertEquals("zongyu", s.getName());
        assertEquals("goalie", s.getPosition());
        assertEquals(false, s.getCaptain());
        s.addParameter(1,1,1,1);
        assertEquals(1, s.getLeagueId());
        assertEquals(1, s.getConferenceId());
        assertEquals(1, s.getDivisionId());
        assertEquals(1, s.getTeamId());
        s.addParameter(1);
        assertEquals(1, s.getTeamId());
    }
/*    @Test
    public void executeProcedure() throws IOException {
        StoredProcedure s1 = new StoredProcedure("create_DHL_table");
        s1.addParameter(1,1,1,1);
        s1.executeProcedure();
//        s1.addParameter("Dev1","Goalie", false, 1);
//        s1.addParameter("Normal Hockey League");
//        System.out.println(s1.getInsertedId());
//        s1.executeProcedure();

//        System.out.print(s1.getTeamId());
//        StoredProcedure s2 = new StoredProcedure("get_team");
//        s2.addParameter(1);
//        s2.executeProcedure();
//        StoredProcedure s3 = new StoredProcedure("get_team_player");
//        s3.addParameter(1);
//        s3.executeProcedure();
    }
}
*/

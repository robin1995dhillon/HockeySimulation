import dhl.StoredProcedure;
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
        s.addParameter(1, "DHL");
        assertEquals(1, s.getId());
        assertEquals("DHL", s.getName());
        s.addParameter(1, "group1","Rob","Ruhul");
        assertEquals(1, s.getId());
        assertEquals("group1", s.getName());
        assertEquals("Rob", s.getManager());
        assertEquals("Ruhul", s.getCoach());
        s.addParameter(1, "zongyu", "goalie", false, 1);
        assertEquals(1, s.getId());
        assertEquals("zongyu", s.getName());
        assertEquals("goalie", s.getPosition());
        assertEquals(false, s.getCaptain());
        assertEquals(1, s.getTeamId());
        s.addParameter(1,1,1,1,1);
        assertEquals(1, s.getId());
        assertEquals(1, s.getLeagueId());
        assertEquals(1, s.getConferenceId());
        assertEquals(1, s.getDivisionId());
        assertEquals(1, s.getTeamId());
        s.addParameter(1);
        assertEquals(1, s.getTeamId());
    }

    @Test
    public void executeProcedure() throws IOException {
        StoredProcedure s = new StoredProcedure("get_team_player");
        //s.addParameter(4, "IronMan", "Tony", "Stark");
        s.addParameter(1);
        s.executeProcedure();
    }
}



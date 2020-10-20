package dhl.Database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTeamTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateTeam("abc", "zongyu", "wu");
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException {
        ICreateStoredProcedure s = new CreateTeam("abc", "zongyu", "wu");
        s.executeProcedure();
    }
}

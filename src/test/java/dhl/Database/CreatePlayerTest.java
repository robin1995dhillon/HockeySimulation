package dhl.Database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePlayerTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreatePlayer("zongyu", "goalie", false, 1);
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException {
        ICreateStoredProcedure s = new CreatePlayer("zongyu", "goalie", false, 1);
        s.executeProcedure();
    }
}

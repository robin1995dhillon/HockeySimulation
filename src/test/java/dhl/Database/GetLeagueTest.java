package dhl.Database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetLeagueTest {
    @Test
    public void CreateLeagueTest(){
        try{
            IStoredProcedure s = new GetLeague("DHL");
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException {
        IStoredProcedure s = new GetLeague("DHL");
        s.executeProcedure();
    }
}

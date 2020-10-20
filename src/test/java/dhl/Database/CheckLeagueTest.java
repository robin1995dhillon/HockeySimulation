package dhl.Database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckLeagueTest {
    @Test
    public void CreateLeagueTest(){
        try{
            ICheckStoredProcedure s = new CheckLeague("DHL");
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException {
        ICheckStoredProcedure s = new CheckLeague("DHL");
        s.executeProcedure();
        assertTrue(s.getExist());
        ICheckStoredProcedure s1 = new CheckLeague("asdfghjkl");
        s1.executeProcedure();
        assertFalse(s1.getExist());
    }
}

package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreateLeagueTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateLeague("DHL");
        }catch(Exception e){
            assertTrue(false);
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICreateStoredProcedure s = new CreateLeague("DHL");
//        s.executeProcedure();
//        assertEquals(1, s.getInsertedId());
//    }
}

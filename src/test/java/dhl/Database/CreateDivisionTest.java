package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateDivisionTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateDivision("Atlantic");
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        ICreateStoredProcedure s = new CreateDivision("Atlantic");
        s.executeProcedure();
    }
}

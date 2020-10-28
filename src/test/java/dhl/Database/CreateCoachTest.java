package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCoachTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateCoach("Joe Smith", 0.5,0.8,0.3,1.0,1);
        }catch(Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        ICreateStoredProcedure s = new CreateCoach("Joe Smith", 0.5,0.8,0.3,1.0,1);
        s.executeProcedure();
    }
}

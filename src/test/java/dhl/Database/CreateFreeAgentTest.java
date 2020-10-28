package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CreateFreeAgentTest {
    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateFreeAgent("zongyu", "goalie", 22,10,10,10,10,1);
        }catch(Exception e){
            fail();
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        ICreateStoredProcedure s = new CreateFreeAgent("zongyu", "goalie", 22,10,10,10,10,1);
        s.executeProcedure();
    }
}

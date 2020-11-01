package dhl.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CreatePlayerTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreatePlayer("zongyu", "goalie", false, 22,10,4,9,18,1,false, false, 0);
        }catch(Exception e){
            fail();
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICreateStoredProcedure s = new CreatePlayer("zongyu", "goalie", false, 22,10,4,9,18,1, false,false,0);
//        s.executeProcedure();
//    }
}

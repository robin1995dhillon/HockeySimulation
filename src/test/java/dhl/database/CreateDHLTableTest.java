package dhl.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateDHLTableTest {
    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateDHLTable(1,1,1, 1);
        }catch(Exception e){
            assertTrue(false);
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICreateStoredProcedure s = new CreateDHLTable(1,1,1, 1);
//        s.executeProcedure();
//    }
}

package dhl.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateConferenceTest {

    @Test
    public void CreateLeagueTest(){
        try{
            ICreateStoredProcedure s = new CreateConference("Eastern Conference");
        }catch(Exception e){
            assertTrue(false);
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICreateStoredProcedure s = new CreateConference("Eastern Conference");
//        s.executeProcedure();
//    }
}

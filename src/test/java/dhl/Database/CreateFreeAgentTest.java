//package dhl.Database;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class CreateFreeAgentTest {
//    @Test
//    public void CreateLeagueTest(){
//        try{
//            ICreateStoredProcedure s = new CreateFreeAgent("zongyu", "goalie", 1);
//        }catch(Exception e){
//            assertTrue(false);
//        }
//    }
//
//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICreateStoredProcedure s = new CreateFreeAgent("zongyu", "goalie", 1);
//        s.executeProcedure();
//    }
//}

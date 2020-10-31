package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

public class GetDHLTableTest {
    @Test
    public void GetDHLTableTest(){
        try{
            IGetStoredProcedure s = new GetDHLTable(1);
        }catch(Exception e){
            fail();
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        IGetStoredProcedure s = new GetDHLTable(1);
//        ResultSet rs = s.executeProcedure();
//        while(rs.next()){
//            System.out.print("ID: " + rs.getInt("id"));
//            System.out.print(", League ID: " + rs.getInt("league_id"));
//            System.out.print(", Conference ID: " + rs.getInt("conference_id"));
//            System.out.print(", Division ID: " + rs.getInt("division_id"));
//            System.out.println(", Team ID: " + rs.getInt("team_id"));
//        }
//        s.closeConnection();
//    }
}

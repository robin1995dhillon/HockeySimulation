package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

public class GetDivisionTest {
    @Test
    public void CreateLeagueTest(){
        try{
            IGetStoredProcedure s = new GetDivision(1);
        }catch(Exception e){
            fail();
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetDivision(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println(", Name: " + rs.getString("name"));
        }
        s.closeConnection();
    }
}

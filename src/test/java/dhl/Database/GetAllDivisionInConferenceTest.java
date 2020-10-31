package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllDivisionInConferenceTest {

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetAllDivisionInConference(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println(", Name: " + rs.getString("name"));
        }
        s.closeConnection();
    }
}

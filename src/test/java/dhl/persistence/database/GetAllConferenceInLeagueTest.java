package dhl.persistence.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetAllConferenceInLeagueTest {
    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetAllConferenceInLeague(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println(", Name: " + rs.getString("name"));
        }
        s.closeConnection();
    }
}

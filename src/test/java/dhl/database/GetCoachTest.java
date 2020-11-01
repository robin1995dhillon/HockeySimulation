package dhl.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCoachTest {
    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetCoach(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Skating: " + rs.getDouble("skating"));
            System.out.print(", Shooting: " + rs.getDouble("shooting"));
            System.out.print(", Checking: " + rs.getDouble("checking"));
            System.out.print(", Saving: " + rs.getDouble("saving"));
            System.out.println(", Team ID: " + rs.getInt("team_id"));
        }
        s.closeConnection();
    }
}

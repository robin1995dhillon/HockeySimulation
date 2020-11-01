package dhl.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetConfigTest {
    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetConfig(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Average Retirement Age: " + rs.getInt("average_retirement_age"));
            System.out.println("Maximum Age: " + rs.getInt("maximum_age"));
            System.out.println("Random Win Chance: " + rs.getDouble("random_win_chance"));
            System.out.println("League ID: " + rs.getInt("league_id"));
        }
        s.closeConnection();
    }
}

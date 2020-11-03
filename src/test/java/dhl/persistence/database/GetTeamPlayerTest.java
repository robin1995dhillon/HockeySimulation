package dhl.persistence.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

public class GetTeamPlayerTest {
    @Test
    public void GetTeamPlayerTest() {
        try {
            IGetStoredProcedure s = new GetTeamPlayer(1);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetTeamPlayer(1);
        ResultSet rs = s.executeProcedure();
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Position: " + rs.getString("position"));
            System.out.print(", Captain: " + rs.getBoolean("captain"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", Skating: " + rs.getInt("skating"));
            System.out.print(", Shooting: " + rs.getInt("shooting"));
            System.out.print(", Checking: " + rs.getInt("checking"));
            System.out.print(", Saving: " + rs.getInt("saving"));
            System.out.print(", Team ID: " + rs.getInt("team_id"));
            System.out.print(", Injured: " + rs.getBoolean("injured"));
            System.out.print(", Retired: " + rs.getBoolean("retired"));
            System.out.println(", Injury Days: " + rs.getInt("injury_days"));
        }
        s.closeConnection();
    }
}

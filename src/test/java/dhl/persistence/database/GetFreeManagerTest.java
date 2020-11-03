package dhl.persistence.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetFreeManagerTest {
    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetFreeManager(1);
        ResultSet rs = s.executeProcedure();
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.println(", League ID: " + rs.getInt("league_id"));
        }
        s.closeConnection();
    }
}

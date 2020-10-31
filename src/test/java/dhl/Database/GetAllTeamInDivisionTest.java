package dhl.Database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllTeamInDivisionTest {
    @Test
    public void executeProcedureTest() throws SQLException, IOException {
        IGetStoredProcedure s = new GetAllTeamInDivision(1);
        ResultSet rs = s.executeProcedure();
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Manager: " + rs.getString("general_manager"));
            System.out.println(", Coach: " + rs.getString("head_coach"));
        }
        s.closeConnection();
    }
}

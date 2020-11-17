package dhl.persistence.database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

public class GetTeamByNameTest {
    @Test
    public void GetTeamByNameTest() {
        try {
            IGetStoredProcedure s = new GetTeamByName("Detroit Warriors");
        } catch (Exception e) {
            fail();
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        IGetStoredProcedure s = new GetTeamByName("Detroit Warriors");
//        ResultSet rs = s.executeProcedure();
//        while (rs.next()) {
//            System.out.print("ID: " + rs.getInt("id"));
//            System.out.print(", Name: " + rs.getString("name"));
//            System.out.print(", Manager: " + rs.getString("general_manager"));
//            System.out.println(", Coach: " + rs.getString("head_coach"));
//        }
//        s.closeConnection();
//    }
}

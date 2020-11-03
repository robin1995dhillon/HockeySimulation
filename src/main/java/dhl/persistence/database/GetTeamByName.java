package dhl.persistence.database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTeamByName implements IGetStoredProcedure {
    private String procedureName;
    private String name;
    private IConnect conn;

    public GetTeamByName(String name) {
        this.procedureName = "get_team_by_name";
        this.name = name;
        this.conn = new Connect();
    }

    @Override
    public ResultSet executeProcedure() throws SQLException, IOException {
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "('" + this.name + "')}";
        Statement stmt = conn.getStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    @Override
    public void closeConnection() {
        conn.closeConnection();
    }
}

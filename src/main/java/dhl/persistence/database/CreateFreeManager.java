package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateFreeManager implements ICreateStoredProcedure {
    private String procedureName;
    private String name;
    private int leagueId;
    private int insertedId;

    public CreateFreeManager(String name, int leagueId) {
        this.procedureName = "create_free_manager";
        this.name = name;
        this.leagueId = leagueId;
    }

    @Override
    public int getInsertedId() {
        return this.insertedId;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "(?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setInt(2, this.leagueId);
        boolean hasResultSet = stmt.execute();
        if (hasResultSet) {
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                this.insertedId = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }
}

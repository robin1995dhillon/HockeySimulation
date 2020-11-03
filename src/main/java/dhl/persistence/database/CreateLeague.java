package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateLeague implements ICreateStoredProcedure {

    private String procedureName;
    private String name;
    private int insertedId;

    public CreateLeague(String name) {
        this.procedureName = "create_league";
        this.name = name;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        ResultSet rs = conn.gerResultSet();
        String sql = "{CALL " + this.procedureName + "(?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        boolean hasResultSet = stmt.execute();
        if (hasResultSet) {
            rs = stmt.getResultSet();
            while (rs.next()) {
                this.insertedId = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }

    @Override
    public int getInsertedId() {
        return this.insertedId;
    }
}

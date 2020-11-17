package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CheckTeam implements ICheckStoredProcedure {
    private String procedureName;
    private String name;
    private boolean exist;

    public CheckTeam(String name) {
        this.procedureName = "check_team";
        this.name = name;
        this.exist = false;
    }

    @Override
    public boolean getExist() {
        return this.exist;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "(?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        boolean hasResult = stmt.execute();
        if(hasResult){
            ResultSet rs = stmt.getResultSet();
            while(rs.next()) {
                this.exist = rs.getBoolean(1);
            }
        }
        conn.closeConnection();
    }
}

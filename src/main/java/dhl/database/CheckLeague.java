package dhl.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CheckLeague implements ICheckStoredProcedure{
    private String procedureName;
    private String name;
    private boolean exist;

    public CheckLeague(String name){
        this.procedureName = "check_league";
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
        String sql = "{CALL " + this.procedureName + "(?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.registerOutParameter(2, Types.BOOLEAN);
        stmt.execute();
        this.exist = stmt.getBoolean(2);
        conn.closeConnection();
    }
}

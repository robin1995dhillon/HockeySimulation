package dhl.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetFreeCoach implements IGetStoredProcedure{
    private String procedureName;
    private int id;
    private IConnect conn;

    public GetFreeCoach(int id){
        this.procedureName = "get_free_coach";
        this.id = id;
        this.conn = new Connect();
    }

    @Override
    public ResultSet executeProcedure() throws SQLException, IOException {
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "(" + this.id + ")}";
        Statement stmt = conn.getStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    @Override
    public void closeConnection() {
        conn.closeConnection();
    }
}
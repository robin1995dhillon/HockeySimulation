package dhl.Database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateFreeAgent implements ICreateStoredProcedure{
    private String procedureName;
    private String name;
    private String position;
    private int leagueId;
    private int insertedId;

    public CreateFreeAgent(String name, String position, int leagueId){
        this.procedureName = "create_free_agent";
        this.name = name;
        this.position = position;
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
        ResultSet rs = conn.gerResultSet();
        String sql = "{CALL " + this.procedureName + "(?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setString(2, this.position);
        stmt.setInt(3, this.leagueId);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            rs = stmt.getResultSet();
            while(rs.next()){
                this.insertedId = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }
}

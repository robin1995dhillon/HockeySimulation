package dhl.Database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateDHLTable implements ICreateStoredProcedure{
    private String procedureName;
    private int leagueId;
    private int conferenceId;
    private int divisionId;
    private int teamId;
    private int insertedId;

    public CreateDHLTable(int leagueId, int conferenceId, int divisionId, int teamId){
        this.procedureName = "create_DHL_table";
        this.leagueId = leagueId;
        this.conferenceId = conferenceId;
        this.divisionId = divisionId;
        this.teamId = teamId;
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
        String sql = "{CALL " + this.procedureName + "(?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setInt(1, this.leagueId);
        stmt.setInt(2, this.conferenceId);
        stmt.setInt(3, this.divisionId);
        stmt.setInt(4, this.teamId);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            rs = stmt.getResultSet();
            while(rs.next()){
                this.insertedId  = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }
}

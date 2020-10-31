package dhl.Database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateFreeCoach implements ICreateStoredProcedure{
    private String procedureName;
    private String name;
    private double skating;
    private double shooting;
    private double checking;
    private double saving;
    private int leagueId;
    private int insertedId;

    public CreateFreeCoach(String name, double skating, double shooting, double checking, double saving, int leagueId){
        this.procedureName = "create_free_coach";
        this.name = name;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
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
        String sql = "{CALL " + this.procedureName + "(?,?,?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setDouble(2,this.skating);
        stmt.setDouble(3, this.shooting);
        stmt.setDouble(4,this.checking);
        stmt.setDouble(5, this.saving);
        stmt.setInt(6, this.leagueId);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                this.insertedId  = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }
}

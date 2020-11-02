package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCoach implements ICreateStoredProcedure{

    private String procedureName;
    private String name;
    private double skating;
    private double shooting;
    private double checking;
    private double saving;
    private int teamId;
    private int insertedId;

    public CreateCoach(String name, double skating, double shooting, double checking, double saving, int teamId){
        this.procedureName = "create_coach";
        this.name = name;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
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
        String sql = "{CALL " + this.procedureName + "(?,?,?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setDouble(2,this.skating);
        stmt.setDouble(3, this.shooting);
        stmt.setDouble(4,this.checking);
        stmt.setDouble(5, this.saving);
        stmt.setInt(6, this.teamId);
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

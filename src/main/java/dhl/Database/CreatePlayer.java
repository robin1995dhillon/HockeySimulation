package dhl.Database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreatePlayer implements ICreateStoredProcedure{

    private String procedureName;
    private String name;
    private String position;
    private boolean captain;
    private int age;
    private int skating;
    private int shooting;
    private int checking;
    private int saving;
    private int teamId;
    private boolean isRetired;
    private boolean isInjured;
    private int injuryDays;
    private int insertedId;

    public CreatePlayer(String name, String position, boolean captain, int age, int skating, int shooting, int checking, int saving, int teamId, boolean isRetired, boolean isInjured, int injuryDays){
        this.procedureName = "create_player";
        this.name = name;
        this.position = position;
        this.captain = captain;
        this.age = age;
        this.skating = skating;
        this.shooting = shooting;
        this.checking = checking;
        this.saving = saving;
        this.teamId = teamId;
        this.isRetired = isRetired;
        this.isInjured = isInjured;
        this.injuryDays = injuryDays;
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
        String sql = "{CALL " + this.procedureName + "(?,?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setString(2, this.position);
        stmt.setBoolean(3, this.captain);
        stmt.setInt(4,this.age);
        stmt.setInt(5,this.skating);
        stmt.setInt(6, this.shooting);
        stmt.setInt(7,this.checking);
        stmt.setInt(8, this.saving);
        stmt.setInt(9, this.teamId);
        stmt.setBoolean(10, this.isRetired);
        stmt.setBoolean(11, this.isInjured);
        stmt.setInt(12, this.injuryDays);
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

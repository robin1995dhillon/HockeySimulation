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
    private int teamId;
    private int insertedId;

    public CreatePlayer(String name, String position, boolean captain, int teamId){
        this.procedureName = "create_player";
        this.name = name;
        this.position = position;
        this.captain = captain;
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
        stmt.setString(1, this.name);
        stmt.setString(2, this.position);
        stmt.setBoolean(3, this.captain);
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

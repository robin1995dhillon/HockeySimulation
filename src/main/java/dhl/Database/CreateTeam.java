package dhl.Database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTeam implements ICreateStoredProcedure {
    private String procedureName;
    private String name;
    private String manager;
    private String coach;
    private int insertedId;

    public CreateTeam(String name, String manager, String coach){
        this.procedureName = "create_team";
        this.name = name;
        this.manager = manager;
        this.coach = coach;
    }

    @Override
    public void executeProcedure() throws SQLException {
        IConnect conn = new Connect();
        conn.getConnection();
        ResultSet rs = conn.gerResultSet();
        String sql = "{CALL " + this.procedureName + "(?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setString(2, this.manager);
        stmt.setString(3, this.coach);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            rs = stmt.getResultSet();
            while(rs.next()){
                this.insertedId  = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }

    @Override
    public int getInsertedId(){
        return this.insertedId;
    }
}

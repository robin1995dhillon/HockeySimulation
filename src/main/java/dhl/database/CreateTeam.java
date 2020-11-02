package dhl.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTeam implements ICreateStoredProcedure {
    private String procedureName;
    private String name;
    private String manager;
    private String coach;
    private boolean is_user;
    private int insertedId;

    public CreateTeam(String name, String manager, String coach, boolean is_user){
        this.procedureName = "create_team";
        this.name = name;
        this.manager = manager;
        this.coach = coach;
        this.is_user = is_user;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "(?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        stmt.setString(2, this.manager);
        stmt.setString(3, this.coach);
        stmt.setBoolean(4, this.is_user);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            ResultSet rs = stmt.getResultSet();
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

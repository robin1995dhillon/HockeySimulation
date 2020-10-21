package dhl.Database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLeague implements IStoredProcedure{
    private String procedureName;
    private String name;

    public GetLeague(String name){
        this.procedureName = "get_league";
        this.name = name;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        ResultSet rs = conn.gerResultSet();
        String sql = "{CALL " + this.procedureName + "(?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            rs = stmt.getResultSet();
            while(rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print("\n");
            }
        }
        conn.closeConnection();
    }
}

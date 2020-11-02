package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateDivision implements ICreateStoredProcedure{

    private String procedureName;
    private String name;
    private int insertedId;

    public CreateDivision(String name){
        this.procedureName = "create_division";
        this.name = name;
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
        String sql = "{CALL " + this.procedureName + "(?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
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

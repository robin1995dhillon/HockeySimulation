package dhl.Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface IConnect {
    public Connection getConnection() throws IOException;
    public CallableStatement getStatement(String sql);
    public ResultSet gerResultSet();
    public void closeConnection();
}

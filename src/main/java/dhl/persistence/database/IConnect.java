package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public interface IConnect {
    Connection getConnection() throws IOException;

    CallableStatement getStatement(String sql);

    Statement getStatement();

    ResultSet gerResultSet();

    void closeConnection();
}

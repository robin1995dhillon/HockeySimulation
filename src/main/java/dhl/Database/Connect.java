package dhl.Database;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class Connect implements IConnect{

    private Connection conn = null;
    private CallableStatement stmt = null;
    private ResultSet rs = null;

    @Override
    public Connection getConnection() throws IOException {
        Properties prop = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream("application.properties"));
        prop.load(in);
        String url = prop.getProperty("dburl");
        String user = prop.getProperty("dbuser");
        String password = prop.getProperty("dbpass");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public CallableStatement getStatement(String sql) {
        try {
            stmt = conn.prepareCall(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.stmt;
    }

    @Override
    public Statement getStatement() {
        try {
            return conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet gerResultSet() {
        return this.rs;
    }

    @Override
    public void closeConnection(){
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package dhl.Database;


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
//        InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
//        Properties properties = new Properties();
//        properties.load(in);
//        String url = properties.getProperty("dburl");
//        String user = properties.getProperty("dbuser");
//        String password = properties.getProperty("dbpass");
        String url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_DEVINT?user=CSCI5308_1_DEVINT_USER&serverTimezone=UTC";
        String user = "CSCI5308_1_DEVINT_USER";
        String password = "B6D4tje9aC";
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
        }if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

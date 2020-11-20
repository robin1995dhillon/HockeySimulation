//package dhl.persistence.database2;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class Connect2 implements IConnect2{
//    @Override
//    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
//        Properties prop = new Properties();
//        InputStream in = new BufferedInputStream(new FileInputStream("application.properties"));
//        prop.load(in);
//        String url = prop.getProperty("dburl");
//        String user = prop.getProperty("dbuser");
//        String password = prop.getProperty("dbpass");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection(url, user, password);
//        return conn;
//    }
//}

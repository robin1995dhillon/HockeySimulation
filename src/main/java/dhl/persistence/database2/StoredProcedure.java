//package dhl.persistence.database2;
//
//import dhl.persistence.database.Connect;
//import dhl.persistence.database.IConnect;
//
//import java.io.IOException;
//import java.sql.*;
//
//public class StoredProcedure implements IStoredProcedure{
//    private String procedureName;
//    private Connection connection;
//    private CallableStatement statement;
//
//    public StoredProcedure(String procedureName) throws SQLException, IOException{
//        this.procedureName = procedureName;
//        IConnect conn = new Connect();
//        this.connection = conn.getConnection();
//        this.statement = connection.prepareCall("{call " + procedureName + "}");;
//    }
//
//    @Override
//    public boolean execute() throws SQLException {
//        return statement.execute();
//    }
//
//    @Override
//    public ResultSet getResult() throws SQLException {
//        if(statement.execute()){
//            return statement.getResultSet();
//        }
//        return null;
//    }
//
//    @Override
//    public void closeConnection() {
//        try {
//            if (statement == null) {
//                return;
//            } else {
//                statement.close();
//            }
//            if (connection == null) {
//                return;
//            } else {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void addParameter(int id, int value) throws SQLException {
//        statement.setInt(id, value);
//    }
//
//    @Override
//    public void addParameter(int id, double value) throws SQLException {
//        statement.setDouble(id, value);
//    }
//
//    @Override
//    public void addParameter(int id, boolean value) throws SQLException {
//        statement.setBoolean(id, value);
//    }
//
//    @Override
//    public void addParameter(int id, String value) throws SQLException {
//        statement.setString(id, value);
//    }
//}

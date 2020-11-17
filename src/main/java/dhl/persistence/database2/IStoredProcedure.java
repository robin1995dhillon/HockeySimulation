package dhl.persistence.database2;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IStoredProcedure {
    boolean execute() throws SQLException;
    ResultSet getResult() throws SQLException;
    void closeConnection();
    void addParameter(int id, int value) throws SQLException;
    void addParameter(int id, double value) throws SQLException;
    void addParameter(int id, boolean value) throws SQLException;
    void addParameter(int id, String value) throws SQLException;
}

package dhl.persistence.database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IGetStoredProcedure {
    ResultSet executeProcedure() throws SQLException, IOException;

    void closeConnection();
}

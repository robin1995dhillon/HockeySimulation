package dhl.persistence.database;

import java.io.IOException;
import java.sql.SQLException;

public interface ICreateStoredProcedure {
    void executeProcedure() throws SQLException, IOException;
    int getInsertedId();
}

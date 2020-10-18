package dhl.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IStoredProcedure {
    public void executeProcedure() throws SQLException;
}

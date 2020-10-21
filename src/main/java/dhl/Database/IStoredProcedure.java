package dhl.Database;

import java.io.IOException;
import java.sql.SQLException;

public interface IStoredProcedure {
    public void executeProcedure() throws SQLException, IOException;
}

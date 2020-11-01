package dhl.database;

import java.io.IOException;
import java.sql.SQLException;

public interface ICheckStoredProcedure{
    void executeProcedure() throws SQLException, IOException;
    boolean getExist();
}

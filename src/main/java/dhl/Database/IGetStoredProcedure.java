package dhl.Database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IGetStoredProcedure {
    void executeProcedure() throws SQLException, IOException;
    ArrayList getData();
}

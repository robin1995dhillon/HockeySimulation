package dhl.persistence.database2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface IConnect2 {
    Connection getConnection() throws IOException, ClassNotFoundException, SQLException;
}

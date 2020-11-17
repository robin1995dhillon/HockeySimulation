package dhl.persistence.database2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IManagerDB {
    void createFreeManager(String managerName, int leagueId) throws IOException, SQLException;
    List<String> getFreeManager(int leagueId) throws IOException, SQLException;
    void updateFreeManager();
}

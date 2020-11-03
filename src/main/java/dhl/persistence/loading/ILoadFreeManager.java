package dhl.persistence.loading;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadFreeManager {
    ArrayList<String> loadFreeManager(int leagueId) throws IOException, SQLException;
}

package dhl.loading;

import dhl.leagueModel.freeAgents.IFreeAgents;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadFreeAgent {
    ArrayList<IFreeAgents> loadFreeAgent(int leagueId) throws IOException, SQLException;
}

package dhl.persistence.database2;

import dhl.leagueModel.IFreeAgents;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IFreeAgentDB {
    void createFreeAgent(IFreeAgents freeAgent, int leagueId) throws IOException, SQLException;
    List<IFreeAgents> getFreeAgent(int leagueId) throws IOException, SQLException;
    void updateFreeAgent();
}

package dhl.persistence.loading;

import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.persistence.database.GetFreeAgent;
import dhl.persistence.database.IGetStoredProcedure;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadFreeAgent implements ILoadFreeAgent {
    @Override
    public ArrayList<IFreeAgents> loadFreeAgent(int leagueId) throws IOException, SQLException {
        IGetStoredProcedure getFreeAgent = new GetFreeAgent(leagueId);
        ResultSet rsFreeAgent = getFreeAgent.executeProcedure();
        ArrayList<IFreeAgents> freeAgentList = new ArrayList<>();
        while (rsFreeAgent.next()) {
            IFreeAgents freeAgent = new FreeAgents();
            freeAgent.setPlayerName(rsFreeAgent.getString("name"));
            freeAgent.setPosition(rsFreeAgent.getString("position"));
            freeAgent.setSkating(rsFreeAgent.getInt("skating"));
            freeAgent.setShooting(rsFreeAgent.getInt("shooting"));
            freeAgent.setChecking(rsFreeAgent.getInt("checking"));
            freeAgent.setSaving(rsFreeAgent.getInt("saving"));
            freeAgentList.add(freeAgent);
        }
        return freeAgentList;
    }
}

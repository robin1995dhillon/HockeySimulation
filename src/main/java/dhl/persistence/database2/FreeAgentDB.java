package dhl.persistence.database2;

import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FreeAgentDB implements IFreeAgentDB{

    @Override
    public void createFreeAgent(IFreeAgents freeAgent, int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("create_free_agent(?,?,?,?,?,?,?,?)");
        storedProcedure.addParameter(1, freeAgent.getPlayerName());
        storedProcedure.addParameter(2, freeAgent.getPosition());
        storedProcedure.addParameter(3, freeAgent.getAge());
        storedProcedure.addParameter(4, freeAgent.getSkating());
        storedProcedure.addParameter(5, freeAgent.getShooting());
        storedProcedure.addParameter(6, freeAgent.getChecking());
        storedProcedure.addParameter(7, freeAgent.getSaving());
        storedProcedure.addParameter(8, leagueId);
        storedProcedure.execute();
        storedProcedure.closeConnection();
    }

    @Override
    public List<IFreeAgents> getFreeAgent(int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("get_free_agent(?)");
        storedProcedure.addParameter(1, leagueId);
        ResultSet rs = storedProcedure.getResult();
        if(rs == null){
            System.out.println("This league does not have free agents");
        }
        List<IFreeAgents> freeAgentList = new ArrayList<>();
        while(rs.next()){
            IFreeAgents freeAgent = new FreeAgents();
            freeAgent.setPlayerName(rs.getString("name"));
            freeAgent.setPosition(rs.getString("position"));
            freeAgent.setSkating(rs.getInt("skating"));
            freeAgent.setShooting(rs.getInt("shooting"));
            freeAgent.setChecking(rs.getInt("checking"));
            freeAgent.setSaving(rs.getInt("saving"));
            freeAgentList.add(freeAgent);
        }
        storedProcedure.closeConnection();
        return freeAgentList;
    }

    @Override
    public void updateFreeAgent() {

    }
}

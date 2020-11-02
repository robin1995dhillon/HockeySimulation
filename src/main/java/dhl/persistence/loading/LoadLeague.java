package dhl.persistence.loading;

import dhl.persistence.database.GetLeague;
import dhl.persistence.database.GetTeamByName;
import dhl.persistence.database.IGetStoredProcedure;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadLeague implements ILoadLeague{
    @Override
    public ILeague loadLeague(String teamName) throws IOException, SQLException {
        ILeague league = new League();
        IGetStoredProcedure getTeamId = new GetTeamByName(teamName);
        ResultSet rs = getTeamId.executeProcedure();
        while(rs.next()){
            int teamId = rs.getInt("id");
            IGetStoredProcedure getLeague = new GetLeague(teamId);
            ResultSet rsLeague = getLeague.executeProcedure();
            while(rsLeague.next()){
                int leagueId = rsLeague.getInt("id");
                league.setLeagueName(rsLeague.getString("name"));
                ILoadConference getConference = new LoadConference();
                ArrayList<IConference> conferenceList = getConference.loadConference(leagueId);
                league.setConferences(conferenceList);
                ILoadFreeAgent getFreeAgent = new LoadFreeAgent();
                ArrayList<IFreeAgents> freeAgentList = getFreeAgent.loadFreeAgent(leagueId);
                league.setFreeAgents(freeAgentList);
                ILoadCoach getCoach = new LoadCoach();
                ArrayList<IHeadCoach> coachList = getCoach.loadFreeCoach(leagueId);
                league.setHeadCoach(coachList);
                ILoadFreeManager getManager = new LoadFreeManager();
                ArrayList<String> managerList = getManager.loadFreeManager(leagueId);
                league.setGeneralManager(managerList);
                ILoadGamePlayConfig getConfig = new LoadGamePlayConfig();
                IGamePlayConfig gamePlayConfig = getConfig.loadGameConfig(leagueId);
                league.setGameplayConfig(gamePlayConfig);
            }
        }
        return league;
    }
}

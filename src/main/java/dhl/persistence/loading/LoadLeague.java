package dhl.persistence.loading;


import dhl.leagueModel.league.ILeague;
import dhl.persistence.database2.ILeagueDB;
import dhl.persistence.database2.ITeamDB;
import dhl.persistence.database2.LeagueDB;
import dhl.persistence.database2.TeamDB;
import java.io.IOException;
import java.sql.SQLException;


public class LoadLeague implements ILoadLeague {
    @Override
    public ILeague loadLeague(String teamName) throws IOException, SQLException {
        ITeamDB teamDB = new TeamDB();
        int teamId = teamDB.getTeamIdByTeamName(teamName);
        ILeagueDB leagueDB = new LeagueDB();
        ILeague league = leagueDB.getLeague(teamId);
        return league;
    }
}

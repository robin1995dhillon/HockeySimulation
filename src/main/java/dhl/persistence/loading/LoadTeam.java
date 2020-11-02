package dhl.persistence.loading;

import dhl.persistence.database.GetAllTeamInDivision;
import dhl.persistence.database.IGetStoredProcedure;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadTeam implements ILoadTeam {
    @Override
    public ArrayList<ITeam> loadTeam(int divisionId) throws IOException, SQLException {
        ArrayList<ITeam> teamList = new ArrayList<>();
        IGetStoredProcedure getTeamInDivision = new GetAllTeamInDivision(divisionId);
        ResultSet rsGetTeamInDivision = getTeamInDivision.executeProcedure();
        while(rsGetTeamInDivision.next()){
            int teamId = rsGetTeamInDivision.getInt("id");
            ITeam team = new Teams();
            team.setTeamName(rsGetTeamInDivision.getString("name"));
            team.setGeneralManager(rsGetTeamInDivision.getString("general_manager"));
            ILoadCoach getCoach = new LoadCoach();
            IHeadCoach headCoach = getCoach.loadHeadCoach(teamId);
            team.setHeadCoach(headCoach);
            ILoadTeamPlayer load = new LoadTeamPlayer();
            ArrayList<IPlayers> playerList = load.loadTeamPlayer(teamId);
            team.setPlayers(playerList);
            teamList.add(team);
        }
        return teamList;
    }
}

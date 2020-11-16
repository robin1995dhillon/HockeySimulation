package dhl.persistence.database2;

import dhl.leagueModel.teams.ITeam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ITeamDB {
    int createTeam(String teamName, String managerName, boolean is_user) throws IOException, SQLException;
    boolean checkTeam(String teamName) throws IOException, SQLException;
    List<ITeam> getAllTeamInDivision(int divisionId) throws IOException, SQLException;
    int getTeamIdByTeamName(String teamName) throws IOException, SQLException;
    void updateTeam();
}

package dhl.persistence.database2;

import dhl.leagueModel.league.ILeague;

import java.io.IOException;
import java.sql.SQLException;

public interface ILeagueDB {
    int createLeague(String leagueName) throws SQLException, IOException;
    boolean checkLeague(String leagueName) throws SQLException, IOException;
    ILeague getLeague(int leagueId) throws SQLException, IOException;
    void updateLeague();
}

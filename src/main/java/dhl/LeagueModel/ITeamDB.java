package dhl.LeagueModel;

import dhl.MockLeague2;

import java.sql.SQLException;

public interface ITeamDB {
    public void loadTeamWithLoss(ITeam2 team) throws SQLException;
}

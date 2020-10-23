package dhl.LeagueModel;

import java.sql.SQLException;

public interface ITeamDB {
    public void loadTeamWithLoss(ITeam2 team) throws SQLException;
}

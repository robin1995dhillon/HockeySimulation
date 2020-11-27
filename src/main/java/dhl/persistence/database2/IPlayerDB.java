package dhl.persistence.database2;

import dhl.leagueModel.IPlayers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IPlayerDB {
    void createPlayer(IPlayers players, int teamId) throws IOException, SQLException;
    List<IPlayers> getTeamPlayer(int teamId) throws IOException, SQLException;
    void updatePlayer();
}

package dhl.loading;

import dhl.leagueModel.players.IPlayers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadTeamPlayer {
    ArrayList<IPlayers> loadTeamPlayer(int teamId) throws IOException, SQLException;
}

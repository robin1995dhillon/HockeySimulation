package dhl.loading;

import dhl.database.GetTeamPlayer;
import dhl.database.IGetStoredProcedure;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadTeamPlayer implements ILoadTeamPlayer{
    @Override
    public ArrayList<IPlayers> loadTeamPlayer(int teamId) throws IOException, SQLException {
        IGetStoredProcedure getPlayer = new GetTeamPlayer(teamId);
        ResultSet rsPlayer = getPlayer.executeProcedure();
        ArrayList<IPlayers> playerList = new ArrayList<>();
        while(rsPlayer.next()){
            IPlayers player = new Players();
            player.setPlayerName(rsPlayer.getString("name"));
            player.setPosition(rsPlayer.getString("position"));
            player.setCaptain(rsPlayer.getBoolean("captain"));
            player.setAge(rsPlayer.getInt("age"));
            player.setSkating(rsPlayer.getInt("skating"));
            player.setShooting(rsPlayer.getInt("shooting"));
            player.setChecking(rsPlayer.getInt("checking"));
            player.setSaving(rsPlayer.getInt("saving"));
            player.setInjured(rsPlayer.getBoolean("injured"));
            player.setRetired(rsPlayer.getBoolean("retired"));
            player.setInjuredDays(rsPlayer.getInt("injury_days"));
            playerList.add(player);
        }
        return playerList;
    }
}

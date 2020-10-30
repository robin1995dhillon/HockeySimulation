package dhl.LeagueModel.players;

import dhl.Database.CreatePlayer;
import dhl.Database.ICreateStoredProcedure;
import dhl.StoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class PlayersPersistence {

    public boolean savePlayerToDB(String playerName, String position, boolean [] booleanAttribute, int age, int [] playerAttributes, int team_id, int injuryDays) {
        boolean captain = booleanAttribute[0];
        boolean isRetired = booleanAttribute[1];
        boolean isInjured = booleanAttribute[2];
        int skating = playerAttributes[0];
        int shooting = playerAttributes[0];
        int checking = playerAttributes[0];
        int saving = playerAttributes[0];
        ICreateStoredProcedure SP = new CreatePlayer(playerName,position,captain,age,skating,shooting,checking,saving,team_id,isRetired,isInjured,injuryDays);
        try {
            SP.executeProcedure();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}

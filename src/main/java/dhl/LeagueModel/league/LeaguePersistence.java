package dhl.LeagueModel.league;

import dhl.Database.CreateLeague;
import dhl.Database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class LeaguePersistence implements ILeaguePersistence {

    @Override
    public JSONObject saveLeagueToDB(String leagueName) {
        JSONObject return_obj = new JSONObject();
        System.out.println("entering stored procedure");
        ICreateStoredProcedure SP = new CreateLeague(leagueName);
        if(leagueName.isEmpty()) {
            return_obj.put("Status", false);
            return_obj.put("id", null);
        } else {
            try {
                SP.executeProcedure();
                int league_id = SP.getInsertedId();
                return_obj.put("Status", true);
                return_obj.put("id", league_id);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                return_obj.put("Status", false);
                return_obj.put("id", null);
            }
        }
        return return_obj;
    }
}

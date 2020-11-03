package dhl.persistence.saving;

import dhl.persistence.database.CreateLeague;
import dhl.persistence.database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class LeaguePersistence implements ILeaguePersistence {

    @Override
    public JSONObject saveLeagueToDB(String leagueName) {
        JSONObject return_obj = new JSONObject();
        ICreateStoredProcedure SP = new CreateLeague(leagueName);
        if (leagueName.isEmpty()) {
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

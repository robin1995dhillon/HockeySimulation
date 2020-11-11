package dhl.persistence.saving;

import dhl.persistence.database.CreateConference;
import dhl.persistence.database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class ConferencePersistence implements IConferencePersistence {

    @Override
    public JSONObject saveConferenceToDB(String conferenceName) {
        JSONObject return_obj = new JSONObject();
        ICreateStoredProcedure SP = new CreateConference(conferenceName);
        if (conferenceName.isEmpty()) {
            return_obj.put("Status", false);
            return_obj.put("id", null);
        } else {
            try {
                SP.executeProcedure();
                int conference_id = SP.getInsertedId();
                return_obj.put("Status", true);
                return_obj.put("id", conference_id);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                return_obj.put("Status", false);
                return_obj.put("id", null);
            }
        }
        return return_obj;
    }
}

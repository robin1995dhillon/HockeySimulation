package dhl.leagueModel.freeAgents;

import dhl.database.CreateFreeAgent;
import dhl.database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class FreeAgentsPersistence implements IFreeAgentsPersistence {

    @Override
    public JSONObject saveFreeAgentsToDB(String name, String position, int age, int[] freeAgentAttributes, int leagueID) {
        JSONObject return_obj = new JSONObject();
        int skating = freeAgentAttributes[0];
        int shooting = freeAgentAttributes[1];
        int checking = freeAgentAttributes[2];
        int saving = freeAgentAttributes[3];
        ICreateStoredProcedure SP = new CreateFreeAgent(name, position, age,skating,shooting,checking,saving,leagueID);
        try {
            SP.executeProcedure();
            int division_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", division_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);

        }
        return return_obj;
    }
}

package dhl.LeagueModel.headCoach;

import dhl.Database.CreateCoach;
import dhl.Database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class HeadCoachPersistence implements IHeadCoachPersistence {

    @Override
    public JSONObject saveHeadCoachToDB(String headCoachName, int[] headCoachAttributes, int teamId) {
        JSONObject return_obj = new JSONObject();
        int skating = headCoachAttributes[0];
        int shooting = headCoachAttributes[1];
        int checking = headCoachAttributes[2];
        int saving = headCoachAttributes[3];
        ICreateStoredProcedure SP = new CreateCoach(headCoachName, skating,shooting,checking,saving,teamId);
        try {
            SP.executeProcedure();
            int headCoach_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", headCoach_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);

        }

        return return_obj;
    }
}

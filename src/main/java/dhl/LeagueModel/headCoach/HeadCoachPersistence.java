package dhl.LeagueModel.headCoach;

import dhl.Database.CreateCoach;
import dhl.Database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class HeadCoachPersistence implements IHeadCoachPersistence {

    @Override
    public JSONObject saveHeadCoachToDB(String headCoachName, double[] headCoachAttributes, int teamId) {
        JSONObject return_obj = new JSONObject();
        double skating = headCoachAttributes[0];
        double shooting = headCoachAttributes[1];
        double checking = headCoachAttributes[2];
        double saving = headCoachAttributes[3];
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

package dhl.leagueModel.teams;

import dhl.database.CreateTeam;
import dhl.database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class TeamPersistence implements ITeamPersistence {

    @Override
    public JSONObject saveTeamToDB(String name, String managerName, String coachName) {
        JSONObject return_obj = new JSONObject();
        ICreateStoredProcedure SP = new CreateTeam(name, managerName, coachName);
        try {
            SP.executeProcedure();
            int team_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", team_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);
        }
        return return_obj;
    }
}

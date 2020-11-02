package dhl.persistence.saving;

import org.json.simple.JSONObject;

public interface ITeamPersistence {
    JSONObject saveTeamToDB(String name, String ManagerName, String CoachName, boolean is_user);
}

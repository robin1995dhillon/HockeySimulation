package dhl.LeagueModel.teams;

import org.json.simple.JSONObject;

public interface ITeamPersistence {
    JSONObject saveTeamToDB(String name, String ManagerName, String CoachName);
}

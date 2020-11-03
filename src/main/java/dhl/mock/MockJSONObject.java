package dhl.mock;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MockJSONObject {

    public static JSONObject createMock() {
        JSONObject league_object = new JSONObject();
        league_object.put("leagueName", "Dalhousie Hockey");
        JSONArray conf_array = new JSONArray();

        JSONObject conference_object = new JSONObject();
        conference_object.put("conferenceName", "Eastern Conference");
        JSONArray division_array = new JSONArray();

        JSONObject division_object = new JSONObject();
        division_object.put("divisionName", "Atlantic");
        JSONArray team_array = new JSONArray();

        JSONObject team_object = new JSONObject();
        team_object.put("teamName", "Boston");
        team_object.put("generalManager", "Mister X");
        team_object.put("headCoach", "Smith");

        JSONArray player_array = new JSONArray();

        JSONObject player_object = new JSONObject();
        player_object.put("playerName", "playerOne");
        player_object.put("position", "forward");
        player_object.put("captain", true);

        player_array.add(player_object);
        team_object.put("players", player_array);
        team_array.add(team_object);
        division_object.put("teams", team_array);
        division_array.add(division_object);
        conference_object.put("divisions", division_array);
        conf_array.add(conference_object);
        league_object.put("conferences", conf_array);

        JSONObject return_object = new JSONObject();
        return_object.put("league", league_object);
        return_object.put("conference", conference_object);
        return_object.put("division_arr", division_array);
        return_object.put("division", division_object);
        return_object.put("team", team_object);
        return_object.put("player", player_object);
        return return_object;
    }
}


package dhl.leagueModel.conference;

import org.json.simple.JSONObject;

public interface IConferencePersistence {
    JSONObject saveConferenceToDB(String conferenceName);
}

package dhl.leagueModel.league;

import org.json.simple.JSONObject;

public interface ILeaguePersistence {
    JSONObject saveLeagueToDB(String leagueName);
}

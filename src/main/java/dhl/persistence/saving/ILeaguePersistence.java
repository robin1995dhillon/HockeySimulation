package dhl.persistence.saving;

import org.json.simple.JSONObject;

public interface ILeaguePersistence {
    JSONObject saveLeagueToDB(String leagueName);
}

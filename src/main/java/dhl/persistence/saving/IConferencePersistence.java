package dhl.persistence.saving;

import org.json.simple.JSONObject;

public interface IConferencePersistence {
    JSONObject saveConferenceToDB(String conferenceName);
}

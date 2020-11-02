package dhl.persistence.saving;

import org.json.simple.JSONObject;

public interface IHeadCoachPersistence {
    JSONObject saveHeadCoachToDB(String headCoachName, double[] headCoachAttributes, int teamId);
}

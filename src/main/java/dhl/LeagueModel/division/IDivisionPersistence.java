package dhl.LeagueModel.division;

import org.json.simple.JSONObject;

public interface IDivisionPersistence {
    JSONObject saveDivisionToDB(String divisionName);
}

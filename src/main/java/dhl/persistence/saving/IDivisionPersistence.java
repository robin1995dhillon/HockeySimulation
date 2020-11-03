package dhl.persistence.saving;

import org.json.simple.JSONObject;

public interface IDivisionPersistence {
    JSONObject saveDivisionToDB(String divisionName);
}

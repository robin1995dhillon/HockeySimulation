package dhl.persistence.saving;

import dhl.persistence.database.CreateDivision;
import dhl.persistence.database.ICreateStoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class DivisionPersistence implements IDivisionPersistence {

    @Override
    public JSONObject saveDivisionToDB(String divisionName) {
        JSONObject return_obj = new JSONObject();
        ICreateStoredProcedure SP = new CreateDivision(divisionName);
        if (divisionName.isEmpty()) {
            return_obj.put("Status", false);
            return_obj.put("id", null);
        } else {
            try {
                SP.executeProcedure();
                int division_id = SP.getInsertedId();
                return_obj.put("Status", true);
                return_obj.put("id", division_id);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                return_obj.put("Status", false);
                return_obj.put("id", null);

            }
        }
        return return_obj;
    }
}


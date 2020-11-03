package dhl.persistence.saving;

import dhl.persistence.database.CreateFreeManager;
import dhl.persistence.database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class FreeManagerPersistence implements IFreeManagerPersistence {

    @Override
    public boolean saveFreeManagerToDB(String managerName, int leagueID) {

        ICreateStoredProcedure createStoredProcedure = new CreateFreeManager(managerName, leagueID);
        try {
            createStoredProcedure.executeProcedure();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

package dhl.persistence.saving;

import dhl.persistence.database.CreateFreeCoach;
import dhl.persistence.database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class FreeCoachPersistence implements IFreeCoachPersistence {

    @Override
    public boolean saveFreeCoachToDB(String coachName, double[] coachAttributes, int leagueID) {
        double skating = coachAttributes[0];
        double shooting = coachAttributes[1];
        double checking = coachAttributes[2];
        double saving = coachAttributes[3];

        ICreateStoredProcedure createStoredProcedure = new CreateFreeCoach(coachName, skating, shooting, checking, saving, leagueID);
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

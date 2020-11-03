package dhl.persistence.saving;

import dhl.persistence.database.CreateDHLTable;
import dhl.persistence.database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class DHLPersistence implements IDHLPersistence {

    @Override
    public void saveDHLTable(int leagueID, int conferenceID, int divisionID, int teamID) {

        ICreateStoredProcedure SP = new CreateDHLTable(leagueID, conferenceID, divisionID, teamID);
        try {
            SP.executeProcedure();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

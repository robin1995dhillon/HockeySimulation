package dhl.LeagueModel.teams;

import dhl.Database.CreateDHLTable;
import dhl.Database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class DHLPersistence implements IDHLPersistence {

    @Override
    public void saveDHLTable(int leagueID, int conferenceID, int divisionID, int teamID) {

        ICreateStoredProcedure SP = new CreateDHLTable(leagueID,conferenceID,divisionID,teamID);
        try {
            SP.executeProcedure();
            int dhl_id = SP.getInsertedId();
//            return_obj.put("Status", true);
//            return_obj.put("id", team_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
//            return_obj.put("Status", false);
//            return_obj.put("id", null);
        }
    }
}

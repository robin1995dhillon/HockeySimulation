package dhl.persistence.database2;

import dhl.leagueModel.division.IDivision;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDivisionDB {
    int createDivision(String divisionName) throws IOException, SQLException;
    List<IDivision> getAllDivisionInConference(int conferenceId) throws IOException, SQLException;
    void updateDivision();
}

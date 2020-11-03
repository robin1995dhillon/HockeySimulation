package dhl.persistence.loading;

import dhl.leagueModel.division.IDivision;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadDivision {
    ArrayList<IDivision> loadDivision(int conferenceId) throws IOException, SQLException;
}

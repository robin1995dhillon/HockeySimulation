package dhl.persistence.loading;

import dhl.leagueModel.teams.ITeam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadTeam {
    ArrayList<ITeam> loadTeam(int divisionId) throws IOException, SQLException;
}

package dhl.persistence.loading;

import dhl.leagueModel.league.ILeague;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoadLeague {
    ILeague loadLeague(String teamName) throws IOException, SQLException;
}

package dhl.loading;

import dhl.leagueModel.conference.IConference;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadConference {
    ArrayList<IConference> loadConference(int leagueId) throws IOException, SQLException;
}

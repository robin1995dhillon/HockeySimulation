package dhl.persistence.database2;

import dhl.leagueModel.conference.IConference;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IConferenceDB {
    int createConference(String name) throws IOException, SQLException;
    List<IConference> getAllConferenceInLeague(int leagueId) throws IOException, SQLException;
    void updateConference();
}

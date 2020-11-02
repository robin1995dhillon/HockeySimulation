package dhl.persistence.loading;

import dhl.persistence.database.GetAllConferenceInLeague;
import dhl.persistence.database.IGetStoredProcedure;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadConference implements ILoadConference {
    @Override
    public ArrayList<IConference> loadConference(int leagueId) throws IOException, SQLException {
        ArrayList<IConference> conferenceList = new ArrayList<>();
        IGetStoredProcedure getConference = new GetAllConferenceInLeague(leagueId);
        ResultSet rsConference = getConference.executeProcedure();
        while (rsConference.next()){
            int conferenceId = rsConference.getInt("id");
            IConference conference = new Conference();
            conference.setConferenceName(rsConference.getString("name"));
            ILoadDivision load = new LoadDivision();
            ArrayList<IDivision> divisionList = load.loadDivision(conferenceId);
            conference.setDivisions(divisionList);
            conferenceList.add(conference);
        }
        return conferenceList;
    }
}

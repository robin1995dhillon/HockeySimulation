package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.conference.Conference;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as= Conference.class)
public interface IConference {
    public String getConferenceName();

    public void setConferenceName(String conferenceName);

    public ArrayList<IDivision> getDivisions();

    public void setDivisions(ArrayList<IDivision> divisions);

    void saveConference(List<Integer> leagueID);
}

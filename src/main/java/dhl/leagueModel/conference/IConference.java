package dhl.leagueModel.conference;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.division.IDivision;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = Conference.class)
public interface IConference {
    String getConferenceName();

    void setConferenceName(String conferenceName);

    ArrayList<IDivision> getDivisions();

    void setDivisions(ArrayList<IDivision> divisions);

    void saveConference(List<Integer> leagueID);
}

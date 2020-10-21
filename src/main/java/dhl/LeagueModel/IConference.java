package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonDeserialize(as=Conference.class)
public interface IConference {
    public String getConferenceName();

    public void setConferenceName(String conferenceName);

    public ArrayList<IDivision> getDivisions();

    public void setDivisions(ArrayList<IDivision> divisions);
}

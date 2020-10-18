package dhl.LeagueModel;

import java.util.ArrayList;

public interface IConference {
    public String getConferenceName();

    public void setConferenceName(String conferenceName);

    public ArrayList<IDivision> getDivisions();

    public void setDivisions(ArrayList<IDivision> divisions);
}

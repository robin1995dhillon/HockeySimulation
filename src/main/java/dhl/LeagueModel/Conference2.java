package dhl.LeagueModel;

import java.util.ArrayList;

public class Conference2 implements IConference{

    String conferenceName;
    ArrayList<IDivision> divisions;

    @Override
    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;

    }

    @Override
    public ArrayList<IDivision> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(ArrayList<IDivision> divisions) {
        this.divisions = divisions;

    }
}

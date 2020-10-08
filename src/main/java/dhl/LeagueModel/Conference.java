package dhl.LeagueModel;

import java.util.ArrayList;

public class Conference {

    String conferenceName;
    ArrayList<Division> divisions;


    public Conference(String conferenceName, ArrayList<Division> division) {
        this.conferenceName = conferenceName;
        this.divisions = division;
    }

    public Conference() {

    }

    public Conference(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public ArrayList<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(ArrayList<Division> divisions) {
        this.divisions = divisions;
    }

}

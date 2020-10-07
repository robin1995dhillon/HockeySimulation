package dhl.LeagueModel;

import java.util.ArrayList;

public class Conference {

    String ConferenceName = "";
    ArrayList<Division> division = new ArrayList<>();

    public Conference(String conferenceName, ArrayList<Division> division) {
        ConferenceName = conferenceName;
        this.division = division;
    }

    public Conference(String conferenceName) {
        ConferenceName = conferenceName;
    }

    public String getConferenceName() {
        return ConferenceName;
    }

    public void setConferenceName(String conferenceName) {
        ConferenceName = conferenceName;
    }

    public ArrayList<Division> getDivision() {
        return division;
    }

    public void setDivision(ArrayList<Division> division) {
        this.division = division;
    }

}

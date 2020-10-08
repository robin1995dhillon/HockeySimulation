package dhl.LeagueModel;

import java.util.ArrayList;

public class League {
    String leagueName;
    ArrayList<Conference> conferences;

    public League(String leagueName, ArrayList<Conference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League() {

    }

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public ArrayList<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(ArrayList<Conference> conferences) {
        this.conferences = conferences;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {

        this.leagueName = leagueName;
    }

    public boolean isLeagueNamePresent() {
        if(this.leagueName.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

}

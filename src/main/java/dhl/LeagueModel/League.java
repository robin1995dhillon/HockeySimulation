package dhl.LeagueModel;

import dhl.LeagueModel.Conference;

import java.util.ArrayList;

public class League {
    String LeagueName = "";
    ArrayList<Conference> conference = new ArrayList<>();


    public League(String leagueName, ArrayList<Conference> conference) {
        LeagueName = leagueName;
        this.conference = conference;

    }

    public League(String leagueName) {
        LeagueName = leagueName;
    }

    public ArrayList<Conference> getConference() {
        return conference;
    }

    public void setConference(ArrayList<Conference> conference) {
        this.conference = conference;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public void setLeagueName(String leagueName) {

        LeagueName = leagueName;
    }

    public boolean isLeagueNamePresent() {
        if(this.LeagueName.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

}

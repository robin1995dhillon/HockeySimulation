package dhl.LeagueModel;

import dhl.LeagueModel.Conference;

public class League {
    String LeagueName = "";
    Conference conference;
    public League(String LeagueName) {
        this.LeagueName = LeagueName;
        System.out.println(this.LeagueName);
//        conference = new dhl.LeagueModel.Conference("EasterConference");
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

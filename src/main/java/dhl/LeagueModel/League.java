package dhl.LeagueModel;

import java.util.ArrayList;

public class League {
    String leagueName;
    ArrayList<Conference> conferences;
    ArrayList<FreeAgents> freeAgents;

    public League(String leagueName, ArrayList<Conference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League(String leagueName, ArrayList<Conference> conferences, ArrayList<FreeAgents> freeAgents) {
        this.leagueName = leagueName;
        this.conferences = conferences;
        this.freeAgents = freeAgents;
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
    public ArrayList<FreeAgents> getfreeAgents() {
        return freeAgents;
    }

    public void setfreeAgents(ArrayList<FreeAgents> freeAgents) {
        this.freeAgents = freeAgents;
    }

    public static boolean isValid(League league) {
        if(league == null) {
            return false;
        }
        return true;
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

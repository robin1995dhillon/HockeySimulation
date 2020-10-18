package dhl.LeagueModel;

import java.util.ArrayList;

public class League2 implements ILeague{


    String leagueName;
    ArrayList<IConference> conferences;
    ArrayList<IFreeAgents> freeAgents;

    public League2() {
    }

    public League2(String leagueName, ArrayList<IConference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League2(String leagueName, ArrayList<IConference> conferences, ArrayList<IFreeAgents> freeAgents) {
        this.leagueName = leagueName;
        this.conferences = conferences;
        this.freeAgents = freeAgents;
    }
    public League2(String leagueName) {
        this.leagueName = leagueName;
    }


    @Override
    public ArrayList<IConference> getConferences() {
        return conferences;
    }

    @Override
    public void setConferences(ArrayList<IConference> conferences) {
        this.conferences = conferences;

    }

    @Override
    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;

    }

    @Override
    public ArrayList<IFreeAgents> getfreeAgents() {
        return freeAgents;
    }

    @Override
    public void setfreeAgents(ArrayList<IFreeAgents> freeAgents) {
        this.freeAgents = freeAgents;

    }

    public boolean isValid(ILeague league) {
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

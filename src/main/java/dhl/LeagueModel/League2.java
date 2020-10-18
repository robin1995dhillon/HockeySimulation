package dhl.LeagueModel;

import java.util.ArrayList;

public class League2 implements ILeague{


    String leagueName;
    ArrayList<IConference> conferences;
    ArrayList<IFreeAgents> freeAgents;



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
}

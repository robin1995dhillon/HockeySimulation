package dhl.LeagueModel;

import java.util.ArrayList;

public class League implements ILeague{

    IConference iconference;
    IFreeAgents iFreeAgents;
    IHeadCoach iheadCoach;

    String leagueName;
    ArrayList<IConference> conferences;
    ArrayList<IFreeAgents> freeAgents;
    ArrayList<IHeadCoach> coaches;
    ArrayList<String> generalManagers;

    public League() {
    iconference = new Conference();
    iFreeAgents = new FreeAgents();
    iheadCoach = new HeadCoach();
    }

    public League(String leagueName, ArrayList<IConference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League(String leagueName, ArrayList<IConference> conferences, ArrayList<IFreeAgents> freeAgents) {
        this.leagueName = leagueName;
        this.conferences = conferences;
        this.freeAgents = freeAgents;
    }
    public League(String leagueName) {
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

    public ArrayList<IHeadCoach> getCoaches() {
        return coaches;
    }

    public void setCoaches(ArrayList<IHeadCoach> coaches) {
        this.coaches = coaches;
    }

    public ArrayList<String> getGeneralManagers() {
        return generalManagers;
    }

    public void setGeneralManagers(ArrayList<String> generalManagers) {
        this.generalManagers = generalManagers;
    }
}

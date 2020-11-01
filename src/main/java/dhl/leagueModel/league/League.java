package dhl.leagueModel.league;

import dhl.leagueModel.IConference;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.gamePlayConfig.GamePlayConfig;
import dhl.gamePlayConfig.IGamePlayConfig;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class League implements ILeague {

    IConference iconference;
    IFreeAgents iFreeAgents;
    IHeadCoach iheadCoach;
    IGamePlayConfig iGamePlayConfig;
    String leagueName;

    ArrayList<IConference> conferences;
    ArrayList<IFreeAgents> freeAgents;
    ArrayList<IHeadCoach> coaches;
    ArrayList<String> generalManagers;


    public League() {
    iconference = new Conference();
    iFreeAgents = new FreeAgents();
    iheadCoach = new HeadCoach();
    iGamePlayConfig = new GamePlayConfig();
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
    public ArrayList<IFreeAgents> getFreeAgents() {
        return freeAgents;
    }

    @Override
    public ArrayList<String> getGeneralManagers() {
        return generalManagers;
    }

    @Override
    public ArrayList<IHeadCoach> getCoaches() {
        return coaches;
    }

    @Override
    public void removeManagerFromList(List<String> managerList, String managerName) {
        for(int i = 0; i < managerList.size(); i++){
            if (managerList.get(i).equals(managerName)) {
                managerList.remove(i);
            }
        }
    }

    @Override
    public void setFreeAgents(ArrayList<IFreeAgents> freeAgents) {
        this.freeAgents = freeAgents;

    }

    @Override
    public void setHeadCoach(ArrayList<IHeadCoach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public void setGeneralManager(ArrayList<String> generalManagers) {
        this.generalManagers = generalManagers;
    }

    @Override
    public IGamePlayConfig getGameplayConfig() {
        return iGamePlayConfig;
    }

    @Override
    public void setGameplayConfig(IGamePlayConfig gameplayConfig) {
        this.iGamePlayConfig = gameplayConfig;
    }

    public boolean isValid(ILeague league) {
        return league != null;
    }

    public boolean isLeagueNamePresent() {
        return !this.leagueName.isEmpty();
    }

    @Override
    public void storeLeague() {
        String leagueName = this.leagueName;

        ILeaguePersistence leaguePersistence = new LeaguePersistence();
        JSONObject resultObject = leaguePersistence.saveLeagueToDB(leagueName);

        List<IConference> conferenceArray = this.getConferences();
        List<IFreeAgents> freeAgentsArray = this.getFreeAgents();

        List<Integer> ID = new ArrayList<>();
        int leagueID = (int) resultObject.get("id");
        ID.add(0,leagueID);

        for(IConference c: conferenceArray) {
            c.saveConference(ID);
        }
        System.out.println("Saving Free Agents");
        for(IFreeAgents freeAgents: freeAgentsArray) {
            freeAgents.saveFreeAgent(leagueID);
        }
    }



}

package dhl.leagueModel.league;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.Configurables;
import dhl.persistence.saving.FreeManagerPersistence;
import dhl.persistence.saving.IFreeManagerPersistence;
import dhl.persistence.saving.ILeaguePersistence;
import dhl.persistence.saving.LeaguePersistence;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class League implements ILeague {

    private IConference iconference;
    private IFreeAgents iFreeAgents;
    private IHeadCoach iheadCoach;
    private IGamePlayConfig iGamePlayConfig;
    private String leagueName;

    private ArrayList<IConference> conferences;
    private ArrayList<IFreeAgents> freeAgents;
    private ArrayList<IHeadCoach> coaches;
    private ArrayList<String> generalManagers;

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
        for (int i = 0; i < managerList.size(); i++) {
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
    public void saveManager(String name, int leagueID) {
        IFreeManagerPersistence freeManagerPersistence = new FreeManagerPersistence();
        freeManagerPersistence.saveFreeManagerToDB(name, leagueID);
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
        IGamePlayConfig gamePlayConfig = this.getGameplayConfig();
        List<IHeadCoach> headCoachArray = this.getCoaches();
        ArrayList<String> managerName = this.getGeneralManagers();

        List<Integer> ID = new ArrayList<>();
        int leagueID = (int) resultObject.get(Configurables.ID.getAction());
        ID.add(0, leagueID);
        for (IConference c : conferenceArray) {
            c.saveConference(ID);
        }
        for (IFreeAgents freeAgents : freeAgentsArray) {
            freeAgents.saveFreeAgent(leagueID);
        }
        gamePlayConfig.saveGamePlayConfigToDB(leagueID);
        for (IHeadCoach headCoach : headCoachArray) {
            headCoach.saveFreeCoach(leagueID);
        }
        for (String name : managerName) {
            this.saveManager(name, leagueID);
        }
    }


}

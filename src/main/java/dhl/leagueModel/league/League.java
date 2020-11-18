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
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class League implements ILeague {

    private IConference iconference;
    private IFreeAgents iFreeAgents;
    private IHeadCoach iheadCoach;
    private IGamePlayConfig iGamePlayConfig;
    private String leagueName;

    private List<IConference> conferences;
    private List<IFreeAgents> freeAgents;
    private List<IHeadCoach> coaches;
    private List<String> generalManagers;
    List<ITeamStanding> teamStandingList;
    List<ISchedulerSeason> gameSchedules;

    public League() {
        iconference = new Conference();
        iFreeAgents = new FreeAgents();
        iheadCoach = new HeadCoach();
        iGamePlayConfig = new GamePlayConfig();
    }

    public League(String leagueName, List<IConference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League(String leagueName, List<IConference> conferences, List<IFreeAgents> freeAgents) {
        this.leagueName = leagueName;
        this.conferences = conferences;
        this.freeAgents = freeAgents;
    }

    public League(String leagueName) {
        this.leagueName = leagueName;
    }


    @Override
    public List<IConference> getConferences() {
        return conferences;
    }

    @Override
    public void setConferences(List<IConference> conferences) {
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
    public List<IFreeAgents> getFreeAgents() {
        return freeAgents;
    }

    @Override
    public List<String> getGeneralManagers() {
        return generalManagers;
    }

    @Override
    public List<IHeadCoach> getCoaches() {
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
    public void setFreeAgents(List<IFreeAgents> freeAgents) {
        this.freeAgents = freeAgents;

    }

    @Override
    public void setHeadCoach(List<IHeadCoach> coaches) {
        this.coaches = coaches;
    }

    @Override
    public void setGeneralManager(List<String> generalManagers) {
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
    public void setSchedules(List<ISchedulerSeason> gameSchedules) {
    this.gameSchedules = gameSchedules;
    }

    @Override
    public List<ISchedulerSeason> getGameSchedules() {
        return gameSchedules;
    }

    public List<ITeamStanding> getTeamStandingList() {
        return teamStandingList;
    }

    public void setTeamStandingList(List<ITeamStanding> teamStandingList) {
        this.teamStandingList = teamStandingList;

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
        List<String> managerName = this.getGeneralManagers();

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

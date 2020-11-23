package dhl.leagueModel.league;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.persistence.saving.FreeManagerPersistence;
import dhl.persistence.saving.IFreeManagerPersistence;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;

import java.util.List;

public class League implements ILeague {


    private String leagueName;
    private String startDateOfSeason;
    private int numberSeason;
    private int totalSeasons;
    private String lastDateOfSeason;

    private List<IConference> conferences;
    private List<IFreeAgents> freeAgents;
    private List<IHeadCoach> coaches;
    private List<IGeneralManager> generalManagers;
    private IGamePlayConfig gamePlayConfig;
    private List<ITeamStanding> teamStandingList;
    private List<ISchedulerSeason> gameSchedules;

    public League() {

    }

    public League(String leagueName, List<IConference> conferences) {
        this.leagueName = leagueName;
        this.conferences = conferences;
    }

    public League(String leagueName, List<IConference> conferences, List<IFreeAgents> freeAgents, IGamePlayConfig gamePlayConfig) {
        this.leagueName = leagueName;
        this.conferences = conferences;
        this.freeAgents = freeAgents;
        this.gamePlayConfig = gamePlayConfig;
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
    public void saveManager(String name, int leagueID) {
        IFreeManagerPersistence freeManagerPersistence = new FreeManagerPersistence();
        freeManagerPersistence.saveFreeManagerToDB(name, leagueID);
    }

    @Override
    public IGamePlayConfig getGameplayConfig() {
        return gamePlayConfig;
    }

    @Override
    public void setGameplayConfig(IGamePlayConfig gameplayConfig) {
        this.gamePlayConfig = gameplayConfig;
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
    public List<IGeneralManager> getGeneralManagers() {
        return generalManagers;
    }

    public void setGeneralManagers(List<IGeneralManager> generalManagers) {
        this.generalManagers = generalManagers;
    }

//    @Override
//    public void storeLeague() {
//        String leagueName = this.leagueName;
//        ILeaguePersistence leaguePersistence = new LeaguePersistence();
//        JSONObject resultObject = leaguePersistence.saveLeagueToDB(leagueName);
//        List<IConference> conferenceArray = this.getConferences();
//        List<IFreeAgents> freeAgentsArray = this.getFreeAgents();
//        IGamePlayConfig gamePlayConfig = this.getGameplayConfig();
//        List<IHeadCoach> headCoachArray = this.getCoaches();
//        IGeneralManager = this.getGeneralManagers();
//
//        List<Integer> ID = new ArrayList<>();
//        int leagueID = (int) resultObject.get(Configurables.ID.getAction());
//        ID.add(0, leagueID);
//        for (IConference c : conferenceArray) {
//            c.saveConference(ID);
//        }
//        for (IFreeAgents freeAgents : freeAgentsArray) {
//            freeAgents.saveFreeAgent(leagueID);
//        }
//        gamePlayConfig.saveGamePlayConfigToDB(leagueID);
//        for (IHeadCoach headCoach : headCoachArray) {
//            headCoach.saveFreeCoach(leagueID);
//        }
//        for (String name : managerName) {
//            this.saveManager(name, leagueID);
//        }
//    }

@Override
public String getDate() {
    return startDateOfSeason;
}

    @Override
    public void setDate(String startDateOfSeason) {
        this.startDateOfSeason = startDateOfSeason;
    }

    @Override
    public String getLastDateOfSeason() {
        return lastDateOfSeason;
    }

    @Override
    public void setLastDateOfSeason(String lastDateOfSeason) {
        this.lastDateOfSeason = lastDateOfSeason;

    }

    @Override
    public int getSeason() {
        return numberSeason;
    }

    @Override
    public void setSeason(int season) {
        this.numberSeason = season;

    }

    @Override
    public int getTotalSeasons() {
        return totalSeasons;
    }

    @Override
    public void setTotalSeasons(int numberOfSeasons) {
        this.totalSeasons = numberOfSeasons;

    }

}

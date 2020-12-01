package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.stateMachine.ISchedulerSeason;
import dhl.stateMachine.ITeamStanding;

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
    private String playerDraftDate;

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
    public void setFreeAgents(List<IFreeAgents> freeAgents) {
        this.freeAgents = freeAgents;
    }

    @Override
    public void setHeadCoach(List<IHeadCoach> coaches) {
        this.coaches = coaches;
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

    @Override
    public String getPlayerDraftDate() {
        return playerDraftDate;
    }

    @Override
    public void setPlayerDraftDate(String playerDraftDate) {
        this.playerDraftDate = playerDraftDate;
    }

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

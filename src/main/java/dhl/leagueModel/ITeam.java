package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = Teams.class)
public interface ITeam {

    List<IPlayers> getPlayers();

    void setPlayers(List<IPlayers> players);

    String getTeamName();

    void setTeamName(String teamName);

    IGeneralManager getGeneralManager();

    void setGeneralManager(IGeneralManager generalManager);

    IHeadCoach getHeadCoach();

    void setHeadCoach(IHeadCoach headCoach);

    String getTeamType();

    void setTeamType(String teamType);

    void setTeamStrength(double teamStrength);

    double getTeamStrength();

    int getLossPoints();

    void setLossPoints(int teamType);

    List<IPlayers> getActiveRoster();

    void setActiveRoster(List<IPlayers> activeRoster);

    List<IPlayers> getInActiveRoster();

    void setInActiveRoster(List<IPlayers> inActiveRoster);

    double calculateTeamStrength(ITeam team);

    //    Might be used in the next milestone. That's why we havent removed it.
    boolean getIsUser();

    void setIsUser(boolean isUser);

    void setGoals(double goals);
    double getGoals();
    void setSaves(double saves);
    double getSaves();
    void setShots(double shots);
    double getShots();
    void setPenalties(double penalties);
    double getPenalties();

    ILeague createTeam(ILeague league, String[] locationAttributes, IHeadCoach headCoach, List<IPlayers> playerList, IGeneralManager generalManager);

    void createRoster() throws Exception;

    void swapForPlayerInInactiveRoster(IPlayers players) throws Exception;

    void addPlayerToTeam(IPlayers players);

    void checkForInactiveRosterPlayerInjuryRecovery();

    void dropTeamToThirty();
}

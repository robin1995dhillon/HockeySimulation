package dhl.leagueModel.teams;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;

import java.util.ArrayList;
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

    double calculateTeamStrength(ITeam team);

    //    Might be used in the next milestone. That's why we havent removed it.
    boolean getIsUser();

    void setIsUser(boolean isUser);

    ILeague createTeam(ILeague league, String[] locationAttributes, IHeadCoach headCoach, List<IPlayers> playerList, IGeneralManager generalManager);
    ILeague createTeam(ILeague league, String[] locationAttributes, IHeadCoach headCoach, List<IPlayers> playerList);

    void saveTeams(List<Integer> id);
}

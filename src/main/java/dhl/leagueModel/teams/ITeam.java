package dhl.leagueModel.teams;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import java.util.List;

@JsonDeserialize(as= Teams.class)
public interface ITeam {

    List<IPlayers> getPlayers();
    void setPlayers(List<IPlayers> players);
    String getTeamName();
    void setTeamName(String teamName);
    String getGeneralManager();
    void setGeneralManager(String generalManager);
    IHeadCoach getHeadCoach();
    void setHeadCoach(IHeadCoach headCoach);
    String getTeamType();
    void setTeamType(String teamType);
    void setTeamStrength(double teamStrength);
    double getTeamStrength();
    int getLossPoints();
    void setLossPoints(int teamType);
    double calculateTeamStrength(ITeam team);
    boolean getIsUser();
    void setIsUser(boolean isUser);

    void saveTeams(List<Integer> id);
}

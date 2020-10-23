package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.teams.Teams;

import java.util.ArrayList;

@JsonDeserialize(as= Teams.class)
public interface ITeam2 {
    public ArrayList<IPlayers> getPlayers();


    public void setPlayers(ArrayList<IPlayers> players);

    public String getTeamName();

    public void setTeamName(String teamName);

    public String getGeneralManager();

    public void setGeneralManager(String generalManager);

    public IHeadCoach getHeadCoach();

    public void setHeadCoach(IHeadCoach headCoach);

    public String getTeamType();
    public void setTeamType(String teamType);

    public int getLossPoints();
    public void setLossPoints(int teamType);

}

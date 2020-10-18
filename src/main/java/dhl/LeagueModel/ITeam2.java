package dhl.LeagueModel;

import java.util.ArrayList;

public interface ITeam2 {
    public ArrayList<IPlayers2> getPlayers();

    public void setPlayers(ArrayList<IPlayers2> players);

    public String getTeamName();

    public void setTeamName(String teamName);

    public String getGeneralManager();

    public void setGeneralManager(String generalManager);

    public HeadCoach getHeadCoach();

    public void setHeadCoach(HeadCoach headCoach);

}

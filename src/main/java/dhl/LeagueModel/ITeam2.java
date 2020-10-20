package dhl.LeagueModel;

import java.util.ArrayList;

public interface ITeam2 {
    public ArrayList<IPlayers2> getPlayers();

    public void setPlayers(ArrayList<IPlayers2> players);

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

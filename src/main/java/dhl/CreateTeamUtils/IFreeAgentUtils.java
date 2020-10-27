package dhl.CreateTeamUtils;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;

import java.util.ArrayList;

public interface IFreeAgentUtils {
    public void displayFreeAgent(ArrayList<IFreeAgents> freeAgentList);
    public IFreeAgents getPlayer(ArrayList<IFreeAgents> freeAgentList, String freeAgentName);
    public void removeFreeAgent(ArrayList<IFreeAgents> freeAgentList, String freeAgentName);
    public boolean checkPosition(ArrayList<IFreeAgents> freeAgentList, String playerName, String position);
}

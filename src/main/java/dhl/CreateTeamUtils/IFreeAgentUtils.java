package dhl.CreateTeamUtils;

import dhl.LeagueModel.IFreeAgents;

import java.util.List;

public interface IFreeAgentUtils {
    void displayFreeAgent(List<IFreeAgents> freeAgentList);
    IFreeAgents getFreeAgentFromList(List<IFreeAgents> freeAgentList, String freeAgentName);
    void removeFreeAgent(List<IFreeAgents> freeAgentList, String freeAgentName);
    boolean checkPosition(List<IFreeAgents> freeAgentList, String playerName, String position);
}

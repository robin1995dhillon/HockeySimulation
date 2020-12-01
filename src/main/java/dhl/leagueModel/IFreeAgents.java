package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = FreeAgents.class)
public interface IFreeAgents extends IAllPlayers {
    IFreeAgents getFreeAgentFromList(List<IFreeAgents> freeAgentList, String freeAgentName);

    List<IFreeAgents> removeFreeAgents(List<IFreeAgents> freeAgentsList);
}

package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.players.Players;

import java.util.List;

@JsonDeserialize(as = FreeAgents2.class)
public interface IFreeAgents2 extends IAllPlayers {
    IAllPlayers getFreeAgentFromList(List<IAllPlayers> freeAgentList, String freeAgentName);
}

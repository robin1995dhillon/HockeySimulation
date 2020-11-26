package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.freeAgents.IFreeAgents;

import java.util.List;

@JsonDeserialize(as = FreeAgents2.class)
public class FreeAgents2 extends AllPlayers implements IFreeAgents2 {

    private String type = "freeAgents";
    public FreeAgents2() {
        super();
    }

    @Override
    public IAllPlayers getFreeAgentFromList(List<IAllPlayers> freeAgentList, String freeAgentName) {
        for (IAllPlayers freeAgent : freeAgentList) {
            if (freeAgent.getPlayerName().equals(freeAgentName)) {
                return freeAgent;
            }
        }
        return null;
    }

}

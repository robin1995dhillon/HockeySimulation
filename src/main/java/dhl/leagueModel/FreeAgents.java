package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = FreeAgents.class)
public class FreeAgents extends AllPlayers implements IFreeAgents {

    public FreeAgents() {
        super();
    }

    @Override
    public IFreeAgents getFreeAgentFromList(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if (freeAgent.getPlayerName().equals(freeAgentName)) {
                return freeAgent;
            }
        }
        return null;
    }


    @Override
    public List<IFreeAgents> removeFreeAgents(List<IFreeAgents> freeAgentsList) {
        ArrayList<IFreeAgents> newFreeAgentList = new ArrayList<>();

        for(IFreeAgents freeAgents: freeAgentsList) {
            if(this.equals(freeAgents)) {
                continue;
            } else {
                newFreeAgentList.add(freeAgents);
            }
        }
        return newFreeAgentList;
    }

}

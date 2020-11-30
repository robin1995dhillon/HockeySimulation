package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
    public List<IFreeAgents> retireFreeAgents(List<IFreeAgents> freeAgentList) {
        for(int i=0;i<freeAgentList.size();i++) {
            if(this.isRetired()) {
                System.out.println("FreeAgent " + this.getPlayerName() + " has retired and been removed from freeAgent list.");
                freeAgentList.remove(this);
            }
        }
        return freeAgentList;
    }



}

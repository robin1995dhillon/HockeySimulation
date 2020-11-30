package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as = FreeAgents.class)
public class FreeAgents extends AllPlayers implements IFreeAgents {

    private static final Logger logger = LogManager.getLogger(FreeAgents.class);

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
                System.out.println("Inside Removing FreeAgents");
                continue;
            } else {
                newFreeAgentList.add(freeAgents);
            }
        }
        return newFreeAgentList;
    }

}

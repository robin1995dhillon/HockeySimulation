package dhl.Trade;

import dhl.LeagueModel.ITeam;

public class AddDropPlayers implements IAddDropPlayers{

    private FreeAgentList freeAgentLists;
    private FreeAgentListDrop freeAgentListsDrop;

    AddDropPlayers(){
        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
    public void addDropPlayers(ITeam team, int totalPlayers) {

        int playersToBeAdded;
        int playersToBeDropped;

        if(totalPlayers<20){
            playersToBeAdded = 20 - totalPlayers;

            freeAgentLists.aiAgentListAdd(team,playersToBeAdded);
        }
        else if(totalPlayers>20){

            playersToBeDropped = totalPlayers - 20;
            freeAgentListsDrop.agentListDrop(team,playersToBeDropped);
        }
    }
}

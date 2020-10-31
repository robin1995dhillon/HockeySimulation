package dhl.Trade;

import dhl.LeagueModel.ITeam2;

public class AddDropPlayers implements IAddDropPlayers{

    private FreeAgentList freeAgentLists;
    private FreeAgentListDrop freeAgentListsDrop;

    AddDropPlayers(){
        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
    public void addDropPlayers(ITeam2 team, int totalPlayers) {

        int playersToBeAdded = 0;
        int playersToBeDropped = 0;

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

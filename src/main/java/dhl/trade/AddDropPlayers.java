package dhl.trade;

import dhl.leagueModel.teams.ITeam;

public class AddDropPlayers implements IAddDropPlayers {

    private IFreeAgentListAdd freeAgentLists;
    private IFreeAgentListDrop freeAgentListsDrop;

    AddDropPlayers() {
        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
    public void addDropPlayers(ITeam team, int totalPlayers) {

        int playersToBeAdded;
        int playersToBeDropped;

        if (totalPlayers < 20) {
            playersToBeAdded = 20 - totalPlayers;

            freeAgentLists.aiAgentListAdd(team, playersToBeAdded);
        } else if (totalPlayers > 20) {

            playersToBeDropped = totalPlayers - 20;
            freeAgentListsDrop.agentListDrop(team, playersToBeDropped);
        }
    }
}

package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.leagueModel.teams.ITeam;

public class AddDropPlayers implements IAddDropPlayers {

    private IFreeAgentListAdd freeAgentLists;
    private IFreeAgentListDrop freeAgentListsDrop;

    public AddDropPlayers() {
        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
    public void addDropPlayers(ITeam team, int totalPlayers) {

        int playersToBeAdded;
        int playersToBeDropped;
        int totalNumberOfPlayers = Integer.parseInt(Configurables.TOTAL_PLAYERS.getAction());

        if (totalPlayers < totalNumberOfPlayers) {
            playersToBeAdded = totalNumberOfPlayers - totalPlayers;

            freeAgentLists.aiAgentListAdd(team, playersToBeAdded);
        } else if (totalPlayers > totalNumberOfPlayers) {

            playersToBeDropped = totalPlayers - totalNumberOfPlayers;
            freeAgentListsDrop.agentListDrop(team, playersToBeDropped);
        }
    }
}

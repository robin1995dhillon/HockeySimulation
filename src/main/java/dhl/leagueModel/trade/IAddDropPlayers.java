package dhl.leagueModel.trade;

import dhl.leagueModel.IAllPlayers;
import dhl.leagueModel.ITeam;

public interface IAddDropPlayers {

    void addDropPlayers(ITeam team, int totalPlayers);

    void dropToFreeAgents(ITeam team, int count, String position);

    void hireFreeAgents(ITeam team, int count, String position);

    IAllPlayers getAllPlayers();

    void setAllPlayers(IAllPlayers allPlayers);
}

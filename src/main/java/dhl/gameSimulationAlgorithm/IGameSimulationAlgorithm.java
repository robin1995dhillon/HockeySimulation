package dhl.gameSimulationAlgorithm;

import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IGameSimulationAlgorithm {
    List<IPlayers> getPlayerForShift(ITeam team);
    IPlayers shots(List<IPlayers> teamOnePlayers, List<IPlayers> teamTwoPlayers);
    IPlayers getGoalie(List<IPlayers> playerList);
    void saves(IPlayers goalie, IPlayers forward);
    double getShots(ITeam team);
    double getSaves(ITeam team);
    double getGoals(ITeam team);
    double getPenalties(ITeam team);
    void setPenaltyChance(double penaltyChance);
    void setShotChance(double shotChance);
    void setSaveChance(double saveChance);
    void setSaveCoefficientOne(double coefficient);
    void setSaveCoefficientTwo(double coefficient);
    void setShotCoefficientOne(double coefficient);
    void setShotCoefficientTwo(double coefficient);
}

package dhl.gameSimulationAlgorithm;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IGameSimulationAlgorithm {
    List<IPlayers> getPlayerForShift(ITeam team);
    IPlayers getPlayerWithLeastShift(List<IPlayers> playersList);
    IPlayers shots(List<IPlayers> teamOnePlayers, List<IPlayers> teamTwoPlayers);
    IPlayers getGoalie(List<IPlayers> playerList);
    IPlayers shotForward(List<IPlayers> forwardList);
    void penaltyDefence(List<IPlayers> defenseList);
    void saves(IPlayers goalie, IPlayers forward);
    void reset(ITeam team);
    double getShots(ITeam team);
    double getSaves(ITeam team);
    double getGoals(ITeam team);
    double getPenalties(ITeam team);
    void getTeamStatistic(ITeam team);
    void setPenaltyChance(double penaltyChance);
    void setShotChance(double shotChance);
    void setSaveChance(double saveChance);
    void setSaveCoefficientOne(double coefficient);
    void setSaveCoefficientTwo(double coefficient);
    void setShotCoefficientOne(double coefficient);
    void setShotCoefficientTwo(double coefficient);
}

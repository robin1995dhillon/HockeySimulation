package dhl.gameSimulationAlgorithm;

import dhl.leagueModel.teams.ITeam;

public interface IGameSimulationAlgorithm {
    void calculateStatistics(ITeam team);
    double getShots();
    double getSaves();
    double getGoals();
    double getPenalties();
    void setSaveCoefficientOne(double coefficient);
    void setSaveCoefficientTwo(double coefficient);
    void setShotCoefficientOne(double coefficient);
    void setShotCoefficientTwo(double coefficient);
}

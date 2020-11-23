package dhl.gameSimulationAlgorithm;


import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public class GameSimulationAlgorithm implements IGameSimulationAlgorithm{
    private double penaltyChance;
    private double saveChance;
    private double shotChance;
    private double goals;
    private double penalties;
    private double shots;
    private double saves;
    private double saveCoefficientOne;
    private double saveCoefficientTwo;
    private double shotCoefficientOne;
    private double shotCoefficientTwo;

    public GameSimulationAlgorithm(double penaltyChance, double shotChance, double saveChance){
        this.penaltyChance = penaltyChance;
        this.saveChance = saveChance;
        this.shotChance = shotChance;
    }

    public IPlayers shots(List<IPlayers> teamOnePlayers, List<IPlayers> teamTwoPlayers){
        double totalSkatingOne = 0;
        double totalSkatingTwo = 0;
        for(IPlayers player : teamOnePlayers){
            totalSkatingOne += player.getSkating();
        }
        for(IPlayers player : teamTwoPlayers){
            totalSkatingTwo += player.getSkating();
        }
        List<IPlayers> forwardList = teamOnePlayers.subList(0,3);
        List<IPlayers> defenseList = teamTwoPlayers.subList(3,5);
        shotChance += shotCoefficientOne * (totalSkatingOne - totalSkatingTwo) + shotCoefficientTwo;
        if(Math.random() < shotChance){
            return shotForward(forwardList);
        }
        else{
            if(Math.random() < penaltyChance){
                penaltyDefence(defenseList);
            }
        }
        return null;
    }

    public void saves(IPlayers goalie, IPlayers forward) {
        saveChance += saveCoefficientOne * (goalie.getSaving() - forward.getShooting()) + saveCoefficientTwo;
        if(Math.random() < saveChance){
            goalie.setSaves(goalie.getSaves() + 1);
        }
        else{
            forward.setGoals(forward.getGoals() + 1);
        }
    }

    public IPlayers shotForward(List<IPlayers> forwardList){
        IPlayers forwardOne = forwardList.get(0);
        IPlayers forwardTwo = forwardList.get(1);
        IPlayers forwardThree = forwardList.get(2);
        double random = Math.random();
        if(random < forwardOne.getShooting() / (double) (forwardOne.getShooting() + forwardTwo.getShooting() + forwardThree.getShooting())){
            forwardOne.setShots(forwardOne.getShots() + 1);
            return forwardOne;
        }
        else if(random >= (double) (forwardOne.getShooting() + forwardTwo.getShooting()) / (forwardOne.getShooting() + forwardTwo.getShooting() + forwardThree.getShooting())){
            forwardThree.setShots(forwardThree.getShots() + 1);
            return forwardThree;
        }
        else{
            forwardTwo.setShots(forwardTwo.getShots() + 1);
            return forwardTwo;
        }
    }

    public void penaltyDefence(List<IPlayers> defenseList){
        IPlayers defenseOne = defenseList.get(0);
        IPlayers defenseTwo = defenseList.get(1);
        double pointOne = defenseOne.getChecking();
        double pointTwo = defenseTwo.getChecking();
        if(Math.random() < pointOne / (pointOne + pointTwo)){
            defenseOne.setPenalties(defenseOne.getPenalties() + 1);
            //return defenseOne;
        }
        else{
            defenseTwo.setPenalties(defenseTwo.getPenalties() + 1);
            //return defenseTwo;
        }
    }

    @Override
    public void calculateStatistics(ITeam team) {
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList){
            this.shots += player.getShots();
            this.saves += player.getSaves();
            this.penalties += player.getPenalties();
            this.goals += player.getGoals();
            player.setShots(0);
            player.setSaves(0);
            player.setPenalties(0);
            player.setGoals(0);
        }
    }

    @Override
    public double getShots() {
        return this.shots;
    }

    @Override
    public double getSaves() {
        return this.saves;
    }

    @Override
    public double getGoals() {
        return this.goals;
    }

    @Override
    public double getPenalties() {
        return this.penalties;
    }

    @Override
    public void setSaveCoefficientOne(double coefficient) {
        this.saveCoefficientOne = coefficient;
    }

    @Override
    public void setSaveCoefficientTwo(double coefficient) {
        this.saveCoefficientTwo = coefficient;
    }

    @Override
    public void setShotCoefficientOne(double coefficient) {
        this.shotCoefficientOne = coefficient;
    }

    @Override
    public void setShotCoefficientTwo(double coefficient) {
        this.shotCoefficientTwo = coefficient;
    }
}

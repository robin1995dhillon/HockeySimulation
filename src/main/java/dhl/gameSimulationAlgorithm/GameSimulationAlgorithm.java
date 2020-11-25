package dhl.gameSimulationAlgorithm;


import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.ArrayList;
import java.util.List;

public class GameSimulationAlgorithm implements IGameSimulationAlgorithm{
    private double penaltyChance;
    private double saveChance;
    private double shotChance;
    private double saveCoefficientOne;
    private double saveCoefficientTwo;
    private double shotCoefficientOne;
    private double shotCoefficientTwo;

    public GameSimulationAlgorithm(double penaltyChance, double shotChance, double saveChance){
        this.penaltyChance = penaltyChance;
        this.saveChance = saveChance;
        this.shotChance = shotChance;
    }

    public GameSimulationAlgorithm() {

    }

    @Override
    public List<IPlayers> getPlayerForShift(ITeam team){
        List<IPlayers> playerList = new ArrayList<>();
        int forward = 0;
        int defense = 0;
        int goalie = 0;
        for(IPlayers player : team.getPlayers()) {
            if (player.getPosition().equals("forward") && player.getShifts() < 10 && forward < 3) {
                playerList.add(player);
                forward += 1;
            }
        }
        for(IPlayers player : team.getPlayers()) {
            if (player.getPosition().equals("defense") && player.getShifts() < 10 && defense < 2) {
                playerList.add(player);
                defense += 1;
            }
        }
        for(IPlayers player : team.getPlayers()) {
            if(player.getPosition().equals("goalie") && player.getShifts() < 24 && goalie < 1){
                playerList.add(player);
            }
        }
        return playerList;
    }

    @Override
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

    @Override
    public IPlayers getGoalie(List<IPlayers> playerList){
        for(IPlayers player: playerList){
            if(player.getPosition().equals("goalie")){
                return player;
            }
        }
        return null;
    }

    @Override
    public void saves(IPlayers goalie, IPlayers forward) {
        saveChance += saveCoefficientOne * (goalie.getSaving() - forward.getShooting()) + saveCoefficientTwo;
        if(Math.random() < saveChance){
            goalie.setSaves(goalie.getSaves() + 1);
        }
        else{
            forward.setGoals(forward.getGoals() + 1);
        }
    }

    @Override
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

    @Override
    public void penaltyDefence(List<IPlayers> defenseList){
        IPlayers defenseOne = defenseList.get(0);
        IPlayers defenseTwo = defenseList.get(1);
        double pointOne = defenseOne.getChecking();
        double pointTwo = defenseTwo.getChecking();
        if(Math.random() < pointOne / (pointOne + pointTwo)){
            defenseOne.setPenalties(defenseOne.getPenalties() + 1);
        }
        else{
            defenseTwo.setPenalties(defenseTwo.getPenalties() + 1);
        }
    }

    @Override
    public double getShots(ITeam team) {
        double shots = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            shots += player.getShots();
            player.setShots(0);
        }
        return shots;
    }

    @Override
    public double getSaves(ITeam team) {
        double saves = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            saves += player.getSaves();
            player.setSaves(0);
        }
        return saves;
    }

    @Override
    public double getGoals(ITeam team) {
        double goals = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            goals += player.getGoals();
            player.setGoals(0);
        }
        return goals;
    }

    @Override
    public double getPenalties(ITeam team) {
        double penalties = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            penalties += player.getPenalties();
            player.setPenalties(0);
        }
        return penalties;
    }

    @Override
    public void setPenaltyChance(double penaltyChance) {
        this.penaltyChance = penaltyChance;
    }

    @Override
    public void setShotChance(double shotChance) {
        this.shotChance = shotChance;
    }

    @Override
    public void setSaveChance(double saveChance) {
        this.shotChance = saveChance;
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

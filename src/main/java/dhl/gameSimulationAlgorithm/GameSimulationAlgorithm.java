package dhl.gameSimulationAlgorithm;


import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameSimulationAlgorithm implements IGameSimulationAlgorithm{
    private double penaltyChance;
    private double saveChance;
    private double shotChance;
    private double saveCoefficientOne;
    private double saveCoefficientTwo;
    private double shotCoefficientOne;
    private double shotCoefficientTwo;

    public GameSimulationAlgorithm(){
    }

    public GameSimulationAlgorithm(double penaltyChance, double saveChance, double shotChance){
        this.penaltyChance = penaltyChance;
        this.shotChance = shotChance;
        this.saveChance = saveChance;
    }

    @Override
    public IPlayers getPlayerWithLeastShift(List<IPlayers> playersList){
        List<Integer> shiftList = new ArrayList<>();
        for(IPlayers player : playersList){
            shiftList.add(player.getShifts());
        }
        int index = shiftList.indexOf(Collections.min(shiftList));
        return playersList.get(index);
    }

    @Override
    public List<IPlayers> getPlayerForShift(ITeam team){
        List<IPlayers> playerList = new ArrayList<>();
        List<IPlayers> defenseList = new ArrayList<>();
        List<IPlayers> forwardList = new ArrayList<>();
        for(IPlayers player : team.getPlayers()){
            if(player.getPosition().equals(Configurables.FORWARD.getAction())){
                forwardList.add(player);
            }
            if(player.getPosition().equals(Configurables.DEFENSE.getAction())){
                defenseList.add(player);
            }
        }
        int goalie = 0;
        for(int forward = 0; forward < 3; forward++){
            playerList.add(getPlayerWithLeastShift(forwardList));
        }
        for(int defense = 0; defense < 2; defense++){
            playerList.add(getPlayerWithLeastShift(defenseList));
        }
        for(IPlayers player : team.getPlayers()) {
            if(player.getPosition().equals(Configurables.GOALIE.getAction()) && player.getShifts() < 24 && goalie < 1){
                playerList.add(player);
                goalie += 1;
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
            if(player.getPosition().equals(Configurables.GOALIE.getAction())){
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
    public void reset(ITeam team) {
        for(IPlayers player : team.getPlayers()){
            player.setSaves(0);
            player.setShots(0);
            player.setPenalties(0);
            player.setGoals(0);
            player.setShifts(0);
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
        }
        return shots;
    }

    @Override
    public double getSaves(ITeam team) {
        double saves = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            saves += player.getSaves();
        }
        return saves;
    }

    @Override
    public double getGoals(ITeam team) {
        double goals = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            goals += player.getGoals();
        }
        return goals;
    }

    @Override
    public double getPenalties(ITeam team) {
        double penalties = 0;
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            penalties += player.getPenalties();
        }
        return penalties;
    }

    @Override
    public void getTeamStatistic(ITeam team) {
        double goals = team.getGoals();
        double penalties = team.getPenalties();
        double shots = team.getShots();
        double saves = team.getSaves();
        List<IPlayers> playerList = team.getPlayers();
        for(IPlayers player : playerList) {
            goals += player.getGoals();
            penalties += player.getPenalties();
            shots += player.getShots();
            saves += player.getSaves();
        }
        team.setGoals(goals);
        team.setPenalties(penalties);
        team.setShots(shots);
        team.setSaves(saves);
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

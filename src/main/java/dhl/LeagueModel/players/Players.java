package dhl.LeagueModel.players;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.gamePlayConfig.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Players implements IPlayers {

    String playerName;
    String position;
    boolean captain;
    int skating;
    int shooting;
    int checking;
    int saving;
    int age;
    int daysToAge = 1;
    double strength;
    int injuredDays = 0;
    boolean isRetired = false;
    boolean isInjured = false;

    public Players() {
    }

    public Players(String playerName, String position, boolean captain) {
        this.playerName = playerName;
        this.position = position;
        this.captain = captain;
    }


    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean getCaptain() {
        return captain;
    }

    @Override
    public void setCaptain(boolean captain) {
        this.captain = captain;

    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getSkating() {
        return skating;
    }

    @Override
    public void setSkating(int skating) {
        this.skating = skating;

    }

    @Override
    public int getShooting() {
        return shooting;
    }

    @Override
    public void setShooting(int shooting) {
        this.shooting = shooting;

    }

    @Override
    public int getChecking() {
        return checking;

    }

    @Override
    public void setChecking(int checking) {
        this.checking = checking;

    }

    @Override
    public int getSaving() {
        return saving;

    }

    @Override
    public void setSaving(int saving) {
        this.saving = saving;

    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public int getDaysToAge() {
        return daysToAge;
    }
    @Override
    public void setDaysToAge(int daysToAge) {
        this.daysToAge = daysToAge;
    }

    @Override
    public boolean isRetired() {
        return isRetired;
    }

    @Override
    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    @Override
    public int getInjuredDays() {
        return injuredDays;
    }
    @Override
    public void setInjuredDays(int injuredDays) {
        this.injuredDays = injuredDays;
    }
    @Override
    public boolean isInjured() {
        return isInjured;
    }
    @Override
    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    private int calculateNewDaysToAge(int days, IPlayers player) {
        int currentDays = player.getDaysToAge();
        int newDays = currentDays + days;
        return newDays;
    }

    @Override
    public void agePlayer(IPlayers player, int days) {
        int newDaysToAge = calculateNewDaysToAge(days, player);
        if(newDaysToAge<=365) {
            player.setDaysToAge(newDaysToAge);
        }
        else {
            newDaysToAge = newDaysToAge % 365;
            player.setAge(player.getAge() + 1);
            player.setDaysToAge(newDaysToAge);
        }
        if(player.isInjured()) {
            player.setInjuredDays(player.getInjuredDays() - days);
            player.playerStillInjured(player);
            player.checkIfRetired(player);
        }
        else {
            checkIfRetired(player);
        }
    }

    @Override
    public void checkIfRetired(IPlayers player) {
        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
        Aging aging = gamePlayConfig.getAging();
        int average = aging.getAverageRetirementAge();
        int max = aging.getMaximumAge();
        int playerAge = player.getAge();
        Integer[] retirementAge = {average-5,average-4,average-3,average-2,average-1,average,average+1,average+4,average+5,max};
        int[] retirementArray = {5,10,15,20,25,30,50,70,80,100};

        int minDistance = Math.abs(retirementAge[0] - playerAge);
        int minIndex = 0;
        for(int i = 1; i < retirementAge.length; i++){
            int currentDistance = Math.abs(retirementAge[i] - playerAge);
            if(currentDistance < minDistance){
                minIndex = i;
                minDistance = currentDistance;
            }
        }
        int theNumber = retirementAge[minIndex];
        System.out.println("Closest Bracket" + theNumber);
        int index = Arrays.asList(retirementAge).indexOf(theNumber);
        System.out.println("Index is" + index);
        int randomNumber = ThreadLocalRandom.current().nextInt(0,101);
        System.out.println("Random Number is" + randomNumber);
        if(randomNumber >= 0 && randomNumber <= retirementArray[index]) {
            System.out.println("Inside Retirement");
            player.setRetired(true);
        } else {
            player.setRetired(false);
        }
    }

    @Override
    public IFreeAgents replacePlayerWithFreeAgent(IPlayers player, ArrayList<IFreeAgents> freeAgents) {
        List<Double> freeAgentStrengthList = new ArrayList<>();
            for(IFreeAgents freeAgent: freeAgents) {
                if(player.getPosition().equals(freeAgent.getPosition())) {
                    double freeAgentStrength = freeAgent.calculateStrength(freeAgent);
                    System.out.println("Strength" + freeAgentStrength);
                    freeAgentStrengthList.add(freeAgentStrength);
                }
            }
        double maxStrength = Collections.max(freeAgentStrengthList);
        int maxIndex = freeAgentStrengthList.indexOf(maxStrength);
        System.out.println("Max Strength of Free Agent is: " + maxStrength);
        System.out.println("Max Index is: " + maxIndex);
        IFreeAgents  bestFreeAgent = freeAgents.get(maxIndex);
        System.out.println(bestFreeAgent.getPlayerName());
        return bestFreeAgent;
    }

    @Override
    public void checkForPlayerInjury(IPlayers player) {
        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
        Injuries injuries = gamePlayConfig.getInjuries();

        double randomInjuryChance = injuries.getRandomInjuryChance();
        int injuryDaysLow = injuries.getInjuryDaysLow();
        int injuryDaysHigh = injuries.getInjuryDaysHigh();
        double endRange = randomInjuryChance * 100;
        int randomNumber = ThreadLocalRandom.current().nextInt(0,101);
        if(randomNumber <= endRange) {
            player.setInjured(true);
            int randomInjuryDays = ThreadLocalRandom.current().nextInt(injuryDaysLow,injuryDaysHigh + 1);
            System.out.println("Player is Injured for " + randomInjuryDays + " days");
            player.setInjuredDays(randomInjuryDays);
        }
    }

    @Override
    public void playerStillInjured(IPlayers player) {
        if(player.getInjuredDays() <= 0) {
            player.setInjured(false);
            player.setInjuredDays(0);
        }
    }

    @Override
    public IPlayers convertFreeAgentToPlayer(IFreeAgents agent) {
        IPlayers player = new Players();
        player.setPlayerName(agent.getPlayerName());
        player.setPosition(agent.getPosition());
        player.setAge(agent.getAge());
        player.setSkating(agent.getSkating());
        player.setShooting(agent.getShooting());
        player.setChecking(agent.getChecking());
        player.setSaving(agent.getSaving());
        player.setStrength(agent.getStrength());
        player.setCaptain(false);
        return player;
    }

    @Override
    public IFreeAgents convertPlayerToFreeAgent(IPlayers player) {

        IFreeAgents agent = new FreeAgents();
        agent.setPlayerName(player.getPlayerName());
        agent.setPosition(player.getPosition());
        agent.setAge(player.getAge());
        agent.setSkating(player.getSkating());
        agent.setShooting(player.getShooting());
        agent.setChecking(player.getChecking());
        agent.setSaving(player.getSaving());
        agent.setStrength(player.getStrength());

        return agent;
    }

    @Override
    public void savePlayer(int teamID) {
        IPlayersPersistence playersPersistence = new PlayersPersistence();
        String playerName = this.getPlayerName();
        String position = this.getPosition();
        int age = this.getAge();
        int injuryDays = this.getInjuredDays();
        boolean[] booleanAttributes = {this.getCaptain(),this.isRetired(),this.isInjured()};
        int[] playerAttributes = {this.getSkating(), this.getChecking(), this.getShooting(), this.getSaving()};
        playersPersistence.savePlayerToDB(playerName,position,booleanAttributes,age,playerAttributes,teamID,injuryDays);
    }


}

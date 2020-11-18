package dhl.leagueModel.players;

import dhl.Configurables;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IAging;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IInjuries;
import dhl.mock.MockGamePlayConfig;
import dhl.persistence.saving.IPlayersPersistence;
import dhl.persistence.saving.PlayersPersistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Players implements IPlayers {

    private String playerName;
    private String position;
    private boolean captain;
    private int skating;
    private int shooting;
    private int checking;
    private int saving;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private int age = 0;
    private int daysToAge = 1;
    private double strength;
    private int injuredDays = 0;
    private boolean isRetired = false;
    private boolean isInjured = false;
    private LocalDate playerCurrentDate;
    private IGamePlayConfig gamePlayConfig;

    public Players() {
        gamePlayConfig = MockGamePlayConfig.createMock();
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

    @Override
    public int getBirthDay() {
        return birthDay;
    }

    @Override
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int getBirthMonth() {
        return birthMonth;
    }

    @Override
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public LocalDate getPlayerCurrentDate() {
        return playerCurrentDate;
    }

    @Override
    public void setPlayerCurrentDate(LocalDate playerCurrentDate) {
        this.playerCurrentDate = playerCurrentDate;
    }

    private int calculateNewDaysToAge(int days, IPlayers player) {
        int currentDays = player.getDaysToAge();
        int newDays = currentDays + days;
        return newDays;
    }

//    @Override
//    public void agePlayer(int days) {
//        int newDaysToAge = calculateNewDaysToAge(days, this);
//        if (newDaysToAge <= 365) {
//            this.setDaysToAge(newDaysToAge);
//        } else {
//            newDaysToAge = newDaysToAge % 365;
//            this.setAge(this.getAge() + 1);
//            this.setDaysToAge(newDaysToAge);
//        }
//        if (this.isInjured()) {
//            this.setInjuredDays(this.getInjuredDays() - days);
//            this.playerStillInjured();
//            this.checkIfRetired();
//        } else {
//            checkIfRetired();
//        }
//    }

    @Override
    public void checkIfRetired() {
        System.out.println("Inside Retirement");
        IAging aging = gamePlayConfig.getAging();
        int average = aging.getAverageRetirementAge();
        int max = aging.getMaximumAge();
        int playerAge = this.getAge();
        System.out.println(playerAge);
        Integer[] retirementAge = {average - 5, average - 4, average - 3, average - 2, average - 1, average, average + 1, average + 4, average + 5, max};
        Integer[] retirementArray = {5, 10, 15, 20, 25, 30, 50, 70, 80, 100};

        int minDistance = Math.abs(retirementAge[0] - playerAge);
        int minIndex = 0;
        for (int i = 1; i < retirementAge.length; i++) {
            int currentDistance = Math.abs(retirementAge[i] - playerAge);
            if (currentDistance < minDistance) {
                minIndex = i;
                minDistance = currentDistance;
            }
        }
        int closestBracket = retirementAge[minIndex];
        int index = Arrays.asList(retirementAge).indexOf(closestBracket);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        if (randomNumber >= 0 && randomNumber <= retirementArray[index]) {
            this.setRetired(true);
        } else {
            this.setRetired(false);
        }
        System.out.println(this.isRetired);
    }
    @Override
    public void agePlayer(int daysToAge) {
        int year = this.getBirthYear();
        int month = this.getBirthMonth();
        int days = this.getBirthDay();
        if(this.age == 0) {
            this.playerCurrentDate = LocalDate.now();
            this.setAge(this.playerCurrentDate.getYear() - year);
        }
        this.setPlayerCurrentDate(this.getPlayerCurrentDate().plusDays(daysToAge));
        LocalDate nextBirthDay = LocalDate.of(this.playerCurrentDate.getYear(), month, days);
        System.out.println(this.playerCurrentDate);
        System.out.println(nextBirthDay);
        if (nextBirthDay.isBefore(this.playerCurrentDate)) {
            System.out.println("Inside Increase");
            this.setAge(this.playerCurrentDate.getYear() - year);
        } else {
            this.setAge(this.playerCurrentDate.getYear() - year - 1);
        }

        if (this.isInjured()) {
            this.setInjuredDays(this.getInjuredDays() - daysToAge);
            this.playerStillInjured();
            this.checkIfRetired();
        } else {
            this.checkIfRetired();
        }

    }

    @Override
    public IFreeAgents replacePlayerWithFreeAgent(IPlayers player, ArrayList<IFreeAgents> freeAgents) {
        List<Double> freeAgentStrengthList = new ArrayList<>();
        for (IFreeAgents freeAgent : freeAgents) {
            if (player.getPosition().equals(freeAgent.getPosition())) {
                double freeAgentStrength = freeAgent.calculateStrength(freeAgent);
                freeAgentStrengthList.add(freeAgentStrength);
            }
        }
        double maxStrength = Collections.max(freeAgentStrengthList);
        int maxIndex = freeAgentStrengthList.indexOf(maxStrength);
        IFreeAgents bestFreeAgent = freeAgents.get(maxIndex);
        return bestFreeAgent;
    }

    @Override
    public void checkForPlayerInjury() {
        IInjuries injuries = gamePlayConfig.getInjuries();
        double randomInjuryChance = injuries.getRandomInjuryChance();
        int injuryDaysLow = injuries.getInjuryDaysLow();
        int injuryDaysHigh = injuries.getInjuryDaysHigh();
        double endRange = randomInjuryChance * 100;
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        if (randomNumber <= endRange) {
            this.setInjured(true);
            int randomInjuryDays = ThreadLocalRandom.current().nextInt(injuryDaysLow, injuryDaysHigh + 1);
            this.setInjuredDays(randomInjuryDays);
        }
    }

    @Override
    public double strengthCalculator(int[] forwardValues) {
        double playerStrength = 0;
        playerStrength = IntStream.of(forwardValues).sum();
        return playerStrength;
    }

    @Override
    public double calculateStrength(IPlayers player) {
        String position = player.getPosition();
        int skating = player.getSkating();
        int shooting = player.getShooting();
        int checking = player.getChecking();
        int saving = player.getSaving();
        double strength;

        if (position.equals(Configurables.FORWARD.getAction())) {
            int[] forwardValues = {skating, shooting, checking / 2};
            strength = strengthCalculator(forwardValues);
            player.setStrength(strength);
        } else if (position.equals(Configurables.DEFENSE.getAction())) {
            int[] defenseValues = {skating, shooting / 2, checking};
            strength = strengthCalculator(defenseValues);
            player.setStrength(strength);
        } else {
            int[] goalieValues = {skating, saving};
            strength = strengthCalculator(goalieValues);
            player.setStrength(strength);
        }

        if (player.isInjured()) {
            player.setStrength(player.getStrength() / 2);
            strength = strength / 2;
        }

        return strength;
    }

    @Override
    public void playerStillInjured() {
        if (this.getInjuredDays() <= 0) {
            this.setInjured(false);
            this.setInjuredDays(0);
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
        boolean[] booleanAttributes = {this.getCaptain(), this.isRetired(), this.isInjured()};
        int[] playerAttributes = {this.getSkating(), this.getChecking(), this.getShooting(), this.getSaving()};
        playersPersistence.savePlayerToDB(playerName, position, booleanAttributes, age, playerAttributes, teamID, injuryDays);
    }


}

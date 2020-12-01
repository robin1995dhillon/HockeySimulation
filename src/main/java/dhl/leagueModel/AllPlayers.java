package dhl.leagueModel;

import dhl.Configurables;
import dhl.leagueModel.gamePlayConfig.IAging;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IInjuries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class AllPlayers implements IAllPlayers {

    private static final Logger logger = LogManager.getLogger(AllPlayers.class);
    private String playerName;
    private String position;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private int age = 0;
    private double strength;
    private int injuredDays = 0;
    private boolean isRetired = false;
    private boolean isInjured = false;
    private LocalDate playerCurrentDate = LocalDate.now();
    private IGamePlayConfig gamePlayConfig;
    private int skating;
    private int shooting;
    private int checking;
    private int saving;

    public AllPlayers() {
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
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
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
    public int getInjuredDays() {
        return injuredDays;
    }

    @Override
    public void setInjuredDays(int injuredDays) {
        this.injuredDays = injuredDays;
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
    public boolean isInjured() {
        return isInjured;
    }

    @Override
    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    @Override
    public LocalDate getPlayerCurrentDate() {
        return playerCurrentDate;
    }

    @Override
    public void setPlayerCurrentDate(LocalDate playerCurrentDate) {
        this.playerCurrentDate = playerCurrentDate;
    }

    @Override
    public IGamePlayConfig getGamePlayConfig() {
        return gamePlayConfig;
    }

    @Override
    public void setGamePlayConfig(IGamePlayConfig gamePlayConfig) {
        this.gamePlayConfig = gamePlayConfig;
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
    public void agePlayer(int daysToAge, IGamePlayConfig gamePlayConfig) {
        this.gamePlayConfig = gamePlayConfig;
        int year = this.getBirthYear();
        int month = this.getBirthMonth();
        int days = this.getBirthDay();

        if(this.age == 0) {
            this.playerCurrentDate = LocalDate.now();
            this.setAge(this.playerCurrentDate.getYear() - year);
        }
        this.setPlayerCurrentDate(this.getPlayerCurrentDate().plusDays(daysToAge));
        LocalDate nextBirthDay = LocalDate.of(this.playerCurrentDate.getYear(), month, days);

        if (nextBirthDay.isBefore(this.playerCurrentDate)) {
            this.setAge(this.playerCurrentDate.getYear() - year + 1);
        } else {
            this.setAge(this.playerCurrentDate.getYear() - year);
        }
        logger.info(this.playerName + " is aged by " + daysToAge + " days.");
        if (this.isInjured()) {
            this.setInjuredDays(this.getInjuredDays() - daysToAge);
            this.playerStillInjured();
        }
        this.checkIfRetired();
    }

    @Override
    public void checkIfRetired() {
        IAging aging = gamePlayConfig.getAging();
        int average = aging.getAverageRetirementAge();
        int max = aging.getMaximumAge();
        int playerAge = this.getAge();
        Integer[] retirementAge = {average - 4, average - 3, average - 2, average - 1, average, average + 1, average + 4, average + 5, max};
        Integer[] retirementArray = {1, 2, 3, 10, 15, 25, 35, 50, 100};

        int minDistance = Math.abs(retirementAge[0] - playerAge);
        int minIndex = 0;
        for (int i = 1; i < retirementAge.length; i++) {
            int currentDistance = Math.abs(retirementAge[i] - playerAge);
            if (currentDistance < minDistance) {
                minIndex = i;
                minDistance = currentDistance;
            }
        }
        if(age>retirementAge[0]) {
            int closestBracket = retirementAge[minIndex];
            int index = Arrays.asList(retirementAge).indexOf(closestBracket);
            int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
            if (randomNumber >= 0 && randomNumber <= retirementArray[index]) {
                logger.info(this.playerName + " is retired.");
                this.setRetired(true);
            } else {
                this.setRetired(false);
            }
        }

    }

    @Override
    public void playerStillInjured() {
        if (this.getInjuredDays() <= 0) {
            this.setInjured(false);
            this.setInjuredDays(0);
        }
    }

    @Override
    public void statsDecayDueToBirthDay() {
        LocalDate nextPlayerBirthday = LocalDate.of(this.playerCurrentDate.getYear(), this.birthMonth, this.birthDay);
        if(nextPlayerBirthday.equals(this.playerCurrentDate) || nextPlayerBirthday.isBefore(playerCurrentDate)) {
            IAging aging = gamePlayConfig.getAging();
            double statDecayChance = aging.getStatDecayChance() * 100;
            double randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
            if(randomNumber<=statDecayChance) {
                this.setShooting(this.getShooting() - 1);
                this.setSaving(this.getSaving() - 1);
                this.setSkating(this.getSkating() - 1);
                this.setSaving(this.getSaving() - 1);
                logger.info(this.playerName + "'s stats has been decreased by one due to stats decay on birthday.");
            }
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
        player.setBirthMonth(agent.getBirthMonth());
        player.setBirthDay(agent.getBirthDay());
        player.setBirthYear(agent.getBirthYear());
        player.setCaptain(false);
        player.setBirthMonth(agent.getBirthMonth());
        player.setBirthDay(agent.getBirthDay());
        player.setBirthYear(agent.getBirthYear());
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
        agent.setBirthMonth(player.getBirthMonth());
        agent.setBirthDay(player.getBirthDay());
        agent.setBirthYear(player.getBirthYear());
        return agent;
    }

    @Override
    public boolean checkPosition(String position) {
        return this.position.equals(position);
    }

    @Override
    public double strengthCalculator(int[] forwardValues) {
        double playerStrength;
        playerStrength = IntStream.of(forwardValues).sum();
        return playerStrength;
    }

    @Override
    public double calculateStrength() {
        String position = this.getPosition();
        int skating = this.getSkating();
        int shooting = this.getShooting();
        int checking = this.getChecking();
        int saving = this.getSaving();
        double strength;
        if (position.equals(Configurables.FORWARD.getAction())) {
            int[] forwardValues = {skating, shooting, checking / 2};
            strength = strengthCalculator(forwardValues);
            this.setStrength(strength);
        } else if (position.equals(Configurables.DEFENSE.getAction())) {
            int[] defenseValues = {skating, shooting / 2, checking};
            strength = strengthCalculator(defenseValues);
            this.setStrength(strength);
        } else {
            int[] goalieValues = {skating, saving};
            strength = strengthCalculator(goalieValues);
            this.setStrength(strength);
        }

        if (this.isInjured()) {
            this.setStrength(this.getStrength() / 2);
            strength = strength / 2;
        }
        logger.info(this.playerName + "'s strength is " + this.getStrength());
        return strength;
    }

    @Override
    public IFreeAgents replacePlayerWithFreeAgent(IPlayers player, List<IFreeAgents> freeAgents) {
        List<Double> freeAgentStrengthList = new ArrayList<>();
        List<IFreeAgents> freeAgentOfAType = new ArrayList<>();
        for (IFreeAgents freeAgent : freeAgents) {
            if (player.getPosition().equals(freeAgent.getPosition())) {
                double freeAgentStrength = freeAgent.calculateStrength();
                freeAgent.setStrength(freeAgentStrength);
                freeAgentStrengthList.add(freeAgentStrength);
                freeAgentOfAType.add(freeAgent);
            }
        }
        double maxStrength = Collections.max(freeAgentStrengthList);
        int maxIndex = freeAgentStrengthList.indexOf(maxStrength);
        freeAgents.remove(freeAgentOfAType.get(maxIndex));
        return freeAgentOfAType.get(maxIndex);
    }

    @Override
    public void checkForPlayerInjury(IGamePlayConfig gamePlayConfig) {
        if (isInjured){
            logger.info(this.playerName + "is already injured. He still needs " + this.getInjuredDays() + "to recover.");
            return;
        }
        IInjuries injuries = gamePlayConfig.getInjuries();
        double randomInjuryChance = injuries.getRandomInjuryChance();
        int injuryDaysLow = injuries.getInjuryDaysLow();
        int injuryDaysHigh = injuries.getInjuryDaysHigh();
        double endRange = randomInjuryChance * 100;
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        if (randomNumber <= endRange) {
            System.out.println(this.playerName + " Is Injured");
            this.setInjured(true);
            int randomInjuryDays = ThreadLocalRandom.current().nextInt(injuryDaysLow, injuryDaysHigh + 1);
            this.setInjuredDays(randomInjuryDays);
            logger.info(this.playerName + " is injured for " + this.getInjuredDays() + " days.");
        }
    }
}

package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

import java.time.LocalDate;
import java.util.List;

public interface IAllPlayers {
    String getPlayerName();

    void setPlayerName(String playerName);

    String getPosition();

    void setPosition(String position);

    int getBirthDay();

    void setBirthDay(int birthDay);

    int getBirthMonth();

    void setBirthMonth(int birthMonth);

    int getBirthYear();

    void setBirthYear(int birthYear);

    int getAge();

    void setAge(int age);

    double getStrength();

    void setStrength(double strength);

    int getInjuredDays();

    void setInjuredDays(int injuredDays);

    boolean isRetired();

    void setRetired(boolean retired);

    boolean isInjured();

    void setInjured(boolean injured);

    LocalDate getPlayerCurrentDate();

    void setPlayerCurrentDate(LocalDate playerCurrentDate);

    IGamePlayConfig getGamePlayConfig();

    void setGamePlayConfig(IGamePlayConfig gamePlayConfig);

    int getSkating();

    void setSkating(int skating);

    int getShooting();

    void setShooting(int shooting);

    int getChecking();

    void setChecking(int checking);

    int getSaving();

    void setSaving(int saving);

    void agePlayer(int daysToAge, IGamePlayConfig gameplayConfig);

    void checkIfRetired();

    void playerStillInjured();

    void statsDecayDueToBirthDay();

    IPlayers convertFreeAgentToPlayer(IFreeAgents agent);

    IFreeAgents convertPlayerToFreeAgent(IPlayers player);

    boolean checkPosition(String position);

    double strengthCalculator(int[] forwardValues);

    double calculateStrength();

    IFreeAgents replacePlayerWithFreeAgent(IPlayers player, List<IFreeAgents> freeAgents);

    void checkForPlayerInjury(IGamePlayConfig gamePlayConfig);
}

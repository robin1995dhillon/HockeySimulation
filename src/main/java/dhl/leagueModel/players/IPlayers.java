package dhl.leagueModel.players;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.freeAgents.IFreeAgents;

import java.util.ArrayList;

@JsonDeserialize(as= Players.class)
public interface IPlayers {
    public String getPlayerName();

    public void setPlayerName(String playerName);
    public String getPosition() ;

    public void setPosition(String position);

    public boolean getCaptain() ;

    public void setCaptain(boolean captain);

    public int getAge();

    public void setAge(int age);


    public int getSkating();

    public void setSkating(int skating);

    public int getShooting();

    public void setShooting(int shooting);

    public int getChecking();

    public void setChecking(int checking);


    public int getSaving();

    public void setSaving(int saving);

    public double getStrength();

    public void setStrength(double strength);

    public boolean isRetired() ;

    public void setRetired(boolean isRetired);

    int getDaysToAge();
    void setDaysToAge(int daysToAge);

    int getInjuredDays();

    void setInjuredDays(int injuredDays);

    boolean isInjured();

    void setInjured(boolean injured);

    public void agePlayer(int days);

    void checkIfRetired();

    IFreeAgents replacePlayerWithFreeAgent(IPlayers player, ArrayList<IFreeAgents> freeAgents);

    void checkForPlayerInjury();

    void playerStillInjured();

    IPlayers convertFreeAgentToPlayer(IFreeAgents agent);
    IFreeAgents convertPlayerToFreeAgent(IPlayers player);

    void savePlayer(int teamID);
}

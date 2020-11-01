package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.freeAgents.FreeAgents;

import java.util.List;

@JsonDeserialize(as= FreeAgents.class)
public interface IFreeAgents {
    String getPlayerName();

    void setPlayerName(String playerName);
    String getPosition() ;
    void setPosition(String position);

    int getAge();

    void setAge(int age);

    int getSkating();

    void setSkating(int skating);

    int getShooting();

    void setShooting(int shooting);

    int getChecking();

    void setChecking(int checking);


    int getSaving();

    void setSaving(int saving);

    double getStrength();

    void setStrength(double strength);

    double calculateStrength();

    double strengthAdder(int[] positionValues);

    IFreeAgents getFreeAgentFromList(List<IFreeAgents> freeAgentList, String freeAgentName);
    boolean checkPosition(String position);

    void saveFreeAgent(int leagueID);
}

package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=FreeAgents.class)
public interface IFreeAgents {
    public String getPlayerName();

    public void setPlayerName(String playerName);
    public String getPosition() ;
    public void setPosition(String position);

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

}

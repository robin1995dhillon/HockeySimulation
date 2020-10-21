package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=Players.class)
public interface IPlayers {
    public String getPlayerName();

    public void setPlayerName(String playerName);
    public String getPosition() ;

    public void setPosition(String position);

    public boolean getCaptain() ;

    public void setCaptain(boolean captain) ;

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


}

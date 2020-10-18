package dhl.LeagueModel;

import org.apache.commons.io.TaggedIOException;

public interface IPlayers2 {
    public String getPlayerName();

    public void setPlayerName(String playerName);
    public String getPosition() ;

    public void setPosition(String position);

    public Boolean getCaptain() ;

    public void setCaptain(boolean captain) ;

    public void getAge();

    public void setAge(int age);


    public void getSkating();

    public void setSkating(double skating);

    public void getShooting();

    public void setShooting(double shooting);

    public void getChecking();

    public void setChecking(double checking);


    public void getSaving();

    public void setSaving(double saving);


}

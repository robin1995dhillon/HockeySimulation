package dhl.LeagueModel;

public class FreeAgents implements IAllPlayers {

    String playerName = "";
    String position = "";
    Boolean captain = null;

    public FreeAgents(String playerName, String position, Boolean captain) {
        this.playerName = playerName;
        this.position = position;
        this.captain = captain;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }
}

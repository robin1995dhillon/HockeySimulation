package dhl.LeagueModel;

public class FreeAgents implements IAllPlayers {

    String PlayerName = "";
    String Position = "";
    Boolean Captain = null;

    public FreeAgents(String playerName, String position, Boolean captain) {
        PlayerName = playerName;
        Position = position;
        Captain = captain;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Boolean getCaptain() {
        return Captain;
    }

    public void setCaptain(Boolean captain) {
        Captain = captain;
    }
}

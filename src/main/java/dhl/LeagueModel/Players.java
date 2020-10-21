package dhl.LeagueModel;

public class Players implements IPlayers {

    String playerName;
    String position;
    boolean captain;
    int skating;
    int shooting;
    int checking;
    int saving;
    int age;
    double strength;

    public Players() {
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
}

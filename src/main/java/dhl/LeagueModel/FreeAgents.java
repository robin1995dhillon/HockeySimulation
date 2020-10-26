package dhl.LeagueModel;

public class FreeAgents implements IFreeAgents{

    String playerName;
    String position;
    int skating;
    int shooting;
    int checking;
    int saving;
    int age;

    public FreeAgents() {
    }
    public FreeAgents(String playerName, String position) {
        this.playerName = playerName;
        this.position = position;

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
}

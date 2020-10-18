package dhl.LeagueModel;

public class FreeAgents2 implements IFreeAgents{

    String playerName;
    String position;
    double skating;
    double shooting;
    double checking;
    double saving;
    int age;


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
        return null;
    }

    @Override
    public void setPosition(String position) {

        this.position = position;
    }

    @Override
    public void getAge() {

    }

    @Override
    public void setAge(int age) {
        this.age = age;

    }

    @Override
    public void getSkating() {

    }

    @Override
    public void setSkating(double skating) {
        this.skating = skating;

    }

    @Override
    public void getShooting() {

    }

    @Override
    public void setShooting(double shooting) {
        this.shooting = shooting;

    }

    @Override
    public void getChecking() {

    }

    @Override
    public void setChecking(double checking) {
        this.checking = checking;

    }

    @Override
    public void getSaving() {

    }

    @Override
    public void setSaving(double saving) {
        this.saving = saving;

    }
}

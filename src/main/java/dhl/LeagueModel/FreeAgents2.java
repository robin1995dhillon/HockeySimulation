package dhl.LeagueModel;

public class FreeAgents2 implements IFreeAgents{

    String playerName;
    String position;
    double skating;
    double shooting;
    double checking;
    double saving;
    int age;

    public FreeAgents2() {
    }
    public FreeAgents2(String playerName, String position) {
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
    public double getSkating() {

        return skating;
    }

    @Override
    public void setSkating(double skating) {
        this.skating = skating;

    }

    @Override
    public double getShooting() {

        return shooting;
    }

    @Override
    public void setShooting(double shooting) {
        this.shooting = shooting;

    }

    @Override
    public double getChecking() {

        return checking;
    }

    @Override
    public void setChecking(double checking) {
        this.checking = checking;

    }

    @Override
    public double getSaving() {

        return saving;
    }

    @Override
    public void setSaving(double saving) {
        this.saving = saving;

    }
}

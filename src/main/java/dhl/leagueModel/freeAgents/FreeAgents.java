package dhl.leagueModel.freeAgents;

import dhl.Configurables;
import dhl.persistence.saving.FreeAgentsPersistence;
import dhl.persistence.saving.IFreeAgentsPersistence;

import java.util.List;
import java.util.stream.IntStream;

public class FreeAgents implements IFreeAgents {

    private String playerName;
    private String position;
    private int skating;
    private int shooting;
    private int checking;
    private int saving;
    private int age;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private double strength;

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

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public int getBirthDay() {
        return birthDay;
    }

    @Override
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public int getBirthMonth() {
        return birthMonth;
    }

    @Override
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public double calculateStrength(IFreeAgents freeAgents) {
        String position = freeAgents.getPosition();
        int skating = freeAgents.getSkating();
        int shooting = freeAgents.getShooting();
        int checking = freeAgents.getChecking();
        int saving = freeAgents.getSaving();
        double strength;

        if (position.equals(Configurables.FORWARD.getAction())) {
            int[] forwardValues = {skating, shooting, checking / 2};
            strength = strengthAdder(forwardValues);
            this.setStrength(strength);
        } else if (position.equals(Configurables.DEFENSE.getAction())) {
            int[] defenseValues = {skating, shooting / 2, checking};
            strength = strengthAdder(defenseValues);
            this.setStrength(strength);
        } else {
            int[] goalieValues = {skating, saving};
            strength = strengthAdder(goalieValues);
            this.setStrength(strength);
        }
        return strength;
    }

    @Override
    public double strengthAdder(int[] positionValues) {
        double playerStrength;
        playerStrength = IntStream.of(positionValues).sum();
        return playerStrength;
    }

    @Override
    public IFreeAgents getFreeAgentFromList(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if (freeAgent.getPlayerName().equals(freeAgentName)) {
                return freeAgent;
            }
        }
        return null;
    }

    @Override
    public boolean checkPosition(String position) {
        if (this.position.equals(position)) {
            return true;
        }
        return false;
    }

//    @Override
//    public void saveFreeAgent(int leagueID) {
//        IFreeAgentsPersistence freeAgentsPersistence = new FreeAgentsPersistence();
//        String freeAgentName = this.getPlayerName();
//        String position = this.getPosition();
//        int age = this.getAge();
//        int skating = this.getSkating();
//        int shooting = this.getShooting();
//        int checking = this.getChecking();
//        int saving = this.getSaving();
//        int[] freeAgentAttributes = {skating, shooting, checking, saving};
//        freeAgentsPersistence.saveFreeAgentsToDB(freeAgentName, position, age, freeAgentAttributes, leagueID);
//    }
}

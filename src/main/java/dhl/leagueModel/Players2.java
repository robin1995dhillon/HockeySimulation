package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Players2.class)
public class Players2 extends AllPlayers implements IPlayers2 {

    private double saves;
    private double shots;
    private double penalties;
    private double goals;
    private int shifts;
    private boolean captain;

    public Players2() {
        super();
    }

    @Override
    public double getSaves() {
        return saves;
    }

    @Override
    public void setSaves(double saves) {
        this.saves = saves;
    }

    @Override
    public double getShots() {
        return shots;
    }

    @Override
    public void setShots(double shots) {
        this.shots = shots;
    }

    @Override
    public double getPenalties() {
        return penalties;
    }

    @Override
    public void setPenalties(double penalties) {
        this.penalties = penalties;
    }

    @Override
    public double getGoals() {
        return goals;
    }

    @Override
    public void setGoals(double goals) {
        this.goals = goals;
    }

    @Override
    public int getShifts() {
        return shifts;
    }

    @Override
    public void setShifts(int shifts) {
        this.shifts = shifts;
    }

    @Override
    public boolean isCaptain() {
        return captain;
    }

    @Override
    public void setCaptain(boolean captain) {
        this.captain = captain;
    }


}

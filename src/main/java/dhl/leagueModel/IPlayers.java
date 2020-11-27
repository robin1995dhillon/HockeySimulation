package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Players.class)
public interface IPlayers extends IAllPlayers {
    double getSaves();

    void setSaves(double saves);

    double getShots();

    void setShots(double shots);

    double getPenalties();

    void setPenalties(double penalties);

    double getGoals();

    void setGoals(double goals);

    int getShifts();

    void setShifts(int shifts);

    boolean getCaptain();

    void setCaptain(boolean captain);
}

package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.players.Players;

@JsonDeserialize(as = Players2.class)
public interface IPlayers2 extends IAllPlayers {
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

    boolean isCaptain();

    void setCaptain(boolean captain);
}

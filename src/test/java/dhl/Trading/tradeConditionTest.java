package dhl.Trading;

import dhl.LeagueModel.HeadCoach;
import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.Teams2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class tradeConditionTest {

    @Test
    public void tradeCondition(){

        ArrayList<ITeam2> team_array = new ArrayList<>();
        IHeadCoach h = new HeadCoach();
        h.setChecking(0.5);
        h.setName("ABC");
        h.setSaving(0.4);
        h.setShooting(0.7);
        h.setSkating(0.3);
        ITeam2 t = new Teams2("Random1", "Random2", h);
        t.setTeamType("ai");
        t.setLossPoints(8);


    }
}

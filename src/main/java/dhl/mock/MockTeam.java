package dhl.mock;

import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;
import java.util.List;

public class MockTeam {

    public static ITeam MockTeam() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setChecking(0.5);
        headCoach.setName("ABC");
        headCoach.setSaving(0.4);
        headCoach.setShooting(0.7);
        headCoach.setSkating(0.3);

//        ITeam team = new Teams("Random1", "Random2", headCoach);
        ITeam team = new Teams();
        team.setTeamStrength(40);
        return team;
    }

    public static ITeam MockTeamTwo() {
        IHeadCoach headCoach2 = new HeadCoach();
        headCoach2.setChecking(0.5);
        headCoach2.setName("ABCD");
        headCoach2.setSaving(0.4);
        headCoach2.setShooting(0.7);
        headCoach2.setSkating(0.3);

//        ITeam team = new Teams("Team2", "GeneralManager2", headCoach2);
        ITeam team = new Teams();
        team.setTeamStrength(50);
        return team;
    }

}

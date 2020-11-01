package dhl.Mock;

import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.ITeam;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.teams.Teams;

public class MockTeam {

    public static ITeam MockTeam() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setChecking(0.5);
        headCoach.setName("ABC");
        headCoach.setSaving(0.4);
        headCoach.setShooting(0.7);
        headCoach.setSkating(0.3);

        ITeam team = new Teams("Random1", "Random2", headCoach);
        return team;
    }

    public static ITeam MockTeamTwo() {
        IHeadCoach headCoach2 = new HeadCoach();
        headCoach2.setChecking(0.5);
        headCoach2.setName("ABCD");
        headCoach2.setSaving(0.4);
        headCoach2.setShooting(0.7);
        headCoach2.setSkating(0.3);

        ITeam team = new Teams("Team2", "GeneralManager2", headCoach2);
        return team;
    }

}

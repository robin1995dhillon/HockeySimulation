package dhl.mock;

import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.TeamStandings;

import java.util.ArrayList;
import java.util.List;

public class MockStandingTeam {

    public static List<ITeamStanding> createTeamStandingMock() {

        List<ITeamStanding> list = new ArrayList<>();

        ITeam team = MockTeam.MockTeamTwo();
        ITeamStanding teamStanding = new TeamStandings();
        teamStanding.setTeam(team);
        teamStanding.setGamesLost(4);
        teamStanding.setTotalPoints(2);
        teamStanding.setGamesWon(1);
        teamStanding.setGamesPlayed(5);
        teamStanding.setDivision("ABC");
        teamStanding.setConference("DEF");

        ITeam team2 = MockTeam.MockTeam();
        ITeamStanding teamStanding2 = new TeamStandings();
        teamStanding2.setTeam(team2);
        teamStanding2.setGamesLost(5);
        teamStanding2.setTotalPoints(8);
        teamStanding2.setGamesWon(4);
        teamStanding2.setGamesPlayed(9);
        teamStanding2.setDivision("GHI");
        teamStanding2.setConference("JKL");
        list.add(teamStanding);
        list.add(teamStanding2);
        for(ITeamStanding teamStandings: list){
            System.out.println(teamStandings.getTotalPoints());


        }
        return list;
    }
}

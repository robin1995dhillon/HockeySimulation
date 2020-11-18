package dhl.mock;

import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
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
        teamStanding.setGamesLost(0);
        teamStanding.setTotalPoints(0);
        teamStanding.setGamesWon(0);
        teamStanding.setGamesPlayed(0);
        teamStanding.setDivision("ABC");
        teamStanding.setConference("DEF");

        ITeam team2 = MockTeam.MockTeam();
        ITeamStanding teamStanding2 = new TeamStandings();
        teamStanding2.setTeam(team2);
        teamStanding2.setGamesLost(0);
        teamStanding2.setTotalPoints(0);
        teamStanding2.setGamesWon(0);
        teamStanding2.setGamesPlayed(0);
        teamStanding2.setDivision("GHI");
        teamStanding2.setConference("JKL");
        list.add(teamStanding);
        list.add(teamStanding2);
        return list;
    }
}

package dhl.serializeAndDeserialize;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;

public class TeamCreator implements ITeamCreator {

    @Override
    public ILeague createTeam(String ManagerName, IHeadCoach headCoach, ILeague ILeague, String ConferenceName, String DivisionName, String TeamName, ArrayList<IPlayers> playerList, String teamType) {

        ArrayList<IConference> Conference;
        ArrayList<IDivision> Divisions;
        ArrayList<ITeam> Team2;
        Conference = ILeague.getConferences();
        for(IConference c: Conference) {
            if(c.getConferenceName().toLowerCase().equals(ConferenceName.toLowerCase())) {
                Divisions = c.getDivisions();
                for(IDivision d: Divisions) {
                    if(d.getDivisionName().toLowerCase().equals(DivisionName.toLowerCase())) {
                        Team2 = d.getTeams();
                        System.out.println(Team2);
                        ITeam team = new Teams();
                        System.out.println(headCoach);
                        team.setGeneralManager(ManagerName);
                        team.setPlayers(playerList);
                        team.setHeadCoach(headCoach);
                        team.setTeamName(TeamName);
                        team.setTeamType(teamType);
                        team.setIsUser(true);
                        d.addTeam(team);
                    }
                }
            }
        }
        return ILeague;
    }
}

package dhl.Creator;

import dhl.LeagueModel.*;
import dhl.LeagueModel.teams.Teams;

import java.util.ArrayList;

public class TeamCreator {

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
                        d.addTeam(team);
                    }
                }
            }
        }
//        for(Conference c: Conference) {
//            System.out.println(c.getConferenceName());
//            Divisions = c.getDivisions();
//            for(Division d: Divisions) {
//                System.out.println(d.getDivisionName());
//                Teams = d.getTeams();
//                for(Teams t: Teams) {
//                    System.out.println(t.getTeamName());
//                    System.out.println(t.getGeneralManager());
//                    System.out.println(t.getHeadCoach());
//                    }
//                }
//            }
        return ILeague;
    }
}

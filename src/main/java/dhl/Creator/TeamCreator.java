package dhl.Creator;

import dhl.LeagueModel.*;
import dhl.LeagueModel.teams.Teams;

import java.util.ArrayList;

public class TeamCreator {

    public ILeague createTeam(String ManagerName, String HeadCoach, ILeague ILeague, String ConferenceName, String DivisionName, String TeamName) {

        ArrayList<IConference> Conference;
        ArrayList<IDivision> Divisions;
        ArrayList<ITeam2> Team2;
//        ArrayList<ITeam2> Team2;
        Conference = ILeague.getConferences();
        for(IConference c: Conference) {
            if(c.getConferenceName().toLowerCase().equals(ConferenceName.toLowerCase())) {
                Divisions = c.getDivisions();
                for(IDivision d: Divisions) {
                    if(d.getDivisionName().toLowerCase().equals(DivisionName.toLowerCase())) {
                        Team2 = d.getTeams();
                        System.out.println(Team2);
                        ITeam2 team = new Teams();
                        System.out.println(HeadCoach);
                            team.setGeneralManager(ManagerName);
//                            team.setHeadCoach(HeadCoach);
                            team.setTeamName(TeamName);
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

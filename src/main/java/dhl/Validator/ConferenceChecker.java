package dhl.Validator;

//import dhl.LeagueModel;
import dhl.LeagueModel.*;

import java.util.ArrayList;

public class ConferenceChecker {

//    public ConferenceChecker() {
//
//    }

    public boolean ConferenceChecker(String Conference, ILeague ILeague) {
        for (IConference c: ILeague.getConferences()) {
            if(c.getConferenceName().toLowerCase().equals(Conference.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean DivisionChecker(String Division, ILeague ILeague) {
        ArrayList<IConference> IConference;
        ArrayList<IDivision> IDivisions;
        IConference = ILeague.getConferences();
        for(IConference c: IConference) {
            IDivisions = c.getDivisions();
            for(IDivision d: IDivisions) {
                System.out.println(d.getDivisionName());
                if(d.getDivisionName().toLowerCase().equals(Division.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean TeamChecker(String Team, ILeague ILeague) {
        ArrayList<IConference> IConference;
        ArrayList<IDivision> IDivisions;
        ArrayList<ITeam2> ITeam2;
        IConference = ILeague.getConferences();
        for(IConference c: IConference) {
            IDivisions = c.getDivisions();
            for(IDivision d: IDivisions) {
                ITeam2 = d.getTeams();
                for(ITeam2 t: ITeam2) {
                    if(t.getTeamName().toLowerCase().equals(Team.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

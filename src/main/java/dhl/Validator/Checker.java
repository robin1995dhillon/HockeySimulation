package dhl.Validator;

//import dhl.LeagueModel;
import dhl.LeagueModel.*;

import java.util.ArrayList;
import java.util.List;

public class Checker implements IChecker{

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
        ArrayList<ITeam> ITeam;
        IConference = ILeague.getConferences();
        for(IConference c: IConference) {
            IDivisions = c.getDivisions();
            for(IDivision d: IDivisions) {
                ITeam = d.getTeams();
                for(ITeam t: ITeam) {
                    if(t.getTeamName().toLowerCase().equals(Team.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean managerChecker(List<String> managerList, String managerName) {
        for(String s : managerList){
            if(s.equals(managerName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean coachChecker(List<IHeadCoach> coachList, String coachName) {
        for(IHeadCoach headCoach : coachList){
            if(headCoach.getName().equals(coachName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for(IFreeAgents freeAgent : freeAgentList){
            if(freeAgent.getPlayerName().equals(freeAgentName)){
                return true;
            }
        }
        return false;
    }
}

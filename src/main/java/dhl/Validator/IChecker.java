package dhl.Validator;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.ILeague;

import java.util.List;

public interface IChecker {
    boolean ConferenceChecker(String Conference, ILeague ILeague);
    boolean DivisionChecker(String Division, ILeague ILeague);
    boolean TeamChecker(String Team, ILeague ILeague);
    boolean managerChecker(List<String> managerList, String managerName);
    boolean coachChecker(List<IHeadCoach> coachList, String coachName);
    boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName);
//    boolean positionChecker(IFreeAgents freeAgent, String position);
}

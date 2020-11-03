package dhl.validator;

import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;

import java.util.List;

public interface IChecker {
    boolean conferenceChecker(String Conference, ILeague ILeague);

    boolean divisionChecker(String Division, ILeague ILeague);

    boolean teamChecker(String Team, ILeague ILeague);

    boolean managerChecker(List<String> managerList, String managerName);

    boolean coachChecker(List<IHeadCoach> coachList, String coachName);

    boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName);
//    boolean positionChecker(IFreeAgents freeAgent, String position);
}

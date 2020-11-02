package dhl.creator;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;

import java.util.ArrayList;

public interface ITeamCreator {
    ILeague createTeam(String ManagerName, IHeadCoach headCoach, ILeague ILeague, String ConferenceName, String DivisionName, String TeamName, ArrayList<IPlayers> playerList, String teamType);
}

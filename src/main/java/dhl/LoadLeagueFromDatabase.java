package dhl;

import dhl.Database.*;
import dhl.LeagueModel.*;
import dhl.LeagueModel.conference.Conference;
import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.league.League;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.teams.Teams;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadLeagueFromDatabase {

    public ILeague loadLeagueFromDatabase(String teamName) throws IOException, SQLException {
        ICheckStoredProcedure s = new CheckTeam(teamName);
        s.executeProcedure();
        if(s.getExist()){
            ILeague league = new League();
            ArrayList<IConference> conferenceList = new ArrayList<>();
            ArrayList<IFreeAgents> freeAgentList = new ArrayList<>();
            ArrayList<IHeadCoach> freeCoachList = new ArrayList<>();
            ArrayList<String> freeManagerList = new ArrayList<>();
            IGetStoredProcedure getTeam = new GetTeamByName(teamName);
            ResultSet rs = getTeam.executeProcedure();
            while(rs.next()){
                int teamId = rs.getInt("id");
                IGetStoredProcedure getLeague = new GetLeague(teamId);
                ResultSet rsLeague = getLeague.executeProcedure();
                while(rsLeague.next()){
                    int leagueId = rsLeague.getInt("id");
                    league.setLeagueName(rsLeague.getString("name"));

                    IGetStoredProcedure getConference = new GetAllConferenceInLeague(leagueId);
                    ResultSet rsConference = getConference.executeProcedure();
                    while (rsConference.next()){
                        ArrayList<IDivision> divisionList = new ArrayList<>();
                        int conferenceId = rsConference.getInt("id");
                        IConference conference = new Conference();
                        conference.setConferenceName(rsConference.getString("name"));

                        IGetStoredProcedure getDivision = new GetAllDivisionInConference(conferenceId);
                        ResultSet rsDivision = getDivision.executeProcedure();
                        while(rsDivision.next()){
                            ArrayList<ITeam2> teamList = new ArrayList<>();
                            int divisionId = rsDivision.getInt("id");
                            IDivision division = new Division();
                            division.setDivisionName(rsDivision.getString("name"));

                            IGetStoredProcedure getTeamInDivision = new GetAllTeamInDivision(divisionId);
                            ResultSet rsGetTeamInDivision = getTeamInDivision.executeProcedure();
                            while(rsGetTeamInDivision.next()){
                                ArrayList<IPlayers> playerList = new ArrayList<>();
                                int tId = rsGetTeamInDivision.getInt("id");
                                ITeam2 team = new Teams();
                                team.setTeamName(rsGetTeamInDivision.getString("name"));
                                team.setGeneralManager(rsGetTeamInDivision.getString("general_manager"));

                                IGetStoredProcedure getCoach = new GetCoach(tId);
                                ResultSet rsCoach = getCoach.executeProcedure();
                                while(rsCoach.next()){
                                    IHeadCoach headCoach = new HeadCoach();
                                    headCoach.setName(rsCoach.getString("name"));
                                    headCoach.setSkating(rsCoach.getDouble("skating"));
                                    headCoach.setShooting(rsCoach.getDouble("shooting"));
                                    headCoach.setChecking(rsCoach.getDouble("checking"));
                                    headCoach.setSaving(rsCoach.getDouble("saving"));
                                    team.setHeadCoach(headCoach);
                                }

                                IGetStoredProcedure getPlayer = new GetTeamPlayer(tId);
                                ResultSet rsPlayer = getPlayer.executeProcedure();
                                while(rsPlayer.next()){
                                    IPlayers player = new Players();
                                    player.setPlayerName(rsPlayer.getString("name"));
                                    player.setPosition(rsPlayer.getString("position"));
                                    player.setCaptain(rsPlayer.getBoolean("captain"));
                                    player.setAge(rsPlayer.getInt("age"));
                                    player.setSkating(rsPlayer.getInt("skating"));
                                    player.setShooting(rsPlayer.getInt("shooting"));
                                    player.setChecking(rsPlayer.getInt("checking"));
                                    player.setSaving(rsPlayer.getInt("saving"));
                                    player.setInjured(rsPlayer.getBoolean("injured"));
                                    player.setRetired(rsPlayer.getBoolean("retired"));
                                    player.setInjuredDays(rsPlayer.getInt("injury_days"));
                                    playerList.add(player);
                                }
                                team.setPlayers(playerList);
                                teamList.add(team);
                            }
                            division.setTeams(teamList);
                            divisionList.add(division);
                        }
                        conference.setDivisions(divisionList);
                        conferenceList.add(conference);
                    }
                    league.setConferences(conferenceList);

                    IGetStoredProcedure getFreeAgent = new GetFreeAgent(leagueId);
                    ResultSet rsFreeAgent = getFreeAgent.executeProcedure();
                    while(rsFreeAgent.next()){
                        IFreeAgents freeAgent = new FreeAgents();
                        freeAgent.setPlayerName(rsFreeAgent.getString("name"));
                        freeAgent.setPosition(rsFreeAgent.getString("position"));
                        freeAgent.setSkating(rsFreeAgent.getInt("skating"));
                        freeAgent.setShooting(rsFreeAgent.getInt("shooting"));
                        freeAgent.setChecking(rsFreeAgent.getInt("checking"));
                        freeAgent.setSaving(rsFreeAgent.getInt("saving"));
                        freeAgentList.add(freeAgent);
                    }
                    league.setFreeAgents(freeAgentList);

                    IGetStoredProcedure getFreeCoach = new GetFreeCoach(leagueId);
                    ResultSet rsFreeCoach = getFreeCoach.executeProcedure();
                    while(rsFreeCoach.next()){
                        IHeadCoach freeCoach = new HeadCoach();
                        freeCoach.setName(rsFreeCoach.getString("name"));
                        freeCoach.setSkating(rsFreeCoach.getDouble("skating"));
                        freeCoach.setShooting(rsFreeCoach.getDouble("shooting"));
                        freeCoach.setChecking(rsFreeCoach.getDouble("checking"));
                        freeCoach.setSaving(rsFreeCoach.getDouble("saving"));
                        freeCoachList.add(freeCoach);
                    }
                    league.setHeadCoach(freeCoachList);

//                    IGetStoredProcedure getFreeManager = new GetFreeManager(leagueId);
//                    ResultSet rsFreeManager = getFreeManager.executeProcedure();
//                    while(rsFreeManager.next()){
//                        String freeManager = rsFreeManager.getString("name");
//                        freeManagerList.add(freeManager);
//                    }
//                    league.setManager(freeManagerList);
                    return league;
                }
            }
        }
        return null;
    }
}

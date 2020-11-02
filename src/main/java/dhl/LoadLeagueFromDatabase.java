package dhl;

import dhl.database.*;
import dhl.gamePlayConfig.*;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

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
                            ArrayList<ITeam> teamList = new ArrayList<>();
                            int divisionId = rsDivision.getInt("id");
                            IDivision division = new Division("Metro", teamList);
                            division.setDivisionName(rsDivision.getString("name"));

                            IGetStoredProcedure getTeamInDivision = new GetAllTeamInDivision(divisionId);
                            ResultSet rsGetTeamInDivision = getTeamInDivision.executeProcedure();
                            while(rsGetTeamInDivision.next()){
                                ArrayList<IPlayers> playerList = new ArrayList<>();
                                int tId = rsGetTeamInDivision.getInt("id");
                                ITeam team = new Teams();
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

                    IGetStoredProcedure getFreeManager = new GetFreeManager(leagueId);
                    ResultSet rsFreeManager = getFreeManager.executeProcedure();
                    while(rsFreeManager.next()){
                        String freeManager = rsFreeManager.getString("name");
                        freeManagerList.add(freeManager);
                    }
                    league.setGeneralManager(freeManagerList);

                    IGetStoredProcedure getConfig = new GetConfig(leagueId);
                    ResultSet rsGetConfig = getConfig.executeProcedure();
                    IGamePlayConfig gamePlayConfig = new GamePlayConfig();
                    while(rsGetConfig.next()){
                        IAging aging = new Aging();
                        aging.setAverageRetirementAge(rsGetConfig.getInt("average_retirement_age"));
                        aging.setMaximumAge(rsGetConfig.getInt("maximum_age"));
                        gamePlayConfig.setAging(aging);
                        IGameResolver gameResolver = new GameResolver();
                        //gameResolver.setRandomWinChance(rsGetConfig.getDouble("random_win_chance"));
                        gamePlayConfig.setGameResolver(gameResolver);
                        IInjuries injuries = new Injuries();
                        injuries.setRandomInjuryChance(rsGetConfig.getDouble("random_injury_chance"));
                        injuries.setInjuryDaysLow(rsGetConfig.getInt("injury_days_low"));
                        injuries.setInjuryDaysHigh(rsGetConfig.getInt("injury_days_high"));
                        gamePlayConfig.setInjuries(injuries);
                        ITraining training = new Training();
                        training.setDaysUntilStatIncreaseCheck(rsGetConfig.getInt("days_until_stat_increase_check"));
                        gamePlayConfig.setTraining(training);
                        ITrading trading = new Trading();
                        trading.setLossPoint(rsGetConfig.getInt("loss_point"));
                        //trading.setRandomTradeOfferChance(rsGetConfig.getDouble("random_trade_offer_chance"));
                        trading.setMaxPlayersPerTrade(rsGetConfig.getInt("max_players_per_trade"));
                        //trading.setRandomAcceptanceChance(rsGetConfig.getDouble("random_acceptance_chance"));
                        gamePlayConfig.setTrading(trading);
                    }
                    league.setGameplayConfig(gamePlayConfig);

                    return league;
                }
            }
        }
        return null;
    }
}

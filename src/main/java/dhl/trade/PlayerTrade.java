package dhl.trade;

import dhl.inputOutput.UserOutput;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.TradePrompt;
import dhl.gamePlayConfig.GamePlayConfig;
import dhl.gamePlayConfig.IGamePlayConfig;
import dhl.gamePlayConfig.ITrading;
import dhl.gamePlayConfig.Trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerTrade implements IPlayerTrade{

    List<IPlayers> offeringTeamPositionPlayers;
    List<IPlayers> consideringTeamPlayers;
    List<IPlayers> offeringTeamPlayers;
    IGamePlayConfig gamePlayConfig;
    ITrading trading;
    private AddDropPlayers addDrop;
    TradePrompt prompt;
    private UserOutput userOutput;

    PlayerTrade(){
        offeringTeamPlayers = new ArrayList<>();
        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        addDrop = new AddDropPlayers();
        gamePlayConfig = new GamePlayConfig();
        trading = new Trading();
        prompt = new TradePrompt();
        userOutput = new UserOutput();
    }

    @Override
    public int countTeamPlayers(ITeam team) {
        int count =0;
        for(IPlayers p:team.getPlayers()){
            count++;
        }
        return count;
    }

    @Override
    public void TradeAi(ITeam offeringTeam, ITeam consideringTeam) {
        trading = gamePlayConfig.getTrading();
        double randomAcceptanceChance = trading.getRandomAcceptanceChance();
        double maxPlayersPerTrade = trading.getMaxPlayersPerTrade();
        int count = 0;
        int totalPlayersOfOfferingTeam;
        int totalPlayersOfConsideringTeam;

        outer:
        for (IPlayers offeredPlayer : offeringTeamPositionPlayers) {
            for (IPlayers tradePlayer : consideringTeamPlayers) {

                if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {
                    userOutput.setOutput("Rejected");
                    userOutput.sendOutput();
                    break outer;
                } else {
                    userOutput.setOutput("player eligible for dhl.trade");
                    userOutput.sendOutput();
                    count++;
                }
            }
        }
        if(count>0 && count<=maxPlayersPerTrade) {
            offeringTeam.getPlayers().removeAll(offeringTeamPlayers);
            offeringTeam.getPlayers().addAll(consideringTeamPlayers);
            consideringTeam.getPlayers().removeAll(consideringTeamPlayers);
            consideringTeam.getPlayers().addAll(offeringTeamPlayers);
        }
        offeringTeam.setLossPoints(0);

        totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
        totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);

        addDrop.addDropPlayers(offeringTeam,totalPlayersOfOfferingTeam);
        addDrop.addDropPlayers(consideringTeam,totalPlayersOfConsideringTeam);

    }

    @Override
    public void TradeUser(ITeam offeringTeam, ITeam consideringTeam) {

            int totalPlayersOfOfferingTeam;
            int totalPlayersOfConsideringTeam;
            String response;
            Scanner sc = new Scanner(System.in);
            userOutput.setOutput("User Players");
            userOutput.sendOutput();
            prompt.userAcceptRejectTrade(consideringTeamPlayers);
            userOutput.setOutput("AI Players");
            userOutput.sendOutput();
            prompt.userAcceptRejectTrade(offeringTeamPositionPlayers);

            while(true) {
                userOutput.setOutput("Do you accept the dhl.trade?(y/n)");
                userOutput.sendOutput();
                response = sc.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    offeringTeam.getPlayers().removeAll(offeringTeamPlayers);
                    offeringTeam.getPlayers().addAll(consideringTeamPlayers);
                    consideringTeam.getPlayers().removeAll(consideringTeamPlayers);
                    consideringTeam.getPlayers().addAll(offeringTeamPlayers);
                    break;

                }
                else if (response.equalsIgnoreCase("n")) {
                    userOutput.setOutput("Trade Rejected");
                    userOutput.sendOutput();
                    break;
                }
                else{
                    userOutput.setOutput("please answer with y or n");
                    userOutput.sendOutput();
                }
            }
            offeringTeam.setLossPoints(0);
            sc.close();

            totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
            totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);

            addDrop.addDropPlayers(offeringTeam,totalPlayersOfOfferingTeam);
            addDrop.addDropPlayers(consideringTeam,totalPlayersOfConsideringTeam);
        }

    }


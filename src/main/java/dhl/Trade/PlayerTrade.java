package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.Presentation.TradePrompt;
import dhl.gamePlayConfig.GamePlayConfig;
import dhl.gamePlayConfig.IGamePlayConfig;
import dhl.gamePlayConfig.Trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerTrade implements IPlayerTrade{

    List<IPlayers> offeringTeamPositionPlayers;
    List<IPlayers> consideringTeamPlayers;
    List<IPlayers> offeringTeamPlayers;
    IGamePlayConfig gamePlayConfig;
    Trading trading;
    private AddDropPlayers addDrop;
    TradePrompt prompt;

    PlayerTrade(){
        offeringTeamPlayers = new ArrayList<>();
        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        addDrop = new AddDropPlayers();
        gamePlayConfig = new GamePlayConfig();
        trading = new Trading();
        prompt = new TradePrompt();
    }

    @Override
    public int countTeamPlayers(ITeam2 team) {
        int count =0;
        for(IPlayers p:team.getPlayers()){
            count++;
        }
        return count;
    }

    @Override
    public void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam) {
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
                    System.out.println("Rejected");
                    break outer;
                } else {
                    System.out.println("player eligible for trade");
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
    public void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam) {

            int totalPlayersOfOfferingTeam;
            int totalPlayersOfConsideringTeam;
            String response;
            Scanner sc = new Scanner(System.in);
            System.out.println("User Players");
            prompt.userAcceptRejectTrade(consideringTeamPlayers);
            System.out.println("AI Players");
            prompt.userAcceptRejectTrade(offeringTeamPositionPlayers);

            while(true) {
                System.out.println("Do you accept the trade?(y/n)");
                response = sc.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    offeringTeam.getPlayers().removeAll(offeringTeamPlayers);
                    offeringTeam.getPlayers().addAll(consideringTeamPlayers);
                    consideringTeam.getPlayers().removeAll(consideringTeamPlayers);
                    consideringTeam.getPlayers().addAll(offeringTeamPlayers);
                    break;

                }
                else if (response.equalsIgnoreCase("n")) {
                    System.out.println("Trade Rejected");
                    break;
                }
                else{
                    System.out.println("please answer with y or n");
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


package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.ArrayList;
import java.util.List;

public class PlayerTrade implements IPlayerTrade{

    List<IPlayers> offeringTeamPositionPlayers;
    List<IPlayers> consideringTeamPlayers;
    List<IPlayers> offeringTeamPlayers;
    private AddDropPlayers addDrop;
    private double randomAcceptanceChance = 0.05;
    private int maxPlayersPerTrade = 2;

    PlayerTrade(){
        offeringTeamPlayers = new ArrayList<>();
        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        addDrop = new AddDropPlayers();
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
        int count = 0;
        int totalPlayersOfOfferingTeam = 0;
        int totalPlayersOfConsideringTeam = 0;

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

    }
}

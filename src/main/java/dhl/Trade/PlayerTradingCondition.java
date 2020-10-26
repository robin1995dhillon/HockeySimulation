package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class PlayerTradingCondition implements IPlayerTradingCondition{

    private ArrayList<ITeam2> team;
    private int pointsLoss = 8;
    private double randomTradeOfferChance=0.05;
    private int maxPlayersPerTrade = 2;
    private double randomAcceptanceChance = 0.05;
    double playerStrength;

    public PlayerTradingCondition(){
        team = new ArrayList<>();
    }


    @Override
    public double strength(IPlayers player) {

        if (player.getPosition().toLowerCase().equals("forward")) {
            playerStrength = player.getShooting() + player.getSkating() + player.getChecking() / 2.0;
        } else if (player.getPosition().toLowerCase().equals("defense")) {
            playerStrength = player.getSkating() + player.getChecking() + player.getShooting() / 2.0;
        } else {
            playerStrength = player.getSkating() + player.getSaving();
        }
        return playerStrength;
    }

    public List<IPlayers> getPositionTypesOffering(List<IPlayers> players){
        for(int i=1;i<players.size();i++){
            if(players.get(0).getPosition().equalsIgnoreCase(players.get(i).getPosition())){
                continue;
            }
            else{
                players.remove(i);
                i-=1;
            }
        }
        return players;
    }

//    public List<IPlayers2> getPositionTypesConsidering(String offeredPositionType,List<IPlayers2> consideredType){
//        for(int i=0;i<consideredType.size();i++){
//            if(consideredType.get(i).getPosition().equalsIgnoreCase(offeredPositionType)){
//                continue;
//            }
//            else{
//                consideredType.remove(i);
//            }
//        }
//            return consideredType;
//
//    }


    @Override
    public void tradeCondition(List<ITeam2> allTeams){

        for(int i=0; i<allTeams.size();i++){
            for(int j=0;j<allTeams.size();j++){
                if(i==j){
                    continue;
                }
                else{
                    if(allTeams.get(i).getTeamType().toLowerCase().equals("ai") && allTeams.get(i).getLossPoints() ==pointsLoss){
                        if(randomTradeOfferChance> Math.random()) {
                            TradeAi(allTeams.get(i),allTeams.get(j));
                        }
                    }
                }
            }
        }

    }


    @Override
    public List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam , int weakestCount) {

        List<IPlayers> players = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for(IPlayers weakPlayer: players){
            double playerStrength = strength(weakPlayer);
            weakPlayer.setStrength(playerStrength);

        }
        Collections.sort(players, (p1, p2) -> Double.compare(strength(p1),strength(p2)));


        return players.subList(0,weakestCount);

    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam, int weakestCount, String positionToTrade) {
        List<IPlayers> players = new ArrayList<>();
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();
        int count=0;

        for(IPlayers weakPlayer: players){
            if(weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
              //  double playerStrength = strength(weakPlayer);
              //  weakPlayer.setStrength(playerStrength);
                playersStrong.add(weakPlayer);
                count++;
            }
            else{
                continue;
            }
        }
        Collections.sort(playersStrong,Collections.reverseOrder((p1, p2) -> Double.compare(strength(p1),strength(p2))));

        if(count>weakestCount) {
            return players.subList(0, weakestCount);
        }
        else{
            return players.subList(0,count);
        }
    }

    @Override
    public void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam) {
        int count = 0;
//          List<ITeam2> teamsTrading = new ArrayList<>();
//          teamsTrading.add(offeringTeam);
//          teamsTrading.add(consideringTeam);
//          boolean flag = tradeCondition(teamsTrading);

    //    if (flag) {
            List<IPlayers> offeringTeamPlayers = new ArrayList<>();
            List<IPlayers> consideringTeamPlayers = new ArrayList<>();
            List<IPlayers> offeringTeamPositionPlayers = new ArrayList<>();
            List<IPlayers> consideringTeamPosition = new ArrayList<>();

            offeringTeamPlayers = checkWeakestPlayer(offeringTeam, maxPlayersPerTrade);
            offeringTeamPositionPlayers= getPositionTypesOffering(offeringTeamPlayers);
            String positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
            consideringTeamPlayers = checkStrongestPlayer(consideringTeam, maxPlayersPerTrade,positionToTrade); //strongest

            outer:
            for (IPlayers offeredPlayer : offeringTeamPositionPlayers) {
                for (IPlayers tradePlayer : consideringTeamPlayers) {

                    if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {
                        System.out.println("Rejected");
                        break outer;
                    } else {
                        System.out.println("player eligible for trade");
                     //   count++;
                    }
                }
            }
          //  if (count>0 && count <= maxPlayersPerTrade) {
                offeringTeam.getPlayers().removeAll(offeringTeamPlayers);
                offeringTeam.getPlayers().addAll(consideringTeamPlayers);
                consideringTeam.getPlayers().removeAll(consideringTeamPlayers);
                consideringTeam.getPlayers().addAll(offeringTeamPlayers);
//            } else {
//                System.out.println("Trade failed");
//            }

       // }
    }
}

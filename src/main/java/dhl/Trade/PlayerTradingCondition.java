package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.PlayersStrength;
import dhl.LeagueModel.teams.Teams;
import dhl.Presentation.TradePrompt;
import java.util.*;


class PlayerTradingCondition implements IPlayerTradingCondition{

    TradePrompt prompt = new TradePrompt();
    PlayersStrength playerStrength = new PlayersStrength();
    private ArrayList<ITeam2> team;
    private int lossPoints = 8;
    private double randomTradeOfferChance=0.05;
    private int maxPlayersPerTrade = 2;
    private double randomAcceptanceChance = 0.05;
    private double strongestPlayersStrength=0.0;
    private String positionToTrade = "";
    private Map<ITeam2,Double> map = new HashMap<>();
    private List<IPlayers> offeringTeamPlayers = new ArrayList<>();
    private List<IPlayers> consideringTeamPlayers = new ArrayList<>();
    private List<IPlayers> offeringTeamPositionPlayers = new ArrayList<>();
    private List<IPlayers> strongestPLayersFinalList = new ArrayList<>();
    private ITeam2 finalTeam = null;

    public PlayerTradingCondition(){
        team = new ArrayList<>();
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

    @Override
    public void tradeCondition(List<ITeam2> allTeams){


        for(int i=0; i<allTeams.size();i++){

                    if(allTeams.get(i).getTeamType().toLowerCase().equals("ai") && allTeams.get(i).getLossPoints() ==lossPoints){
                        if(randomTradeOfferChance> Math.random()) {
                            offeringTeamPlayers = checkWeakestPlayer(allTeams.get(i), maxPlayersPerTrade);
                            offeringTeamPositionPlayers= getPositionTypesOffering(offeringTeamPlayers);
                            positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
                            for(int j=0;j<allTeams.size();j++){
                                if(i==j){
                                    continue;
                                }
                                else{

                            consideringTeamPlayers = checkStrongestPlayer(allTeams.get(j),positionToTrade);//strongest
                           if(StrongestPlayersStrength(consideringTeamPlayers)>strongestPlayersStrength)
                           finalTeam = allTeams.get(j);
                           strongestPLayersFinalList = strongestPlayersSublist(maxPlayersPerTrade,consideringTeamPlayers);
                           // TradeAi(allTeams.get(i),allTeams.get(j));
                        }
                    }
                            if(finalTeam.getTeamType().equalsIgnoreCase("ai")) {
                                TradeAi(allTeams.get(i), finalTeam);
                            }
                            else{
                                TradeUser(allTeams.get(i), finalTeam);
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
            double strength = playerStrength.calculateStrength(weakPlayer);
            weakPlayer.setStrength(strength);

        }
        Collections.sort(players, (p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2)));


        return players.subList(0,weakestCount);

    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam,String positionToTrade) {
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
        Collections.sort(playersStrong,Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2))));

       return players;
    }

    public List<IPlayers> strongestPlayersSublist(int maxPlayersPerTrade,List<IPlayers>consideringTeamPlayers){

            return consideringTeamPlayers.subList(0, maxPlayersPerTrade);
        }


    @Override
    public double StrongestPlayersStrength(List<IPlayers> selectedPLayers){

        double strength = 0;
        for(IPlayers p: selectedPLayers){
            strength += p.getStrength();
        }
        return strength;
    }

//    @Override
//    public ITeam2 getTradeTeamName(Map<ITeam2,Double> allTeams){
//        ITeam2 teamName = new Teams();
//        double strength = 0;
//        for(Map.Entry<ITeam2,Double> m:allTeams.entrySet()){
//            if(m.getValue()>strength){
//                teamName = m.getKey();
//            }
//            else{
//                continue;
//            }
//
//        }
//        return teamName;
//
//    }

    @Override
    public void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam) {
        int count = 0;

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
    }

    @Override
    public void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam) {
        int count = 0;
        String response = "";
        Scanner sc = new Scanner(System.in);
        prompt.userAcceptRejectTrade(consideringTeamPlayers,offeringTeamPositionPlayers);
        System.out.println("Do you accept the trade?(y/n)");
        response = sc.nextLine();

        if(response.equalsIgnoreCase("y")) {
            offeringTeam.getPlayers().removeAll(offeringTeamPlayers);
            offeringTeam.getPlayers().addAll(consideringTeamPlayers);
            consideringTeam.getPlayers().removeAll(consideringTeamPlayers);
            consideringTeam.getPlayers().addAll(offeringTeamPlayers);
        }
        else{
            System.out.println("Trade Rejected");
            offeringTeam.setLossPoints(0);
        }
        sc.close();
    }
}

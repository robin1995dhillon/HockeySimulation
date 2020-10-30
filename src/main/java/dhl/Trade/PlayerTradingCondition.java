package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.PlayersStrength;
import dhl.Presentation.TradePrompt;

import java.util.*;


class PlayerTradingCondition implements IPlayerTradingCondition{

    TradePrompt prompt = new TradePrompt();
    PlayersStrength playerStrength;
    private ArrayList<ITeam2> team;
    private int lossPoints = 8;
    private double randomTradeOfferChance=0.05;
    private int maxPlayersPerTrade = 2;
    private double randomAcceptanceChance = 0.05;
    private double strongestPlayersStrength=0.0;
    private String positionToTrade = "";
    private Map<ITeam2,Double> map;
    private List<IPlayers> offeringTeamPlayers;
    private List<IPlayers> consideringTeamPlayers;
    private List<IPlayers> offeringTeamPositionPlayers;
    private List<IPlayers> strongestPLayersFinalList;
    private ITeam2 finalTeam = null;
    private FreeAgentList freeAgentLists;
    private FreeAgentListDrop freeAgentListsDrop;

    public PlayerTradingCondition(){
        team = new ArrayList<>();
        map = new HashMap<>();

        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        strongestPLayersFinalList = new ArrayList<>();
        playerStrength = new PlayersStrength();
        freeAgentLists = new FreeAgentList();
        freeAgentListsDrop = new FreeAgentListDrop();
    }

    @Override
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

        for(int i = 0;i < allTeams.size();i++){

                    if(allTeams.get(i).getTeamType().toLowerCase().equals("ai") && allTeams.get(i).getLossPoints() ==lossPoints){
                        if(randomTradeOfferChance> Math.random()) {
                            offeringTeamPlayers = checkWeakestPlayer(allTeams.get(i));
                            offeringTeamPositionPlayers= getPositionTypesOffering(offeringTeamPlayers);
                            positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
                            for(int j = 0;j < allTeams.size();j++){
                                if(i==j){
                                    continue;
                                }
                                else{

                            consideringTeamPlayers = checkStrongestPlayer(allTeams.get(j),positionToTrade);
                           if(StrongestPlayersStrength(consideringTeamPlayers)>strongestPlayersStrength)
                           finalTeam = allTeams.get(j);
                          // strongestPLayersFinalList = strongestPlayersSublist(maxPlayersPerTrade,consideringTeamPlayers);
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
    public List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam) {
        List<IPlayers> players = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for(IPlayers weakPlayer: players){
            double strength = playerStrength.calculateStrength(weakPlayer);
            weakPlayer.setStrength(strength);

        }
        players.sort((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));


        return players.subList(0,maxPlayersPerTrade);

    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam,String positionToTrade) {
        List<IPlayers> players = new ArrayList<>();
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();
        int count=0;

        for(IPlayers weakPlayer: players){
            if(weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                playersStrong.add(weakPlayer);
                count++;
            }
        }
        playersStrong.sort(Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2))));

       return playersStrong;
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

    @Override
    public int countTeamPlayers(ITeam2 team) {
       int count =0;
       for(IPlayers p:team.getPlayers()){
           count++;
       }
       return count;
    }

    @Override
    public void addDropPlayers(ITeam2 team, int totalPlayers){
        int playersToBeAdded = 0;
        int playersToBeDropped = 0;

        if(totalPlayers<20){
            playersToBeAdded = 20 - totalPlayers;

            freeAgentLists.aiAgentListAdd(team,playersToBeAdded);
        }
        else if(totalPlayers>20){

            playersToBeDropped = totalPlayers - 20;
            freeAgentListsDrop.agentListDrop(team,playersToBeDropped);
        }
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

        addDropPlayers(offeringTeam,totalPlayersOfOfferingTeam);
        addDropPlayers(consideringTeam,totalPlayersOfConsideringTeam);

    }

    @Override
    public void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam) {
        int totalPlayersOfOfferingTeam = 0;
        int totalPlayersOfConsideringTeam = 0;
        String response = "";
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

        addDropPlayers(offeringTeam,totalPlayersOfOfferingTeam);
        addDropPlayers(consideringTeam,totalPlayersOfConsideringTeam);
    }
}

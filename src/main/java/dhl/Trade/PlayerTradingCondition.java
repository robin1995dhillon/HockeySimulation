package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.PlayersStrength;
import dhl.Presentation.TradePrompt;
import dhl.gamePlayConfig.GamePlayConfig;
import dhl.gamePlayConfig.IGamePlayConfig;
import dhl.gamePlayConfig.ITrading;
import dhl.gamePlayConfig.Trading;

import java.util.*;


class PlayerTradingCondition implements IPlayerTradingCondition{

    PlayersStrength playerStrength;
    StrongestWeakestPlayers strongestWeakestPlayers;
    ITrading trading;
    IGamePlayConfig gamePlayConfig;
    private double strongestPlayersStrength=0.0;
    private String positionToTrade = "";
    private List<IPlayers> offeringTeamPlayers;
    private List<IPlayers> consideringTeamPlayers;
    private List<IPlayers> offeringTeamPositionPlayers;
    private ITeam2 finalTeam = null;
    private PlayerTrade playerTrade;

    public PlayerTradingCondition(){

        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        playerStrength = new PlayersStrength();
        strongestWeakestPlayers = new StrongestWeakestPlayers();
        playerTrade = new PlayerTrade();
        trading = new Trading();
        gamePlayConfig = new GamePlayConfig();
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
        trading = gamePlayConfig.getTrading();
        int lossPoints = trading.getLossPoint();
        double randomTradeOfferChance = trading.getRandomTradeOfferChance();
        for(int i = 0;i < allTeams.size();i++){

                    if(allTeams.get(i).getTeamType().toLowerCase().equals("ai") && allTeams.get(i).getLossPoints() ==lossPoints){
                        if(randomTradeOfferChance> Math.random()) {
                            offeringTeamPlayers = strongestWeakestPlayers.checkWeakestPlayer(allTeams.get(i));
                            offeringTeamPositionPlayers= getPositionTypesOffering(offeringTeamPlayers);
                            positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
                            for(int j = 0;j < allTeams.size();j++){
                                if(i==j){
                                    continue;
                                }
                                else{

                            consideringTeamPlayers = strongestWeakestPlayers.checkStrongestPlayer(allTeams.get(j),positionToTrade);
                           if(strongestWeakestPlayers.StrongestPlayersStrength(consideringTeamPlayers)>strongestPlayersStrength)
                           finalTeam = allTeams.get(j);
                        }
                    }
                            if(finalTeam.getTeamType().equalsIgnoreCase("ai")) {
                                playerTrade.TradeAi(allTeams.get(i), finalTeam);
                            }
                            else{
                                playerTrade.TradeUser(allTeams.get(i), finalTeam);
                            }
                }
            }
        }

    }

    @Override
    public List<IPlayers> offeringTeamPlayersList(){
        return offeringTeamPlayers;
    }

    @Override
    public List<IPlayers> offeringTeamPositionPlayersList(){
        return offeringTeamPositionPlayers;
    }

    @Override
    public List<IPlayers> consideringTeamPlayersList(){
        return consideringTeamPlayers;
    }

}

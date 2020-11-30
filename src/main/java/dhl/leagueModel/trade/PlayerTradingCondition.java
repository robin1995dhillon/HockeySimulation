package dhl.leagueModel.trade;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.Players;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.StateMachine;
import dhl.stateMachineNew.StateMachineAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayerTradingCondition implements IPlayerTradingCondition {

    IPlayers playerStrength;
    IStrongestWeakestPlayers strongestWeakestPlayers;
    ITrading trading;



    IGamePlayConfig gamePlayConfig;
    private double strongestPlayersStrength = 0.0;
    private String positionToTrade = "";
    private List<IPlayers> offeringTeamPlayers;
    private List<IPlayers> consideringTeamPlayers;
    private List<IPlayers> offeringTeamPositionPlayers;
    private ITeam finalTeam = null;
    private IPlayerTrade playerTrade;
    private StateMachine stateMachine;

    public PlayerTradingCondition() {
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        consideringTeamPlayers = new ArrayList<>();
        offeringTeamPlayers = new ArrayList<>();
        offeringTeamPositionPlayers = new ArrayList<>();
        playerStrength = new Players();
        strongestWeakestPlayers = new StrongestWeakestPlayers();
        playerTrade = new PlayerTrade();
        trading = new Trading();
    }


    @Override
    public List<IPlayers> getPositionTypesOffering(List<IPlayers> players) {
        for (int i = 1; i < players.size(); i++) {
            if (players.get(0).getPosition().equalsIgnoreCase(players.get(i).getPosition())) {
                continue;
            } else {
                players.remove(i);
                i -= 1;
            }
        }
        return players;
    }

    @Override
    public void tradeCondition(List<ITeam> allTeams, IGamePlayConfig gamePlayConfiguration) {

        this.gamePlayConfig = gamePlayConfiguration;
        trading = gamePlayConfig.getTrading();
        int lossPoints = trading.getLossPoint();
        double randomTradeOfferChance = trading.getRandomTradeOfferChance();
        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println(allTeams.get(i).getLossPoints()+" ----loss point for team :"+allTeams.get(i).getTeamName());
            if (allTeams.get(i).getTeamType().toLowerCase().equals(Configurables.AI.getAction()) && allTeams.get(i).getLossPoints() >= lossPoints) {
                if (randomTradeOfferChance > Math.random()) {
                    offeringTeamPlayers = strongestWeakestPlayers.checkWeakestPlayer(allTeams.get(i), gamePlayConfig);
                    offeringTeamPositionPlayers = getPositionTypesOffering(offeringTeamPlayers);
                    stateMachine.setOfferingTeamPositionPlayers(offeringTeamPositionPlayers);
                    positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
                    System.out.println("offering team sizessssssss is : "+allTeams.get(i).getPlayers().size());
                    for (int j = 0; j < allTeams.size(); j++) {
                        if (i == j) {
                            System.out.println("offering team size is : "+allTeams.get(i).getPlayers().size());
                            continue;
                        } else {
                            System.out.println("size of team is : "+allTeams.get(j).getPlayers().size());
                            System.out.println("size of offering team is : "+offeringTeamPositionPlayers.size());
                            consideringTeamPlayers = strongestWeakestPlayers.checkStrongestPlayer(allTeams.get(j), positionToTrade, offeringTeamPositionPlayers.size());
                            stateMachine.setConsideringTeamPlayers(consideringTeamPlayers);
                            if (strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers) > strongestPlayersStrength) {
                                strongestPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers);
                                finalTeam = allTeams.get(j);
                            }
                        }
                    }
                    if (finalTeam.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
                        playerTrade.tradeAi(allTeams.get(i), finalTeam, gamePlayConfig);
                    } else {
                        playerTrade.tradeUser(allTeams.get(i), finalTeam, gamePlayConfig);
                    }
                }
            }
        }

    }

    @Override
    public List<IPlayers> offeringTeamPlayersList() {
        return offeringTeamPlayers;
    }

    @Override
    public List<IPlayers> offeringTeamPositionPlayersList() {
        return offeringTeamPositionPlayers;
    }

    @Override
    public List<IPlayers> consideringTeamPlayersList() {
        return consideringTeamPlayers;
    }

}

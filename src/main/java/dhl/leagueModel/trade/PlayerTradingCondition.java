package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
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
        playerStrength = LeagueModelAbstractFactory.instance().getPlayers();
        strongestWeakestPlayers = LeagueModelAbstractFactory.instance().getStrongestWeakestPlayers();
        playerTrade = LeagueModelAbstractFactory.instance().getPlayerTrade();
        trading = LeagueModelAbstractFactory.instance().getGamePlayConfig().getTrading();
    }


    @Override
    public List<IPlayers> getPositionTypesOffering(List<IPlayers> players) {
        List<IPlayers> positionOfferingList = new ArrayList<>();
        for (IPlayers player : players) {
            positionOfferingList.add(player);
        }
        for (int i = 1; i < positionOfferingList.size(); i++) {
            if (positionOfferingList.get(0).getPosition().equalsIgnoreCase(positionOfferingList.get(i).getPosition())) {
                continue;
            } else {
                System.out.println(" position removed are : " + positionOfferingList.get(i).getPosition() + "--- name is : " + positionOfferingList.get(i).getPlayerName());

                positionOfferingList.remove(i);
                i -= 1;
            }
        }
        return positionOfferingList;
    }

    @Override
    public void tradeCondition(List<ITeam> allTeams, IGamePlayConfig gamePlayConfiguration) {

        this.gamePlayConfig = gamePlayConfiguration;
        trading = gamePlayConfig.getTrading();
        int lossPoints = trading.getLossPoint();
        double randomTradeOfferChance = trading.getRandomTradeOfferChance();
        for (int i = 0; i < allTeams.size(); i++) {
            if (allTeams.get(i).getTeamType().toLowerCase().equals(Configurables.AI.getAction()) && allTeams.get(i).getLossPoints() >= lossPoints) {
                if (randomTradeOfferChance > Math.random()) {
                    offeringTeamPlayers = strongestWeakestPlayers.checkWeakestPlayer(allTeams.get(i), gamePlayConfig);
                    offeringTeamPositionPlayers = getPositionTypesOffering(offeringTeamPlayers);
                    stateMachine.setOfferingTeamPositionPlayers(offeringTeamPositionPlayers);
                    positionToTrade = offeringTeamPositionPlayers.get(0).getPosition();
                    for (int j = 0; j < allTeams.size(); j++) {
                        if (i == j) {
                            continue;
                        } else {
                            consideringTeamPlayers = strongestWeakestPlayers.checkStrongestPlayer(allTeams.get(j), positionToTrade, offeringTeamPositionPlayers.size());
                            if (strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers) > strongestPlayersStrength) {
                                strongestPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers);
                                finalTeam = allTeams.get(j);
                                consideringTeamPlayers = strongestWeakestPlayers.checkStrongestPlayer(finalTeam, positionToTrade, offeringTeamPositionPlayers.size());
                                stateMachine.setConsideringTeamPlayers(consideringTeamPlayers);
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

}

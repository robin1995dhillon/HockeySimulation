package dhl.leagueModel.trade;

import dhl.Configurables;
import dhl.presentation.inputOutput.IUserInput;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.UserInput;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;
import dhl.stateMachine.StateMachine;
import dhl.stateMachine.StateMachineAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerTrade implements IPlayerTrade {
    private static final Logger logger = LogManager.getLogger(PlayerTrade.class);
    List<IPlayers> offeringTeamPositionPlayers;
    List<IPlayers> consideringTeamPlayers;
    private IStrongestWeakestPlayers strongestWeakestPlayers;
    IGamePlayConfig gamePlayConfig;
    ITrading trading;
    private IAddDropPlayers addDrop;
    ITradePrompt prompt;
    private IUserOutput userOutput;
    private IUserInput userInput;
    private StateMachine stateMachine;

    public PlayerTrade() {
        strongestWeakestPlayers = LeagueModelAbstractFactory.instance().getStrongestWeakestPlayers();
        trading = LeagueModelAbstractFactory.instance().getGamePlayConfig().getTrading();
        addDrop = LeagueModelAbstractFactory.instance().getAddDropPlayers();
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        prompt = new TradePrompt();
        userOutput = new UserOutput();
        userInput = new UserInput();
    }


    @Override
    public int countTeamPlayers(ITeam team) {
        int count = 0;
        for (IPlayers player : team.getPlayers()) {
            count = count + 1;
        }
        return count;
    }

    @Override
    public void tradeAi(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig) {
        this.offeringTeamPositionPlayers = stateMachine.getOfferingTeamPositionPlayers();
        List<IPlayers> playersList = new ArrayList<>();
        playersList.addAll(this.offeringTeamPositionPlayers);
        this.consideringTeamPlayers = stateMachine.getConsideringTeamPlayers();

        double consideringTeamPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers);
        double offeringTeamPositionPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(offeringTeamPositionPlayers);
        this.gamePlayConfig = gamePlayConfig;
        trading = this.gamePlayConfig.getTrading();
        double randomAcceptanceChance = trading.getRandomAcceptanceChance();
        int totalPlayersOfOfferingTeam;
        int totalPlayersOfConsideringTeam;

        if (consideringTeamPlayersStrength > offeringTeamPositionPlayersStrength && Math.random() < randomAcceptanceChance) {

            addPlayersToTeam(consideringTeam.getPlayers(), new ArrayList<>(playersList));
            dropPlayersFromTeam(consideringTeam.getPlayers(), new ArrayList<>(this.consideringTeamPlayers));
            addPlayersToTeam(offeringTeam.getPlayers(), new ArrayList<>(this.consideringTeamPlayers));
            dropPlayersFromTeam(offeringTeam.getPlayers(), new ArrayList<>(playersList));
        }
        offeringTeam.setLossPoints(0);

        totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
        totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);

        addDrop.addDropPlayers(offeringTeam, totalPlayersOfOfferingTeam);
        addDrop.addDropPlayers(consideringTeam, totalPlayersOfConsideringTeam);

    }

    private void dropPlayersFromTeam(List<IPlayers> players, ArrayList<IPlayers> playersRemove) {
        OUTER:
        for (IPlayers removePlayer : playersRemove) {
            for (Iterator<IPlayers> iterator = players.iterator(); iterator.hasNext(); ) {

                IPlayers player = iterator.next();

                if (player.getPlayerName().equalsIgnoreCase(removePlayer.getPlayerName())) {
                    iterator.remove();
                    continue OUTER;
                }
            }

        }

    }

    public void addPlayersToTeam(List<IPlayers> teamPlayers, List<IPlayers> playersAdd) {

        for (IPlayers players : playersAdd) {
            teamPlayers.add(players);
        }


    }

    @Override
    public void tradeUser(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig) {
        this.offeringTeamPositionPlayers = stateMachine.getOfferingTeamPositionPlayers();
        List<IPlayers> playersList = new ArrayList<>();
        playersList.addAll(this.offeringTeamPositionPlayers);
        this.gamePlayConfig = gamePlayConfig;
        int totalPlayersOfOfferingTeam;
        int totalPlayersOfConsideringTeam;
        String response;
        userOutput.setOutput("User Players");
        userOutput.sendOutput();
        prompt.userAcceptRejectTrade(this.consideringTeamPlayers);
        userOutput.setOutput("AI Players");
        userOutput.sendOutput();
        prompt.userAcceptRejectTrade(this.offeringTeamPositionPlayers);

        while (true) {
            userOutput.setOutput("Do you accept the trade?(y/n)");
            userOutput.sendOutput();
            userInput.setInput();
            response = userInput.getInput();
            if (response.equalsIgnoreCase(Configurables.YES.getAction())) {
                addPlayersToTeam(consideringTeam.getPlayers(), new ArrayList<>(playersList));
                dropPlayersFromTeam(consideringTeam.getPlayers(), new ArrayList<>(this.consideringTeamPlayers));
                addPlayersToTeam(offeringTeam.getPlayers(), new ArrayList<>(this.consideringTeamPlayers));
                dropPlayersFromTeam(offeringTeam.getPlayers(), new ArrayList<>(playersList));
                break;

            } else if (response.equalsIgnoreCase(Configurables.NO.getAction())) {
                userOutput.setOutput("Trade Rejected");
                userOutput.sendOutput();
                break;
            } else {
                userOutput.setOutput("please answer with y or n");
                userOutput.sendOutput();
            }
        }
        offeringTeam.setLossPoints(0);

        totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
        totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);

        addDrop.addDropPlayers(offeringTeam, totalPlayersOfOfferingTeam);
        addDrop.addDropPlayers(consideringTeam, totalPlayersOfConsideringTeam);
    }

}


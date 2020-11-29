package dhl.leagueModel.trade;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.ITradePrompt;
import dhl.presentation.TradePrompt;
import dhl.stateMachineNew.StateMachine;
import dhl.stateMachineNew.StateMachineAbstractFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerTrade implements IPlayerTrade {

    List<IPlayers> offeringTeamPositionPlayers;
    List<IPlayers> consideringTeamPlayers;
    private IStrongestWeakestPlayers strongestWeakestPlayers;
    IGamePlayConfig gamePlayConfig;
    ITrading trading;
    private IAddDropPlayers addDrop;
    IPlayerTradingCondition playerTradingCondition;
    ITradePrompt prompt;
    private IUserOutput userOutput;
    private IUserInput userInput;
    private StateMachine stateMachine;

    PlayerTrade() {
       // playerTradingCondition = new PlayerTradingCondition();
        //offeringTeamPlayers = new ArrayList<>();
        stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        strongestWeakestPlayers = LeagueModelAbstractFactory.instance().getStrongestWeakestPlayers();
        addDrop = new AddDropPlayers();
        gamePlayConfig = new GamePlayConfig();
        trading = new Trading();
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

        for(IPlayers player : offeringTeamPositionPlayers){
            System.out.println("offering pos players : "+player.getPlayerName()+"---"+player.getPosition());
        }
        for(IPlayers player : consideringTeamPlayers){
            System.out.println("considering pos players : "+player.getPlayerName()+"---"+player.getPosition());
        }

        double consideringTeamPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(consideringTeamPlayers);
        double offeringTeamPositionPlayersStrength = strongestWeakestPlayers.strongestPlayersStrength(offeringTeamPositionPlayers);
        this.gamePlayConfig = gamePlayConfig;
        trading = this.gamePlayConfig.getTrading();
        double randomAcceptanceChance = trading.getRandomAcceptanceChance();
        double maxPlayersPerTrade = trading.getMaxPlayersPerTrade();
        int count = 0;
        int totalPlayersOfOfferingTeam;
        int totalPlayersOfConsideringTeam;

        totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
        System.out.println("----------- players of offering team BEFORE SWAP-----"+totalPlayersOfOfferingTeam);
        totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);
        System.out.println("----------- players of considering team BEFORE SWAP----------"+totalPlayersOfConsideringTeam);

//        outer:
//        for (IPlayers offeredPlayer : this.offeringTeamPositionPlayers) {
//            for (IPlayers tradePlayer : this.consideringTeamPlayers) {
//
//                if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {
//                    userOutput.setOutput("Rejected");
//                    userOutput.sendOutput();
//                    break outer;
//                } else {
//                    userOutput.setOutput("player eligible for trade");
//                    userOutput.sendOutput();
//                    //count++;
//                }
//            }
//            count++;
//
//        }
       // count = 1;
        //&& Math.random() < randomAcceptanceChance
        if (consideringTeamPlayersStrength > offeringTeamPositionPlayersStrength ) {
//            Iterator<IPlayers> iterator = this.offeringTeamPositionPlayers.iterator();
//            while (iterator.hasNext()) {
//                IPlayers player = iterator.next();
//                iterator.remove();
//            }
            addPlayersToTeam(consideringTeam.getPlayers() , new ArrayList<>(playersList), new ArrayList<>(this.consideringTeamPlayers));
            addPlayersToTeam(offeringTeam.getPlayers() , new ArrayList<>(this.consideringTeamPlayers), new ArrayList<>(playersList));
            //consideringTeam.getPlayers().addAll(this.offeringTeamPositionPlayers);
            //consideringTeam.getPlayers().removeAll(this.consideringTeamPlayers);
            //offeringTeam.getPlayers().removeAll(this.offeringTeamPositionPlayers);
            //offeringTeam.getPlayers().addAll(this.consideringTeamPlayers);
            for(IPlayers player : consideringTeam.getPlayers()){
                System.out.println("considering players are : "+player.getPlayerName());
            }

            for(IPlayers player : offeringTeam.getPlayers()){
                System.out.println("offering players are : "+player.getPlayerName());
            }

        }
        offeringTeam.setLossPoints(0);

        totalPlayersOfOfferingTeam = countTeamPlayers(offeringTeam);
        System.out.println("----------- players of offering team "+totalPlayersOfOfferingTeam);
        totalPlayersOfConsideringTeam = countTeamPlayers(consideringTeam);
        System.out.println("----------- players of considering team "+totalPlayersOfConsideringTeam);

        addDrop.addDropPlayers(offeringTeam, totalPlayersOfOfferingTeam);
        addDrop.addDropPlayers(consideringTeam, totalPlayersOfConsideringTeam);

    }

    public void addPlayersToTeam(List<IPlayers> teamPlayers , List<IPlayers> playersAdd, List<IPlayers> playersRemove){
         for(IPlayers players : playersAdd){
            teamPlayers.add(players);
        }
        for(IPlayers players : playersRemove){
            teamPlayers.remove(players);
        }
//        team.getPlayers().addAll(playersAdd);
//        team.getPlayers().removeAll(playersRemove);

    }

    @Override
    public void tradeUser(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig) {
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
                offeringTeam.getPlayers().removeAll(this.offeringTeamPositionPlayers);
                offeringTeam.getPlayers().addAll(this.consideringTeamPlayers);
                consideringTeam.getPlayers().removeAll(this.consideringTeamPlayers);
                consideringTeam.getPlayers().addAll(this.offeringTeamPositionPlayers);
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


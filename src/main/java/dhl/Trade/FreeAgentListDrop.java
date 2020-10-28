package dhl.Trade;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.players.PlayersStrength;
import dhl.Presentation.TradePrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class FreeAgentListDrop implements iFreeAgentListDrop{

    private PlayersStrength playerStrength;
    private FreeAgents agents;
    private List<IFreeAgents> availableAgents;
    private Players playerToDrop;
    private TradePrompt prompt;
    private FreeAgentList freeAgent;


    FreeAgentListDrop(){
        agents = new FreeAgents();
        availableAgents = new ArrayList<>();
        playerToDrop = new Players();
        playerStrength = new PlayersStrength();
        prompt = new TradePrompt();
        freeAgent = new FreeAgentList();
    }

    @Override
    public void agentListDrop(ITeam2 team, int playersToBeDropped) {
        int goalieCount=0;
        for(IPlayers p:team.getPlayers()){
            if(p.getPosition().equalsIgnoreCase("goalie")) {
                goalieCount++;
            }
        }
        if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("ai")){
            dropSkaterAi(team.getPlayers(),playersToBeDropped);
        }
        else if(goalieCount>2 && team.getTeamType().equalsIgnoreCase("ai")){
            dropGoalieAi(team.getPlayers(),goalieCount);
        }
        else if(goalieCount==2 && team.getTeamType().equalsIgnoreCase("user")){

            dropSkaterUser(team.getPlayers(),playersToBeDropped);
        }

        else if(goalieCount>2 && team.getTeamType().equalsIgnoreCase("user")){

            dropGoalieUser(team.getPlayers(), goalieCount);
        }



    }

    @Override
    public void dropSkaterAi(List<IPlayers> players, int playersToBeDropped) {
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        playerList = sortedPLayerSkaterList(players,playersToBeDropped);

        for(IPlayers p: playerList){
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);

        }

    }

    @Override
    public void dropGoalieAi(List<IPlayers> players, int goalieCount) {

        int goaliesToBeDropped =goalieCount - 2;
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> goalieList = new ArrayList<>();
        goalieList = sortedPLayerGoalieList(players,goaliesToBeDropped);
        for(IPlayers p: goalieList){
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);

        }

    }

    public List<IPlayers> sortedPLayerSkaterList(List<IPlayers> players, int playersToBeDropped){
        List<IPlayers> playerSkaterList = new ArrayList<>();
        for(IPlayers p: players){
            if(p.getPosition().equalsIgnoreCase("goalie")){
                continue;
            }
            else{
                playerSkaterList.add(p);
            }
        }
        Collections.sort(playerSkaterList,(p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2)));
        return playerSkaterList.subList(0,playersToBeDropped);
    }

    public List<IPlayers> sortedPLayerGoalieList(List<IPlayers> players,int goaliesToBeDropped){
        List<IPlayers> playerGoalieList = new ArrayList<>();
        for(IPlayers p: players){
            if(p.getPosition().equalsIgnoreCase("goalie")){
                playerGoalieList.add(p);
            }

        }
        Collections.sort(playerGoalieList,(p1, p2) -> Double.compare(playerStrength.calculateStrength(p1),playerStrength.calculateStrength(p2)));
        return playerGoalieList.subList(0,goaliesToBeDropped);
    }

    @Override
    public void dropSkaterUser(List<IPlayers> player, int playersToBeDropped) {

        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String playerDropName = "";
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();

        playerList = freeAgent.strongestPlayersList(player);

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeDropped != 0) {
            System.out.println("Enter Player name To drop");
            playerDropName = sc.nextLine();

            for (IPlayers p : playerList) {
                if(p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                if (p.getPosition().equalsIgnoreCase("goalie")) {
                    System.out.println("Cannot select goalie");
                    flag = true;

                } else {
                    playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
                    player.remove(p);
                    playersToBeDropped--;
                    availableAgents.add(playerToAgent);
                    flag = false;
                    break;
                }
                }
            }

        if (flag) {
            System.out.println("invalid! try again");
        }
    }
        sc.close();
        }


    @Override
    public void dropGoalieUser(List<IPlayers> player, int goalieCount) {

        int playersToBeDropped =goalieCount - 2;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        String playerDropName = "";
        IFreeAgents playerToAgent = new FreeAgents();
        List<IPlayers> playerList = new ArrayList<>();
        List<IFreeAgents> agentList = new ArrayList<>();

        playerList = freeAgent.strongestPlayersList(player);

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeDropped != 0) {
            System.out.println("Enter Player name To drop");
            playerDropName = sc.nextLine();

            for (IPlayers p : playerList) {
                if(p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (p.getPosition().equalsIgnoreCase("goalie")) {

                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
                        player.remove(p);
                        playersToBeDropped--;
                        availableAgents.add(playerToAgent);
                        flag = false;
                        break;
                    }
                }
                    else{
                        flag = true;
                    }
                }


            if (flag) {
                System.out.println("invalid! try again");
            }
        }

        sc.close();
    }

}

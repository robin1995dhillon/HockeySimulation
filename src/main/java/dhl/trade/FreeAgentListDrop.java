package dhl.trade;

import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.Configurables;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.presentation.TradePrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FreeAgentListDrop implements iFreeAgentListDrop {

    private IPlayers playerStrength;
    private List<IFreeAgents> availableAgents;
    private IPlayers playerToDrop;
    private TradePrompt prompt;
    private FreeAgentList freeAgent;
    private UserOutput userOutput;
    private UserInput userInput;


    FreeAgentListDrop() {

        availableAgents = new ArrayList<>();
        playerToDrop = new Players();
        playerStrength = new Players();
        prompt = new TradePrompt();
        freeAgent = new FreeAgentList();
        userOutput = new UserOutput();
        userInput = new UserInput();
    }

    @Override
    public void agentListDrop(ITeam team, int playersToBeDropped) {
        int goalieCount = 0;
        for (IPlayers p : team.getPlayers()) {
            if (p.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                goalieCount++;
            }
        }
        if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            dropSkaterAi(team.getPlayers(), playersToBeDropped);
        } else if (goalieCount > 2 && team.getTeamType().equalsIgnoreCase(Configurables.AI.getAction())) {
            dropGoalieAi(team.getPlayers(), goalieCount);
        } else if (goalieCount == 2 && team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            dropSkaterUser(team.getPlayers(), playersToBeDropped);
        } else if (goalieCount > 2 && team.getTeamType().equalsIgnoreCase(Configurables.USER.getAction())) {
            dropGoalieUser(team.getPlayers(), goalieCount);
        }


    }

    @Override
    public void dropSkaterAi(List<IPlayers> players, int playersToBeDropped) {
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;
        playerList = sortedPLayerSkaterList(players, playersToBeDropped);

        for (IPlayers p : playerList) {
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);
        }
    }

    @Override
    public void dropGoalieAi(List<IPlayers> players, int goalieCount) {

        int goaliesToBeDropped = goalieCount - 2;
        IFreeAgents playerToAgent;
        List<IPlayers> goalieList;
        goalieList = sortedPLayerGoalieList(players, goaliesToBeDropped);
        for (IPlayers p : goalieList) {
            players.remove(p);
            playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
            availableAgents.add(playerToAgent);
        }
    }

    @Override
    public List<IPlayers> sortedPLayerSkaterList(List<IPlayers> players, int playersToBeDropped) {
        List<IPlayers> playerSkaterList = new ArrayList<>();
        for (IPlayers p : players) {
            if (p.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                continue;
            } else {
                playerSkaterList.add(p);
            }
        }
        Collections.sort(playerSkaterList, (p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));
        return playerSkaterList.subList(0, playersToBeDropped);
    }

    @Override
    public List<IPlayers> sortedPLayerGoalieList(List<IPlayers> players, int goaliesToBeDropped) {
        List<IPlayers> playerGoalieList = new ArrayList<>();
        for (IPlayers p : players) {
            if (p.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                playerGoalieList.add(p);
            }
        }
        Collections.sort(playerGoalieList, (p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));
        return playerGoalieList.subList(0, goaliesToBeDropped);
    }

    @Override
    public void dropSkaterUser(List<IPlayers> player, int playersToBeDropped) {

        boolean flag = false;
        String playerDropName;
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(player);

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeDropped != 0) {
            userOutput.setOutput("Enter Player name To drop");
            userOutput.sendOutput();
            userInput.setInput();
            playerDropName = userInput.getInput();
            for (IPlayers p : playerList) {
                if (p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (p.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {
                        userOutput.setOutput("Cannot select goalie");
                        userOutput.sendOutput();
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
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
    }


    @Override
    public void dropGoalieUser(List<IPlayers> player, int goalieCount) {

        int playersToBeDropped = goalieCount - 2;
        boolean flag = false;
        String playerDropName;
        IFreeAgents playerToAgent;
        List<IPlayers> playerList;

        playerList = freeAgent.strongestPlayersList(player);

        prompt.userAcceptRejectTrade(playerList);

        while (playersToBeDropped != 0) {
            userOutput.setOutput("Enter Player name To drop");
            userOutput.sendOutput();
            userInput.setInput();
            playerDropName = userInput.getInput();
            for (IPlayers p : playerList) {
                if (p.getPlayerName().equalsIgnoreCase(playerDropName)) {
                    if (p.getPosition().equalsIgnoreCase(Configurables.GOALIE.getAction())) {

                        playerToAgent = playerToDrop.convertPlayerToFreeAgent(p);
                        player.remove(p);
                        playersToBeDropped--;
                        availableAgents.add(playerToAgent);
                        flag = false;
                        break;
                    }
                } else {
                    flag = true;
                }
            }
            if (flag) {
                userOutput.setOutput("invalid! try again");
                userOutput.sendOutput();
            }
        }
    }
}

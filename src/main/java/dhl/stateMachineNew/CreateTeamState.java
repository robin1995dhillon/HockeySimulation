//package dhl.stateMachineNew;
//
//import dhl.Configurables;
//import dhl.inputOutput.IUserInput;
//import dhl.inputOutput.IUserOutput;
//import dhl.inputOutput.UserInput;
//import dhl.inputOutput.UserOutput;
//import dhl.leagueModel.freeAgents.FreeAgents;
//import dhl.leagueModel.freeAgents.IFreeAgents;
//import dhl.leagueModel.generalManager.IGeneralManager;
//import dhl.leagueModel.headCoach.HeadCoach;
//import dhl.leagueModel.headCoach.IHeadCoach;
//import dhl.leagueModel.league.ILeague;
//import dhl.leagueModel.players.IPlayers;
//import dhl.leagueModel.players.Players;
//import dhl.leagueModel.teams.ITeam;
//import dhl.leagueModel.teams.Teams;
//import dhl.presentation.*;
//import dhl.validator.Checker;
//import dhl.validator.IChecker;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CreateTeamState implements IStateMachine{
//
//    private final StateMachine stateMachine;
//    private final IUserOutput output;
//    private final IUserInput input;
//    private ILeague league;
//    private ITeam team;
//
//    CreateTeamState(StateMachine machine){
//
//        this.stateMachine = machine;
//        output = new UserOutput();
//        this.league = machine.getLeague();
//        input = new UserInput();
//        team = new Teams();
//
//    }
//
//    public void entry() {
//        doTask();
//
//    }
//
//    public IStateMachine doTask() {
//
//        IStateMachine nextState = createTeam(league);
//        return nextState;
//    }
//
//
//    public void exit() {
//
//    }
//
//    public IStateMachine createTeam(ILeague league){
//
//        String teamName;
//        String conferenceName;
//        String divisionName;
//        output.setOutput("We are going to create a team. Please enter the following details: ");
//        output.sendOutput();
//        output.setOutput("Enter Conference Name:");
//        output.sendOutput();
//        input.setInput();
//        conferenceName = input.getInput();
//        IChecker CC = new Checker();
//        while (CC.conferenceChecker(conferenceName, league) == false) {
//            output.setOutput("Invalid input! Please enter the conference you imported:");
//            output.sendErrorOutput();
//            input.setInput();
//            conferenceName = input.getInput();
//        }
//        if (CC.conferenceChecker(conferenceName, league)) {
//            output.setOutput("Enter Division Name:");
//            output.sendOutput();
//            input.setInput();
//            divisionName = input.getInput();
//            while (CC.divisionChecker(divisionName, league) == false) {
//                output.setOutput("Invalid input! Please enter the division you imported:");
//                output.sendErrorOutput();
//                input.setInput();
//                divisionName = input.getInput();
//            }
//            if (CC.divisionChecker(divisionName, league)) {
//                output.setOutput("Enter Your Team Name: ");
//                output.sendOutput();
//                input.setInput();
//                teamName = input.getInput();
//                if (CC.teamChecker(teamName, league)) {
//                    output.setOutput("Here are the general managers:");
//                    output.sendOutput();
//                    IGeneralManager managerList = league.getGeneralManagers();
//                    IDisplayManagerList managerDisplayer = new DisplayManagerList();
//                    managerDisplayer.displayManager(managerList);
//                    output.setOutput("Enter Manager Name: ");
//                    output.sendOutput();
//                    input.setInput();
//                    String managerName = input.getInput();
//                    while (CC.managerChecker(managerList, managerName) == false) {
//                        output.setOutput("Invalid input! Please enter one manager from the list:");
//                        output.sendErrorOutput();
//                        input.setInput();
//                        managerName = input.getInput();
//                    }
//                    league.removeManagerFromList(managerList, managerName);
//                    output.setOutput("Here are the head coaches:");
//                    output.sendOutput();
//                    List<IHeadCoach> coachList = league.getCoaches();
//                    IDisplayCoachList coachDisplayer = new DisplayCoachList();
//                    coachDisplayer.displayCoach(coachList);
//                    output.setOutput("Enter Head Coach: ");
//                    output.sendOutput();
//                    input.setInput();
//                    String coachName = input.getInput();
//                    while (CC.coachChecker(coachList, coachName) == false) {
//                        output.setOutput("Invalid input! Please choose one coach from the list:");
//                        output.sendErrorOutput();
//                        input.setInput();
//                        coachName = input.getInput();
//                    }
//                    IHeadCoach headCoach = new HeadCoach();
//                    headCoach = headCoach.getCoachFromList(coachList, coachName);
//                    coachList.remove(headCoach);
//                    output.setOutput("Please choose your team players, here are the free agents:");
//                    output.sendOutput();
//                    List<IFreeAgents> freeAgentList = league.getFreeAgents();
//                    ArrayList<IPlayers> playerList = new ArrayList<>();
//                    IDisplayFreeAgentList freeAgentDisplayer = new DisplayFreeAgentList();
//                    output.setOutput("Please choose two goalies: ");
//                    output.sendOutput();
//                    for (int i = 1; i <= 2; ) {
//                        freeAgentDisplayer.displayFreeAgent(freeAgentList);
//                        output.setOutput("Enter Goalie: " + i);
//                        output.sendOutput();
//                        input.setInput();
//                        String playerName = input.getInput();
//                        while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
//                            output.setOutput("Invalid input! Please choose one free agent from the list:");
//                            output.sendErrorOutput();
//                            input.setInput();
//                            playerName = input.getInput();
//                        }
//                        IFreeAgents freeAgent = new FreeAgents();
//                        freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
//                        if (freeAgent.checkPosition(Configurables.GOALIE.getAction())) {
//                            IPlayers player = new Players();
//                            player = player.convertFreeAgentToPlayer(freeAgent);
//                            playerList.add(player);
//                            freeAgentList.remove(freeAgent);
//                            i++;
//                        } else {
//                            output.setOutput("Invalid input! You need to pick a goalie!");
//                            output.sendErrorOutput();
//                        }
//                    }
//                    output.setOutput("Please choose eighteen skaters(forward and defense):");
//                    output.sendOutput();
//                    for (int i = 1; i <= 18; ) {
//                        freeAgentDisplayer.displayFreeAgent(freeAgentList);
//                        output.setOutput("Enter Skaters (Forward and Defense) " + i);
//                        output.sendOutput();
//                        input.setInput();
//                        String playerName = input.getInput();
//                        while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
//                            output.setOutput("Invalid input! Please choose one free agent from the list:");
//                            output.sendErrorOutput();
//                            input.setInput();
//                            playerName = input.getInput();
//                        }
//                        IFreeAgents freeAgent = new FreeAgents();
//                        freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
//                        if (freeAgent.checkPosition(Configurables.FORWARD.getAction()) || freeAgent.checkPosition(Configurables.DEFENSE.getAction())) {
//                            IPlayers player = new Players();
//                            player = player.convertFreeAgentToPlayer(freeAgent);
//                            playerList.add(player);
//                            freeAgentList.remove(freeAgent);
//                            i++;
//                        } else {
//                            output.setOutput("Invalid input! You need to pick a forward or defense!");
//                            output.sendErrorOutput();
//                        }
//                    }
//                    String[] locationAttributes = {conferenceName, divisionName, teamName, managerName};
//
//                    ILeague updatedLeague = team.createTeam(league, locationAttributes, headCoach, playerList);
//                   //context.setState(new CreateTeamState(updated_league, context, input, output, teamName));
//                    updatedLeague.storeLeague();
//                    stateMachine.setLeague(updatedLeague);
//                    output.setOutput("Saving the team. Please wait...");
//                    output.sendOutput();
////                    context.runState();
////                    context.forward();
////                    context.runState();
//                } else {
//                    output.setOutput("Team Already Exists!");
//                    output.sendOutput();
//                }
//            }
//        }
//        return stateMachine.getPlayerChoice();
//    }
//}

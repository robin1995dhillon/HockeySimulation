package dhl;

import dhl.inputOutput.*;
import dhl.leagueModel.league.ILeague;
import dhl.serializeAndDeserialize.deserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.deserialize.IDeserializeJSONToModel;
//import dhl.simulationStateMachine.LoadTeamState;
import dhl.simulationStateMachine.StateContext;
import dhl.validator.JSONValidator;
import org.json.simple.JSONObject;

import java.io.IOException;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        IUserInput input = new UserInput();
        IUserOutput output = new UserOutput();
        String teamName;
        StateContext context = new StateContext(input, output);
        if (args == null || args.length == 0) {
            output.setOutput("Welcome to the matrix. We all live in simulation ;)");
            output.sendOutput();
            output.setOutput("Please enter the name of the team you want to load");
            output.sendOutput();
            input.setInput();
            teamName = input.getInput();
//            context.setState(new LoadTeamState(input, output, teamName));
//            context.runState();
//            context.forward(); // Simulate state
//            context.runState();
        } else {
            String Path = args[0];
            JSONObject Object = JSONReader.readJSON(Path);
            output.setOutput("Loaded JSON:");
            output.sendOutput();
            output.setOutput("\nValidating the JSON...");
            output.sendOutput();
            JSONValidator jsonValidator = new JSONValidator();
            JSONObject JSONValidator = jsonValidator.mainValidator(Object);
            if (JSONValidator.get("isValid").equals("True")) {
                IDeserializeJSONToModel IDeserializeJSONToModel = new DeserializeJSONToModel();
                ILeague league = IDeserializeJSONToModel.jsonToLeague(Path);
                if (league.isValid(league)) {
                    output.setOutput("Valid JSON!\n");
                    System.out.println(league.getGameplayConfig().getTrading().getGmTable().getShrewd());
//                    output.sendOutput();
//                    output.setOutput("\nWelcome to the matrix. We all live in simulation ;)");
//                    output.sendOutput();
//                    output.setOutput("We are going to create a team. Please enter the following details: ");
//                    output.sendOutput();
//                    output.setOutput("Enter Conference Name:");
//                    output.sendOutput();
//                    input.setInput();
//                    String conferenceName = input.getInput();
//                    IChecker CC = new Checker();
//                    while (CC.conferenceChecker(conferenceName, league) == false) {
//                        output.setOutput("Invalid input! Please enter the conference you imported:");
//                        output.sendErrorOutput();
//                        input.setInput();
//                        conferenceName = input.getInput();
//                    }
//                    if (CC.conferenceChecker(conferenceName, league)) {
//                        output.setOutput("Enter Division Name:");
//                        output.sendOutput();
//                        input.setInput();
//                        String divisionName = input.getInput();
//                        while (CC.divisionChecker(divisionName, league) == false) {
//                            output.setOutput("Invalid input! Please enter the division you imported:");
//                            output.sendErrorOutput();
//                            input.setInput();
//                            divisionName = input.getInput();
//                        }
//                        if (CC.divisionChecker(divisionName, league)) {
//                            output.setOutput("Enter Your Team Name: ");
//                            output.sendOutput();
//                            input.setInput();
//                            teamName = input.getInput();
//                            if (CC.teamChecker(teamName, league)) {
//                                output.setOutput("Here are the general managers:");
//                                output.sendOutput();
//                                IGeneralManager managerList = league.getGeneralManagers();
//                                IDisplayManagerList managerDisplayer = new DisplayManagerList();
//                                managerDisplayer.displayManager(managerList);
//                                output.setOutput("Enter Manager Name: ");
//                                output.sendOutput();
//                                input.setInput();
//                                String managerName = input.getInput();
//                                while (CC.managerChecker(managerList, managerName) == false) {
//                                    output.setOutput("Invalid input! Please enter one manager from the list:");
//                                    output.sendErrorOutput();
//                                    input.setInput();
//                                    managerName = input.getInput();
//                                }
//                                league.removeManagerFromList(managerList, managerName);
//                                output.setOutput("Here are the head coaches:");
//                                output.sendOutput();
//                                List<IHeadCoach> coachList = league.getCoaches();
//                                IDisplayCoachList coachDisplayer = new DisplayCoachList();
//                                coachDisplayer.displayCoach(coachList);
//                                output.setOutput("Enter Head Coach: ");
//                                output.sendOutput();
//                                input.setInput();
//                                String coachName = input.getInput();
//                                while (CC.coachChecker(coachList, coachName) == false) {
//                                    output.setOutput("Invalid input! Please choose one coach from the list:");
//                                    output.sendErrorOutput();
//                                    input.setInput();
//                                    coachName = input.getInput();
//                                }
//                                IHeadCoach headCoach = new HeadCoach();
//                                headCoach = headCoach.getCoachFromList(coachList, coachName);
//                                coachList.remove(headCoach);
//                                output.setOutput("Please choose your team players, here are the free agents:");
//                                output.sendOutput();
//                                List<IFreeAgents> freeAgentList = league.getFreeAgents();
//                                ArrayList<IPlayers> playerList = new ArrayList<>();
//                                IDisplayFreeAgentList freeAgentDisplayer = new DisplayFreeAgentList();
//                                output.setOutput("Please choose two goalies: ");
//                                output.sendOutput();
//                                for (int i = 1; i <= 1; ) {
//                                    freeAgentDisplayer.displayFreeAgent(freeAgentList);
//                                    output.setOutput("Enter Goalie: " + i);
//                                    output.sendOutput();
//                                    input.setInput();
//                                    String playerName = input.getInput();
//                                    while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
//                                        output.setOutput("Invalid input! Please choose one free agent from the list:");
//                                        output.sendErrorOutput();
//                                        input.setInput();
//                                        playerName = input.getInput();
//                                    }
//                                    IFreeAgents freeAgent = new FreeAgents();
//                                    freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
//                                    if (freeAgent.checkPosition(Configurables.GOALIE.getAction())) {
//                                        IPlayers player = new Players();
//                                        player = player.convertFreeAgentToPlayer(freeAgent);
//                                        playerList.add(player);
//                                        freeAgentList.remove(freeAgent);
//                                        i++;
//                                    } else {
//                                        output.setOutput("Invalid input! You need to pick a goalie!");
//                                        output.sendErrorOutput();
//                                    }
//                                }
//                                output.setOutput("Please choose eighteen skaters(forward and defense):");
//                                output.sendOutput();
//                                for (int i = 1; i <= 2; ) {
//                                    freeAgentDisplayer.displayFreeAgent(freeAgentList);
//                                    output.setOutput("Enter Skaters (Forward and Defense) " + i);
//                                    output.sendOutput();
//                                    input.setInput();
//                                    String playerName = input.getInput();
//                                    while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
//                                        output.setOutput("Invalid input! Please choose one free agent from the list:");
//                                        output.sendErrorOutput();
//                                        input.setInput();
//                                        playerName = input.getInput();
//                                    }
//                                    IFreeAgents freeAgent = new FreeAgents();
//                                    freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
//                                    if (freeAgent.checkPosition(Configurables.FORWARD.getAction()) || freeAgent.checkPosition(Configurables.DEFENSE.getAction())) {
//                                        IPlayers player = new Players();
//                                        player = player.convertFreeAgentToPlayer(freeAgent);
//                                        playerList.add(player);
//                                        freeAgentList.remove(freeAgent);
//                                        i++;
//                                    } else {
//                                        output.setOutput("Invalid input! You need to pick a forward or defense!");
//                                        output.sendErrorOutput();
//                                    }
//                                }
//                                String[] locationAttributes = {conferenceName, divisionName, teamName, managerName};
//                                ITeam team = new Teams();
//                                ILeague updated_league = team.createTeam(league, locationAttributes, headCoach, playerList);
//                                context.setState(new CreateTeamState(updated_league, context, input, output, teamName));
//                                output.setOutput("Saving the team. Please wait...");
//                                output.sendOutput();
//                                context.runState();
//                                context.forward();
//                                context.runState();
//                            } else {
//                                output.setOutput("Team Already Exists!");
//                                output.sendOutput();
//                            }
//                        }
//                    }
                }
            } else {
                output.setOutput("Invalid JSON");
                output.sendErrorOutput();
                output.setOutput((String) JSONValidator.get("Message"));
                output.sendErrorOutput();
            }
        }
    }
}

package dhl;

import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;
import dhl.serializeAndDeserialize.ITeamCreator;
import dhl.inputOutput.*;
import dhl.serializeAndDeserialize.TeamCreator;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.presentation.*;
import dhl.serializeAndDeserialize.deserialize.IDeserializeJSONToModel;
import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;
import dhl.simulationStateMachine.CreateTeamState;
import dhl.simulationStateMachine.LoadTeamState;
//import dhl.simulationStateMachine.CreateTeamState;
import dhl.simulationStateMachine.StateContext;
import dhl.validator.Checker;
import dhl.validator.IChecker;
import dhl.validator.JSONValidator;
import dhl.serializeAndDeserialize.deserialize.DeserializeJSONToModel;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        IUserInput input = new UserInput();
        IUserOutput output = new UserOutput();
        String teamName = null;
        StateContext context = new StateContext(input, output);
        if (args == null || args.length == 0) {
            System.out.println("Welcome to the matrix. We all live in simulation ;)");
            System.out.println("Please enter the name of the team you want to load");
            input.setInput();
            teamName = input.getInput();
//            teamName = s.next();
            context.setState(new LoadTeamState(input, output, teamName));
            context.runState();
            context.forward(); // Simulate state
            context.runState();
        } else {
            String Path = args[0];
            JSONObject Object = JSONReader.readJSON(Path);
            System.out.println("Loaded JSON:");
            System.out.println(Object);
            System.out.println("\nValidating the JSON...");
            JSONValidator jsonValidator = new JSONValidator();
            JSONObject JSONValidator = jsonValidator.mainValidator(Object);
            if (JSONValidator.get("isValid").equals("True")) {
                IDeserializeJSONToModel IDeserializeJSONToModel = new DeserializeJSONToModel();
                ILeague league = IDeserializeJSONToModel.jsonToLeague(Path);
                if (league.isValid(league)) {
                    System.out.println("Valid JSON!\n");
                    System.out.println("\nWelcome to the matrix. We all live in simulation ;)");
                    System.out.println("We are going to create a team. Please enter the following details: ");
                    System.out.println("Enter Conference Name:");
//                    String conferenceName = in.nextLine();
                    input.setInput();
                    String conferenceName = input.getInput();
                    IChecker CC = new Checker();
                    while(CC.conferenceChecker(conferenceName, league)==false){
                        System.err.println("Invalid input! Please enter the conference you imported:");
//                        conferenceName = in.nextLine();
                        input.setInput();
                        conferenceName = input.getInput();
                    }
                    if (CC.conferenceChecker(conferenceName, league)) {
                        System.out.println("Enter Division Name:");
                        input.setInput();
                        String divisionName = input.getInput();
//                        String divisionName = in.nextLine();
                        while(CC.divisionChecker(divisionName, league)==false){
                            System.err.println("Invalid input! Please enter the division you imported:");
                            input.setInput();
                            divisionName = input.getInput();
//                            divisionName = in.nextLine();
                        }
                        if (CC.divisionChecker(divisionName, league)) {
                            System.out.println("Enter Your Team Name: ");
//                            teamName = in.nextLine();
                            input.setInput();
                            teamName = input.getInput();
                            if (CC.teamChecker(teamName, league)) {
                                System.out.println("Here are the general managers:");
                                ArrayList<String> managerList = league.getGeneralManagers();
                                IDisplayManagerList managerDisplayer = new DisplayManagerList();
                                managerDisplayer.displayManager(managerList);
                                System.out.println("Enter Manager Name: ");
//                                String managerName = in.nextLine();
                                input.setInput();
                                String managerName = input.getInput();
                                while(CC.managerChecker(managerList, managerName) == false){
                                    System.err.println("Invalid input! Please choose one manager from the list:");
//                                    managerName = in.nextLine();
                                    input.setInput();
                                    managerName = input.getInput();
                                }
                                league.removeManagerFromList(managerList, managerName);

                                System.out.println("Here are the head coaches:");
                                ArrayList<IHeadCoach> coachList = league.getCoaches();
                                IDisplayCoachList coachDisplayer = new DisplayCoachList();
                                coachDisplayer.displayCoach(coachList);
                                System.out.println("Enter Head Coach: ");
//                                String coachName = in.nextLine();
                                input.setInput();
                                String coachName = input.getInput();
                                while(CC.coachChecker(coachList, coachName) == false){
                                    System.err.println("Invalid input! Please choose one coach from the list:");
                                    input.setInput();
                                    coachName = input.getInput();
//                                    coachName = in.nextLine();
                                }
                                IHeadCoach headCoach = new HeadCoach();
                                headCoach = headCoach.getCoachFromList(coachList, coachName);
                                coachList.remove(headCoach);
                                System.out.println("Please choose your team players, here are the free agents:");
                                ArrayList<IFreeAgents> freeAgentList = league.getFreeAgents();
                                ArrayList<IPlayers> playerList = new ArrayList<>();
                                IDisplayFreeAgentList freeAgentDisplayer = new DisplayFreeAgentList();
                                System.out.println("Please choose two goalies: ");
                                for(int i = 1; i <= 2;){
                                    freeAgentDisplayer.displayFreeAgent(freeAgentList);
                                    System.out.println("Enter Goalie " + i);
//                                    String playerName = in.nextLine();
                                    input.setInput();
                                    String playerName = input.getInput();
                                    while(CC.freeAgentChecker(freeAgentList, playerName) == false){
                                        System.err.println("Invalid input! Please choose one free agent from the list:");
//                                        playerName = in.nextLine();
                                        input.setInput();
                                        playerName = input.getInput();
                                    }
                                    IFreeAgents freeAgent = new FreeAgents();
                                    freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                                    if(freeAgent.checkPosition("goalie")){
                                        IPlayers player = new Players();
                                        player = player.convertFreeAgentToPlayer(freeAgent);
                                        playerList.add(player);
                                        freeAgentList.remove(freeAgent);
                                        i++;
                                    } else{
                                        System.err.println("Invalid input! You need to pick a goalie!");
                                    }
                                }
                                System.out.println("Please choose eighteen skaters(forward and defense):");
                                for(int i = 1; i <= 18;){
                                    freeAgentDisplayer.displayFreeAgent(freeAgentList);
                                    System.out.println("Enter Skaters (Forward and Defense) " + i);
//                                    String playerName = in.nextLine();
                                    input.setInput();
                                    String playerName = input.getInput();
                                    while(CC.freeAgentChecker(freeAgentList, playerName) == false){
                                        System.err.println("Invalid input! Please choose one free agent from the list:");
                                        input.setInput();
                                        playerName = input.getInput();
//                                        playerName = in.nextLine();
                                    }
                                    IFreeAgents freeAgent = new FreeAgents();
                                    freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                                    if(freeAgent.checkPosition("forward") || freeAgent.checkPosition("defense")){
                                        IPlayers player = new Players();
                                        player = player.convertFreeAgentToPlayer(freeAgent);
                                        playerList.add(player);
                                        freeAgentList.remove(freeAgent);
                                        i++;
                                    } else {
                                        System.err.println("Invalid input! You need to pick a forward or defense!");
                                    }
                                }
                                for(IPlayers player: playerList) {
                                    System.out.println(player.getPlayerName());
                                }
                                String[] locationAttributes = {conferenceName,divisionName,teamName,managerName};
                                ITeam team = new Teams();
                                ILeague updated_league = team.createTeam(league,locationAttributes,headCoach,playerList);
                                ISerializeModelToJSON serializeModelToJSON = new SerializeModelToJSON();
                                System.out.println(serializeModelToJSON.serializeModelToJSON(updated_league));
                                context.setState(new CreateTeamState(updated_league, context, input, output, teamName));

                                System.out.println("Saving the team. Please wait...");
                                context.runState();
                                context.forward(); //simulate state
                                context.runState();
                            } else {
                                System.out.println("Team Already Exists!");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Invalid JSON");
                System.out.println(JSONValidator.get("Message"));
            }
        }
    }
}

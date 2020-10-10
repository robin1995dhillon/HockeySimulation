package dhl;

import dhl.InOut.*;
import dhl.LeagueModel.League;
import dhl.Creator.TeamCreator;
import dhl.SimulationStateMachine.LoadTeamState;
import dhl.SimulationStateMachine.CreateTeamState;
import dhl.SimulationStateMachine.SimulateLeagueState;
import dhl.Validator.Checker;
import dhl.Validator.JSONValidator;
import dhl.Creator.LeagueCreator;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Scanner;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        IUserInput input = new UserInput();
        IUserOutput output = new UserOutput();
        String teamName = null;
        Scanner in = new Scanner(System.in);
        if (args == null || args.length == 0) {
            System.out.println("Welcome to the matrix. We all live in simulation ;)");
            System.out.println("Please enter the name of the team you want to load");
            Scanner s = new Scanner(System.in);
            teamName = s.next();
            LoadTeamState load = new LoadTeamState();
            if (load.loadTeam(teamName)) {
                System.out.println("Found the team. Loading...");
                SimulateLeagueState simulate = new SimulateLeagueState(input, output, teamName);
                simulate.simulateLeague();
            } else {
                System.out.println(" Quitting simulation.");
            }
        } else {
            String Path = args[0];
            JSONObject Object = JSONReader.readJSON(Path);
            System.out.println("Loaded JSON:");
            System.out.println(Object);
            System.out.println("\nValidating the JSON...");
            JSONValidator jsonValidator = new JSONValidator();
            JSONObject JSONValidator = jsonValidator.mainValidator(Object);
            if (JSONValidator.get("isValid").equals("True")) {
                LeagueCreator leagueCreator = new LeagueCreator();
                League league = leagueCreator.CreateLeague(Path);
                if (League.isValid(league)) {
                    System.out.println("Valid JSON!\n");
                    System.out.println("\nWelcome to the matrix. We all live in simulation ;)");
                    System.out.println("We are going to create a team. Please enter the following details: ");
                    System.out.println("Enter Conference Name:");
                    String conferenceName = in.nextLine();
                    Checker CC = new Checker();
                    while(CC.ConferenceChecker(conferenceName, league)==false){
                        System.out.println("Invalid input! Please enter the conference you imported:");
                        conferenceName = in.nextLine();
                    }
                    if (CC.ConferenceChecker(conferenceName, league)) {
                        System.out.println("Enter Division Name:");
                        String divisionName = in.nextLine();
                        while(CC.DivisionChecker(divisionName, league)==false){
                            System.out.println("Invalid input! Please enter the division you imported:");
                            divisionName = in.nextLine();
                        }
                        if (CC.DivisionChecker(divisionName, league)) {
                            System.out.println("Enter Your Team Name: ");
                            teamName = in.nextLine();
                            if (CC.TeamChecker(teamName, league)) {
                                System.out.println("Enter Manager Name: ");
                                String managerName = in.nextLine();
                                System.out.println("Enter Head Coach: ");
                                String headCoach = in.nextLine();
                                TeamCreator teamCreator = new TeamCreator();
                                League updated_league = teamCreator.createTeam(managerName, headCoach, league, conferenceName, divisionName, teamName);
                                CreateTeamState save = new CreateTeamState();
                                System.out.println("Saving the team. Please wait...");
                                save.SaveToDB(updated_league);
                                System.out.println("\nTeam created.");
                                SimulateLeagueState simulate = new SimulateLeagueState(input, output, teamName);
                                simulate.simulateLeague();
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

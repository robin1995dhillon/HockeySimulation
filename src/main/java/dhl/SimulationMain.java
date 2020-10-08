package dhl;

import dhl.InOut.JSONReader;
import dhl.LeagueModel.League;
import dhl.Creator.TeamCreator;
import dhl.Validator.ConferenceChecker;
import dhl.Validator.JSONValidator;
import dhl.Creator.LeagueCreator;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Scanner;
//import org.json.simple.JSONObject;

public class SimulationMain {
    public static void main(String[] args) throws IOException {


        //Path to JSON - src/Data.json
        System.out.println("Please Enter the Path to JSON");
        Scanner in = new Scanner(System.in);
        String Path = in.nextLine();
        JSONObject Object = JSONReader.readJSON(Path);
        System.out.println(Object);
        JSONValidator jsonValidator = new JSONValidator();
        JSONObject JSONValidator = jsonValidator.mainValidator(Object);
        System.out.println(JSONValidator);
        if(JSONValidator.get("isValid").equals("True")) {
            System.out.println("Success");
            LeagueCreator leagueCreator = new LeagueCreator();
            League league = leagueCreator.CreateLeague(Object);
            System.out.println("Create TEAM");
            System.out.println("Enter Conference Name:");
            String conferenceName = in.nextLine();
            ConferenceChecker CC = new ConferenceChecker();
            if(CC.ConferenceChecker(conferenceName, league)) {
                System.out.println("Enter Division Name:");
                String divisionName = in.nextLine();
                if(CC.DivisionChecker(divisionName, league)) {
                    System.out.println("Enter Your Team Name: ");
                    String teamName = in.nextLine();
                    if(CC.TeamChecker(teamName, league)) {
                        System.out.println("Enter Manager Name: ");
                        String managerName = in.nextLine();
                        System.out.println("Enter Head Coach: ");
                        String headCoach = in.nextLine();
                        TeamCreator teamCreator = new TeamCreator();
                        League updated_league = teamCreator.createTeam(managerName,headCoach,league,conferenceName,divisionName,teamName);
                    }
                    else {
                        System.out.println("Team Already Exists!");
                    }

                }
            }

        }
        else {
            System.out.println("Invalid JSON");
            System.out.println(JSONValidator.get("Message"));
        }



    }
}

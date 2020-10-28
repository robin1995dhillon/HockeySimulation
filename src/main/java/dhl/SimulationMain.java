package dhl;

import dhl.CreateTeamUtils.*;
import dhl.InOut.*;
import dhl.LeagueModel.*;
import dhl.Creator.TeamCreator;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.players.Players;
import dhl.SimulationStateMachine.LoadTeamState;
import dhl.SimulationStateMachine.CreateTeamState;
import dhl.SimulationStateMachine.StateContext;
import dhl.Validator.Checker;
import dhl.Validator.JSONValidator;
import dhl.Creator.LeagueCreator;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        IUserInput input = new UserInput();
        IUserOutput output = new UserOutput();
        String teamName = null;
        StateContext context = new StateContext(input, output);
        Scanner in = new Scanner(System.in);
        if (args == null || args.length == 0) {
            System.out.println("Welcome to the matrix. We all live in simulation ;)");
            System.out.println("Please enter the name of the team you want to load");
            Scanner s = new Scanner(System.in);
            teamName = s.next();
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
                LeagueCreator leagueCreator = new LeagueCreator();
                ILeague ILeague = leagueCreator.CreateLeague(Path);
                if (ILeague.isValid(ILeague)) {
                    System.out.println("Valid JSON!\n");
                    System.out.println("\nWelcome to the matrix. We all live in simulation ;)");
                    System.out.println("We are going to create a team. Please enter the following details: ");
                    System.out.println("Enter Conference Name:");
                    String conferenceName = in.nextLine();
                    Checker CC = new Checker();
                    while(CC.ConferenceChecker(conferenceName, ILeague)==false){
                        System.out.println("Invalid input! Please enter the conference you imported:");
                        conferenceName = in.nextLine();
                    }
                    if (CC.ConferenceChecker(conferenceName, ILeague)) {
                        System.out.println("Enter Division Name:");
                        String divisionName = in.nextLine();
                        while(CC.DivisionChecker(divisionName, ILeague)==false){
                            System.out.println("Invalid input! Please enter the division you imported:");
                            divisionName = in.nextLine();
                        }
                        if (CC.DivisionChecker(divisionName, ILeague)) {
                            System.out.println("Enter Your Team Name: ");
                            teamName = in.nextLine();
                            if (CC.TeamChecker(teamName, ILeague)) {
                                System.out.println("Here are the general managers:");
                                ArrayList<String> managerList = ILeague.getGeneralManagers();
                                IManagerUtils managerUtils = new ManagerUtils();
                                managerUtils.displayManager(managerList);
                                System.out.println("Enter Manager Name: ");
                                String managerName = in.nextLine();
                                ILeague.removeManagerFromList(managerList, managerName);

                                System.out.println("Here are the head coaches:");
                                ArrayList<IHeadCoach> coachList = ILeague.getCoaches();
                                ICoachUtils coachUtils = new CoachUtils();
                                coachUtils.displayCoach(coachList);
                                System.out.println("Enter Head Coach: ");
                                String coachName = in.nextLine();
                                IHeadCoach headCoach = new HeadCoach();
                                headCoach.getCoachFromList(coachList, coachName);
                                coachList.remove(headCoach);

                                System.out.println("Please choose your team players, here are the free agents:");
                                ArrayList<IFreeAgents> freeAgentList = ILeague.getFreeAgents();
                                ArrayList<IPlayers> playerList = new ArrayList<>();
                                IFreeAgentUtils freeAgentUtils = new FreeAgentUtils();
                                freeAgentUtils.displayFreeAgent(freeAgentList);
                                System.out.println("Please choose two goalies: ");
                                for(int i = 0; i < 2; i++){
                                    System.out.println("Enter Player Name: ");
                                    String playerName = in.nextLine();
                                    IFreeAgents freeAgent = new FreeAgents();
                                    freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                                    if(freeAgent.checkPosition("goalie")){
                                        IPlayers player = new Players();
                                        player.convertFreeAgentToPlayer(freeAgent);
                                        playerList.add(player);
                                        freeAgentList.remove(freeAgent);
                                    } else{
                                        System.out.println("You need to pick a goalie!");
                                    }
                                }
                                System.out.println("Please choose eighteen skaters(forward and defense):");
                                for(int i = 0; i < 18; i++){
                                    System.out.println("Enter Player Name: ");
                                    String playerName = in.nextLine();
                                    IFreeAgents freeAgent = new FreeAgents();
                                    freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                                    if(freeAgent.checkPosition("forward") || freeAgent.checkPosition("defense")){
                                        IPlayers player = new Players();
                                        player.convertFreeAgentToPlayer(freeAgent);
                                        playerList.add(player);
                                        freeAgentList.remove(freeAgent);
                                    } else {
                                        System.out.println("You need to pick a forward or defense!");
                                    }
                                }

                                TeamCreator teamCreator = new TeamCreator();
                                ILeague updated_league = teamCreator.createTeam(managerName, headCoach, ILeague, conferenceName, divisionName, teamName, playerList);
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

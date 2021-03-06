package dhl.stateMachine.states;

import dhl.Configurables;
import dhl.presentation.inputOutput.*;
import dhl.leagueModel.*;
import dhl.presentation.*;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;
import dhl.validator.Checker;
import dhl.validator.IChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamState implements IStateMachine {

    private static final Logger logger = LogManager.getLogger(CreateTeamState.class);
    private final StateMachine stateMachine;
    private final IUserOutput output;
    private final IUserInput input;
    private ITeam team;
    private InputOutputAbstractFactory inputOutputAbstractFactory;
    private LeagueModelAbstractFactory leagueModelAbstractFactory;

    public CreateTeamState(StateMachine machine){
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.stateMachine = machine;
        output = inputOutputAbstractFactory.createUserOutput();
        input = inputOutputAbstractFactory.createUserInput();
        team = leagueModelAbstractFactory.getTeam();
    }

    public IStateMachine entry() {
        return doTask();
    }

    public IStateMachine doTask() {
        IStateMachine nextState = createTeam(this.stateMachine.getLeague());
        return nextState;
    }


    public void exit() {
    }

    public IStateMachine createTeam(ILeague league){
        String teamName;
        String conferenceName;
        String divisionName;
        output.setOutput("We are going to create a team. Please enter the following details: ");
        output.sendOutput();
        output.setOutput("Enter Conference Name:");
        output.sendOutput();
        input.setInput();
        conferenceName = input.getInput();
        System.out.println(league.getLeagueName());
        IChecker CC = new Checker();
        while (CC.conferenceChecker(conferenceName, league) == false) {
            output.setOutput("Invalid input! Please enter the conference you imported:");
            output.sendErrorOutput();
            logger.warn("Invalid input for conference name.");
            input.setInput();
            conferenceName = input.getInput();
        }
        logger.info("You choose " + conferenceName + " as your conference.");
        output.setOutput("Enter Division Name:");
        output.sendOutput();
        input.setInput();
        divisionName = input.getInput();
        while (CC.divisionChecker(divisionName, league) == false) {
            output.setOutput("Invalid input! Please enter the division you imported:");
            output.sendErrorOutput();
            logger.warn("Invalid input for division name.");
            input.setInput();
            divisionName = input.getInput();
        }
        logger.info("You choose " + divisionName + " as your conference.");
        output.setOutput("Enter Your Team Name: ");
        output.sendOutput();
        input.setInput();
        teamName = input.getInput();
        if (CC.teamChecker(teamName, league)) {
            output.setOutput("Team Already Exists!");
            output.sendOutput();
            logger.error(teamName + " already exists.");
        } else {
            logger.info("Your team name is " + teamName);
            output.setOutput("Here are the general managers:");
            output.sendOutput();
            List<IGeneralManager> managerList = league.getGeneralManagers();
            IDisplayManagerList managerDisplayer = new DisplayManagerList();
            managerDisplayer.displayManager(managerList);
            output.setOutput("Enter Manager Name: ");
            output.sendOutput();
            input.setInput();
            String managerName = input.getInput();
            while (CC.managerChecker(managerList, managerName) == false) {
                output.setOutput("Invalid input! Please enter one manager from the list:");
                output.sendErrorOutput();
                logger.warn("Invalid input for manager name.");
                input.setInput();
                managerName = input.getInput();
            }
            IGeneralManager generalManager = new GeneralManager();
            generalManager = generalManager.getManagerFromList(managerList, managerName);
            managerList.remove(generalManager);
            logger.info("You choose" + managerName + " as your conference.");
            output.setOutput("Here are the head coaches:");
            output.sendOutput();
            List<IHeadCoach> coachList = league.getCoaches();
            IDisplayCoachList coachDisplayer = new DisplayCoachList();
            coachDisplayer.displayCoach(coachList);
            output.setOutput("Enter Head Coach: ");
            output.sendOutput();
            input.setInput();
            String coachName = input.getInput();
            while (CC.coachChecker(coachList, coachName) == false) {
                output.setOutput("Invalid input! Please choose one coach from the list:");
                output.sendErrorOutput();
                logger.warn("Invalid input for head coach name.");
                input.setInput();
                coachName = input.getInput();
            }
            IHeadCoach headCoach = new HeadCoach();
            headCoach = headCoach.getCoachFromList(coachList, coachName);
            coachList.remove(headCoach);
            logger.info("You choose" + coachName + " as your conference.");
            output.setOutput("Please choose your team players, here are the free agents:");
            output.sendOutput();
            List<IFreeAgents> freeAgentList = league.getFreeAgents();
            ArrayList<IPlayers> playerList = new ArrayList<>();
            IDisplayFreeAgentList freeAgentDisplayer = new DisplayFreeAgentList();
            output.setOutput("Please choose two goalies: ");
            output.sendOutput();
            for (int i = 1; i <= 4; ) {
                freeAgentDisplayer.displayFreeAgent(freeAgentList);
                output.setOutput("Enter Goalie: " + i);
                output.sendOutput();
                input.setInput();
                String playerName = input.getInput();
                while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
                    output.setOutput("Invalid input! Please choose one free agent from the list:");
                    output.sendErrorOutput();
                    logger.warn("Invalid input for free agent name.");
                    input.setInput();
                    playerName = input.getInput();
                }
                IFreeAgents freeAgent = new FreeAgents();
                freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                if (freeAgent.checkPosition(Configurables.GOALIE.getAction())) {
                    IPlayers player = new Players();
                    player = player.convertFreeAgentToPlayer(freeAgent);
                    playerList.add(player);
                    freeAgentList.remove(freeAgent);
                    i++;
                    logger.info("You pick out a goalie.");
                } else {
                    output.setOutput("Invalid input! You need to pick a goalie!");
                    output.sendErrorOutput();
                    logger.warn("You need to choose a goalie.");
                }
            }
            output.setOutput("Please choose eighteen skaters(forward and defense):");
            output.sendOutput();
            for (int i = 1; i <= 26; ) {
                freeAgentDisplayer.displayFreeAgent(freeAgentList);
                output.setOutput("Enter Skaters (Forward and Defense) " + i);
                output.sendOutput();
                input.setInput();
                String playerName = input.getInput();
                while (CC.freeAgentChecker(freeAgentList, playerName) == false) {
                    output.setOutput("Invalid input! Please choose one free agent from the list:");
                    output.sendErrorOutput();
                    logger.warn("Invalid input for free agent name.");
                    input.setInput();
                    playerName = input.getInput();
                }
                IFreeAgents freeAgent = new FreeAgents();
                freeAgent = freeAgent.getFreeAgentFromList(freeAgentList, playerName);
                if (freeAgent.checkPosition(Configurables.FORWARD.getAction()) || freeAgent.checkPosition(Configurables.DEFENSE.getAction())) {
                    IPlayers player = new Players();
                    player = player.convertFreeAgentToPlayer(freeAgent);
                    playerList.add(player);
                    freeAgentList.remove(freeAgent);
                    i++;
                    logger.info("You choose a " + player.getPosition());
                } else {
                    output.setOutput("Invalid input! You need to pick a forward or defense!");
                    output.sendErrorOutput();
                    logger.warn("You need to pick a forward or defense.");
                }
            }
            String[] locationAttributes = {conferenceName, divisionName, teamName, managerName};
            ILeague updatedLeague = team.createTeam(league, locationAttributes, headCoach, playerList, generalManager);
            stateMachine.setLeague(updatedLeague);
            output.setOutput("Saving the team. Please wait...");
            output.sendOutput();
            logger.info(teamName + " is successfully created.");
        }
        return stateMachine.getPlayerChoice();
    }
}

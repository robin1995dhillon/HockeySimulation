package dhl.stateMachine.states;

import com.fasterxml.jackson.core.JsonProcessingException;
import dhl.Configurables;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.serializeAndDeserialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.SerializeModelToJSON;
import dhl.stateMachine.ISchedulerSeason;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.SchedulerSeason;
import dhl.stateMachine.StateMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdvanceToNextSeasonState implements IStateMachine {

    StateMachine machine;
    IUserOutput output;
    List<ITeam> allTeams;
    ISerializeModelToJSON serialize;
    InputOutputAbstractFactory inputOutputAbstractFactory;

    private static final Logger logger = LogManager.getLogger(AdvanceToNextSeasonState.class);

    public AdvanceToNextSeasonState(StateMachine stateMachine, List<ITeam> allTeams){
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.machine = stateMachine;
        this.allTeams = allTeams;
        output = inputOutputAbstractFactory.createUserOutput();
        serialize = new SerializeModelToJSON();
    }

    public IStateMachine entry() throws ParseException {
        return doTask();
    }

    public IStateMachine doTask() throws ParseException {
        ISchedulerSeason season = new SchedulerSeason();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = machine.getLeague().getDate();
        LocalDate currentDate =LocalDate.parse(date,formatter);
        String[] dateSimulationStart = season.getStartDayOfSeason().split("-");
        int year = Integer.parseInt(dateSimulationStart[2]);
        LocalDate nextSeasonDate = LocalDate.parse(Configurables.START_DAY_OF_SEASON.getAction() + String.valueOf(year+1), formatter);
        int daysBetweenDates = (int) Duration.between(currentDate,nextSeasonDate).toDays();
        if(machine.getLeague().getSeason() == machine.getLeague().getTotalSeasons()){
            output.setOutput("end of simulation!");
            output.sendOutput();
            logger.info("End of simulation. Ready to save the game.");
            saveGame(machine.getLeague());
            System.exit(0);
        }
        else{
            List<IFreeAgents> oldFreeAgentList = machine.getLeague().getFreeAgents();
            for(int i = 0; i < oldFreeAgentList.size(); i++) {
                if(oldFreeAgentList.get(i).isRetired()) {
                    oldFreeAgentList.remove(oldFreeAgentList.get(i));
                }
            }
            machine.getLeague().setFreeAgents(oldFreeAgentList);

            for(ITeam team : allTeams){
                for(IPlayers player : team.getPlayers()){
                    player.agePlayer(daysBetweenDates, this.machine.getLeague().getGameplayConfig());
                    if(player.isRetired()){
                        output.setOutput("Player " + player.getPlayerName() + " retired from team " + team.getTeamName());
                        output.sendOutput();
                        logger.info(player.getPlayerName() + " retired from "+team.getTeamName());
                        IFreeAgents agent = player.replacePlayerWithFreeAgent(player, machine.getLeague().getFreeAgents());
                        IPlayers convertPlayer = player.convertFreeAgentToPlayer(agent);
                        team.addPlayerToTeam(convertPlayer);
                    }
                }
            }
        }
        logger.info("End of season. Save game and ready to simulate next season.");
        saveGame(machine.getLeague());
        return machine.getInitializeSeason();
    }

    public void exit() {
    }

    public void saveGame(ILeague league){
        try {
            String leagueModel = serialize.serializeModelToJSON(league);
            serialize.saveToFile(leagueModel);
        } catch (JsonProcessingException e) {
            logger.error("Fail to serialize the league model to Json format.");
            e.printStackTrace();
        } catch (IOException exception) {
            logger.error("Fail to save the game.");
            exception.printStackTrace();
        }
    }
}

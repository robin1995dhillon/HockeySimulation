package dhl.stateMachineNew;

import com.fasterxml.jackson.core.JsonProcessingException;
import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.serializeAndDeserialize.serialize.ISerializeModelToJSON;
import dhl.serializeAndDeserialize.serialize.SerializeModelToJSON;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdvanceToNextSeasonState implements IStateMachine{

    StateMachine machine;
    IUserOutput output;
    List<ITeam> allTeams;
    ISerializeModelToJSON serialize;


    public AdvanceToNextSeasonState(StateMachine stateMachine, List<ITeam> allTeams){

        this.machine = stateMachine;
        this.allTeams = allTeams;
        output = new UserOutput();
        serialize = new SerializeModelToJSON();
    }

    public void entry() throws ParseException {
        doTask();

    }

    public IStateMachine doTask() throws ParseException {
        ISchedulerSeason season = new SchedulerSeason();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = machine.getLeague().getDate();
        LocalDate currentDate =LocalDate.parse(date,formatter);
        String[] dateSimulationStart = season.getStartDayOfSeason().split("-");
        int year = Integer.parseInt(dateSimulationStart[2]);
        LocalDate nextSeasonDate = LocalDate.parse(Configurables.START_DAY_OF_SEASON.getAction()+String.valueOf(year+1),formatter);
        int daysBetweenDates = (int) Duration.between(currentDate,nextSeasonDate).toDays();
        if(machine.getLeague().getSeason() == machine.getLeague().getTotalSeasons()){
            output.setOutput("end of simulation!");
            output.sendOutput();
            saveGame(machine.getLeague());
            System.exit(0);
        }
        else{
            for(IFreeAgents agent : machine.getLeague().getFreeAgents()){
                //FREE AGENT LIST FOR RETIREMENT
                // whichever retires, remove from list
            }

            for(ITeam team : allTeams){
                for(IPlayers player : team.getPlayers()){
                    player.agePlayer(daysBetweenDates);
                    if(player.isRetired()){
                        output.setOutput("Player "+player.getPlayerName()+" retired from team "+team.getTeamName());
                        output.sendOutput();
                        IFreeAgents agent = player.replacePlayerWithFreeAgent(player, machine.getLeague().getFreeAgents());
                        IPlayers convertPlayer = player.convertFreeAgentToPlayer(agent);
                        //add player to team
                    }
                }
            }

        }
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
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

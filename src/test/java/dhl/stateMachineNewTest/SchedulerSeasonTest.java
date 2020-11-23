package dhl.stateMachineNewTest;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockStandingTeam;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.SchedulerSeason;
import dhl.stateMachineNew.StateMachine;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SchedulerSeasonTest {

    @Test
    public void playoffScheduleTest() {

        IUserOutput userOutput = new UserOutput();
        List<ITeamStanding> listStanding;
        listStanding = MockStandingTeam.createTeamStandingMock();
        List<ITeamStanding>sortedTeamListPlayoff = new ArrayList<>();
        List<ISchedulerSeason>scheduleList = new ArrayList<>();
        Map<ITeam,Integer> teamListPlayoff = new HashMap<>();
        List<ITeam> finalPlayoffList = new ArrayList<>();
        String playoffStartDate = "01-01-2020";
        String playoffEndDate = "05-01-2020";
        listStanding.sort((team1,team2)->Integer.compare(team1.getTotalPoints(),team2.getTotalPoints()));
        sortedTeamListPlayoff = listStanding.subList(0,2);
        for(ITeamStanding team : sortedTeamListPlayoff){
            userOutput.setOutput("selected team info : "+ team.getTeam().getTeamName()+" "+team.getTotalPoints());
            userOutput.sendOutput();
            teamListPlayoff.put(team.getTeam(),team.getTotalPoints());
        }
        for (Map.Entry<ITeam, Integer> entry : teamListPlayoff.entrySet()) {
            finalPlayoffList.add(entry.getKey());
        }
        for(ITeam firstTeam : finalPlayoffList){
            for(ITeam opponentTeam : finalPlayoffList) {
                if (firstTeam.getTeamName().equalsIgnoreCase(opponentTeam.getTeamName())) {
                    continue;
                } else {
                    ISchedulerSeason schedulerSeason = new SchedulerSeason();
                    schedulerSeason.setFirstTeam(firstTeam);
                    schedulerSeason.setSecondTeam(opponentTeam);
                    schedulerSeason.setDateOfMatch(playoffStartDate);
                    schedulerSeason.setStatus(Configurables.SCHEDULED.getAction());
                    scheduleList.add(schedulerSeason);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Calendar calendar = Calendar.getInstance();

                    try {
                        calendar.setTime(dateFormat.parse(playoffStartDate));
                    } catch (ParseException e) {
                        userOutput.setOutput("Exception while getting current date");
                        userOutput.sendOutput();
                    }
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    playoffStartDate = dateFormat.format(calendar.getTime());
                    userOutput.setOutput("new date :" + playoffStartDate);
                    userOutput.sendOutput();

                    if (playoffStartDate.equalsIgnoreCase(playoffEndDate)) {
                        playoffStartDate = "01-01-2020";
                    } else {
                        continue;
                    }
                }
            }
        }

        for(ISchedulerSeason season : scheduleList){
            userOutput.setOutput(season.getDateOfMatch()+" "+season.getFirstTeam().getTeamName()+" "+season.getSecondTeam().getTeamName());
            userOutput.sendOutput();

        }

    }
}

package dhl.stateMachineNewTest;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ITeam;
import dhl.mock.MockStandingTeam;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.SchedulerSeason;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchedulerSeasonTest {

    @Test
    public void playoffScheduleTest() {

        IUserOutput userOutput = new UserOutput();
        List<ITeamStanding> listStanding;
        listStanding = MockStandingTeam.createTeamStandingMock();
        List<ITeamStanding> sortedTeamListPlayoff;
        List<ISchedulerSeason> scheduleList = new ArrayList<>();
        Map<ITeam, Integer> teamListPlayoff = new HashMap<>();
        List<ITeam> finalPlayoffList = new ArrayList<>();
        String playoffStartDate = "01-01-2020";
        String playoffEndDate = "05-01-2020";
        listStanding.sort((team1, team2) -> Integer.compare(team1.getTotalPoints(), team2.getTotalPoints()));
        System.out.println("list is: " + listStanding.get(0).getTeam().getTeamName());

        sortedTeamListPlayoff = listStanding.subList(0, 2);
        for (ITeamStanding team : sortedTeamListPlayoff) {
            userOutput.setOutput("selected team info : " + team.getTeam().getTeamName() + " " + team.getTotalPoints());
            userOutput.sendOutput();
            teamListPlayoff.put(team.getTeam(), team.getTotalPoints());
        }
        for (Map.Entry<ITeam, Integer> entry : teamListPlayoff.entrySet()) {
            finalPlayoffList.add(entry.getKey());
        }
        for (ITeam firstTeam : finalPlayoffList) {
            for (ITeam opponentTeam : finalPlayoffList) {
                if (firstTeam.getTeamName().equalsIgnoreCase(opponentTeam.getTeamName())) {
                    continue;
                } else {
                    ISchedulerSeason schedulerSeason = new SchedulerSeason();
                    schedulerSeason.setFirstTeam(firstTeam);
                    schedulerSeason.setSecondTeam(opponentTeam);
                    schedulerSeason.setDateOfMatch(playoffStartDate);
                    schedulerSeason.setStatus(Configurables.SCHEDULED.getAction());
                    scheduleList.add(schedulerSeason);

                    playoffStartDate = nextDate(playoffStartDate);

                    if (playoffStartDate.equalsIgnoreCase(playoffEndDate)) {
                        playoffStartDate = "01-01-2020";
                    } else {
                        continue;
                    }
                }
            }
        }
        assertEquals("03-01-2020", playoffStartDate);
        for (ISchedulerSeason season : scheduleList) {
            userOutput.setOutput(season.getDateOfMatch() + " " + season.getFirstTeam().getTeamName() + " " + season.getSecondTeam().getTeamName());
            userOutput.sendOutput();

        }

    }

    public String nextDate(String playoffStartDate) {

        IUserOutput userOutput = new UserOutput();
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
        return playoffStartDate;
    }
}

package dhl.stateMachineNewTest;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.mock.MockConference;
import dhl.mock.MockDivision;
import dhl.mock.MockStandingTeam;
import dhl.mock.MockTeam;
import dhl.serializeAndDeserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.IDeserializeJSONToModel;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.SchedulerSeason;
import dhl.stateMachineNew.StateMachineAbstractFactory;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchedulerSeasonTest {
    IDeserializeJSONToModel deserializeJSONToModel = new DeserializeJSONToModel();
    ISchedulerSeason schedulerSeason = StateMachineAbstractFactory.instance().getSchedulerSeason();
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private int playoffsYear = currentYear + 1;

//    @Test
//    public void playoffScheduleTest() {
//
//        IUserOutput userOutput = new UserOutput();
//        List<ITeamStanding> listStanding;
//        listStanding = MockStandingTeam.createTeamStandingMock();
//        List<ITeamStanding> sortedTeamListPlayoff;
//        List<ISchedulerSeason> scheduleList = new ArrayList<>();
//        Map<ITeam, Integer> teamListPlayoff = new HashMap<>();
//        List<ITeam> finalPlayoffList = new ArrayList<>();
//        String playoffStartDate = "01-01-2020";
//        String playoffEndDate = "05-01-2020";
//        listStanding.sort((team1, team2) -> Integer.compare(team1.getTotalPoints(), team2.getTotalPoints()));
//        System.out.println("list is: " + listStanding.get(0).getTeam().getTeamName());
//
//        sortedTeamListPlayoff = listStanding.subList(0, 2);
//        for (ITeamStanding team : sortedTeamListPlayoff) {
//            userOutput.setOutput("selected team info : " + team.getTeam().getTeamName() + " " + team.getTotalPoints());
//            userOutput.sendOutput();
//            teamListPlayoff.put(team.getTeam(), team.getTotalPoints());
//        }
//        for (Map.Entry<ITeam, Integer> entry : teamListPlayoff.entrySet()) {
//            finalPlayoffList.add(entry.getKey());
//        }
//        for (ITeam firstTeam : finalPlayoffList) {
//            for (ITeam opponentTeam : finalPlayoffList) {
//                if (firstTeam.getTeamName().equalsIgnoreCase(opponentTeam.getTeamName())) {
//                    continue;
//                } else {
//                    ISchedulerSeason schedulerSeason = new SchedulerSeason();
//                    schedulerSeason.setFirstTeam(firstTeam);
//                    schedulerSeason.setSecondTeam(opponentTeam);
//                    schedulerSeason.setDateOfMatch(playoffStartDate);
//                    schedulerSeason.setStatus(Configurables.SCHEDULED.getAction());
//                    scheduleList.add(schedulerSeason);
//
//                    playoffStartDate = nextDate(playoffStartDate);
//
//                    if (playoffStartDate.equalsIgnoreCase(playoffEndDate)) {
//                        playoffStartDate = "01-01-2020";
//                    } else {
//                        continue;
//                    }
//                }
//            }
//        }
//        assertEquals("03-01-2020", playoffStartDate);
//        for (ISchedulerSeason season : scheduleList) {
//            userOutput.setOutput(season.getDateOfMatch() + " " + season.getFirstTeam().getTeamName() + " " + season.getSecondTeam().getTeamName());
//            userOutput.sendOutput();
//
//        }
//
//    }



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

    @Test
    public void getStartDayOfSeasonTest() {
        String startDay = "30-09-2020";
        schedulerSeason.setCurrentYear(String.valueOf(currentYear));
        String dateOutput = schedulerSeason.getStartDayOfSeason();
        assertEquals(startDay, dateOutput);
    }

    @Test
    public void getFirstDayOfSeasonTest() {
        String startDay = "01-10-2020";
        schedulerSeason.setCurrentYear(String.valueOf(currentYear));
        String dateOutput = schedulerSeason.getFirstDayOfSeason();
        assertEquals(startDay, dateOutput);
    }

    @Test
    public void getLastDayOfSeasonTest() throws ParseException {
        String lastDay = "03-04-2021";
        String dateOutput = "";
        schedulerSeason.setPlayoffsYear(playoffsYear);
        try {
            dateOutput = schedulerSeason.getLastDayOfSeason();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(lastDay, dateOutput);
    }

    @Test
    public void getFirstDayOfStanleyPlayoffsTest() {
        String firstDay = "14-04-2021";
        String dateOutput = "";
        schedulerSeason.setPlayoffsYear(playoffsYear);
        dateOutput = schedulerSeason.getFirstDayOfStanleyPlayoffs();
        assertEquals(firstDay, dateOutput);
    }

    @Test
    public void getLastDayOfStanleyPlayoffsTest() {
        String lastDay = "01-06-2021";
        String dateOutput = "";
        schedulerSeason.setPlayoffsYear(playoffsYear);
        dateOutput = schedulerSeason.getLastDayOfStanleyPlayoffs();
        assertEquals(lastDay, dateOutput);
    }

    @Test
    public void enterIntoPlayerDraftTest() {
        String draftDate = "15-07-2021";
        String dateOutput = "";
        schedulerSeason.setPlayoffsYear(playoffsYear);
        dateOutput = schedulerSeason.enterIntoPlayerDraft();
        assertEquals(draftDate, dateOutput);

    }

    @Test
    public void getLastDayOfTradeTest() {
        String lastDate = "22";
        String dateOutput = "";
        schedulerSeason.setPlayoffsYear(playoffsYear);
        dateOutput = schedulerSeason.getLastDayOfTrade();
        assertEquals(lastDate, dateOutput);
    }

    @Test
    public void isLastDayOfTradeTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String presentDate = formatter.format(date).toString();
        boolean isLastDay = true;
        try {
            isLastDay = schedulerSeason.isLastDayOfTrade(presentDate, playoffsYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false, isLastDay);
    }

    @Test
    public void isLastDayOfTradeTrueTest() throws ParseException {
        String lastDate = "28-02-2021";
        boolean isLastDay = false;
        try {
            isLastDay = schedulerSeason.isLastDayOfTrade(lastDate, playoffsYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(true, isLastDay);
    }

    @Test
    public void isLastDayOfSeasonTest() {
        String lastDay = "03-04-2021";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String presentDate = formatter.format(date).toString();
        boolean isLastDay = true;
        isLastDay = schedulerSeason.isLastDayOfSeason(presentDate, lastDay);
        assertEquals(false, isLastDay);

    }

    @Test
    public void scheduleTest() throws ParseException {
        String currentScheduleDate = "30-11-2020";
        String returningSchduleDate = "02-12-2020";
        String dateOutput = "";
        schedulerSeason.setLastDayOfSeason("03-04-2021");
        schedulerSeason.setScheduleList(new ArrayList<>());
        List<ITeam> teamList = new ArrayList<>();
        ITeam team1 = MockTeam.MockTeam();
        ITeam team2 = MockTeam.MockDefendingTeam();
        ITeam team3 = MockTeam.MockOffensiveTeam();
        teamList.add(team1);
        teamList.add(team2);
        try {
            dateOutput = schedulerSeason.schedule(teamList,team3,currentScheduleDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(returningSchduleDate,dateOutput);

    }

    @Test
    public void addScheduleTest(){
        schedulerSeason.setScheduleList(new ArrayList<>());
        ITeam team1 = MockTeam.MockTeam();
        ITeam team2 = MockTeam.MockDefendingTeam();
        String date = "30-11-2020";
        schedulerSeason.addSchedule(team1,team2,date,Configurables.REGULAR.getAction());
        assertEquals(team2.getTeamName(),schedulerSeason.getScheduleList().get(0).getFirstTeam().getTeamName());
    }

    @Test
    public void scheduleInterConfGamesTest() throws ParseException {

        IConference conference = MockConference.mockConference();

        Map<IConference, List<ITeam>> teamsInConference = MockConference.mockMapConference();
        ITeam team = MockTeam.MockDefendingTeam();
        schedulerSeason.setTeamsInConference(teamsInConference);
        schedulerSeason.setScheduleList(new ArrayList<>());
        String date = "30-11-2020";
        String dateOutput = "";
        try {
            dateOutput = schedulerSeason.scheduleInterConfGames(conference, team, date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("01-12-2020",dateOutput);

    }

    @Test
    public void scheduleInterDivGamesTest() throws ParseException{

        IConference conference = MockConference.mockConferenceTwo();
        IDivision divisions = MockDivision.createMock();

        List<IDivision> divisionList = new ArrayList<>();
        Map<IConference, List<IDivision>> divisionMap = new HashMap<>();
        for (IDivision division : conference.getDivisions()) {
            divisionList.add(division);
        }

        divisionMap.put(conference,divisionList);

        Map<IDivision, List<ITeam>> teamInDivision = MockConference.mockMapTeamsInDivision();
        ITeam team = MockTeam.MockDefendingTeam();
        schedulerSeason.setDivisionsInConference(divisionMap);
        schedulerSeason.setScheduleList(new ArrayList<>());
        schedulerSeason.setTeamsInDivision(teamInDivision);
        String date = "30-11-2020";
        String dateOutput = "";
        try {
            dateOutput = schedulerSeason.scheduleInterDivGames(conference, divisions, team, date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(date,dateOutput);

    }

    @Test
    public void scheduleIntraDivGamesTest() throws ParseException {

        ITeam teams = MockTeam.MockDefendingTeam();
        IDivision divisions = MockDivision.divisionMock();
        String date = "30-11-2020";
        String dateOutput = "";
        List<ITeam> teamList = new ArrayList<>();
        Map<IDivision, List<ITeam>> teamMap = new HashMap<>();
        IDivision division = divisions;

        for (ITeam team : division.getTeams()) {
            teamList.add(team);
        }
        teamMap.put(division,teamList);
        schedulerSeason.setTeamsInDivision(teamMap);
        schedulerSeason.setScheduleList(new ArrayList<>());
        try {
            dateOutput = schedulerSeason.scheduleIntraDivGames(divisions, teams, date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("02-12-2020",dateOutput);

    }






}




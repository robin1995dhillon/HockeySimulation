package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Implement a scheduling system:
 * At the start of a season the scheduling system determines the dates for most of the major events in a season of hockey in a major league like the NHL:
 * • October 1st: Regular season starts (the first games of the regular season can be scheduled on this date).
 * • Last Monday in February: Trade deadline. No trading is allowed after this date.
 * • First Saturday in April: End of the regular season, after all games are played on this date determine the round 1 seedings for the playoffs. We will assume that all leagues use the Stanley Cup playoff format.
 * • Second Wednesday in April: Playoffs begin.
 * • June 1st: Last possible day for the Stanley Cup final.
 * Also at the start of a season the scheduling system determines the dates for all regular season games between teams:
 * • Total games/team: 82.
 * • ~1/3rd Games: Intra-Division.
 * • ~1/3rd Games: Inter-Division.
 * • ~1/3rd Games: Inter-Conference.
 */
public class SchedulerSeason implements ISchedulerSeason {
    private String currentYear;
    private int regSeasonYear;
    private int playoffsYear;
    private int currentSeason;
    private int totalDivisions;
    private int totalTeams;
    private int matchesPerDay;
    private String currentDay;
    private String firstDay;
    private String lastDay;
    private Calendar calendar;
    private int gamePerTeam = 82;
    private List<ISchedulerSeason> shedule = new ArrayList<>();
    private String matchStatus;
    private String gameType;
    private ITeam firstTeam;
    private ITeam secondTeam;
    private String matchDate;
    private String playerDraftDate;
    private List<ISchedulerSeason> scheduleList;
    private List<ITeamStanding> listTeamStanding;
    private List<ITeamStanding> sortedTeamListPlayoff;

    private IUserOutput output;
    private Map<String, List<Map<String, String>>> finalSchedule;
    private List<IConference> conferenceList;
    private List<IDivision> divisionList;
    private List<ITeam> teamList;
    private Map<IConference, List<ITeam>> teamsInConference;
    private Map<IDivision, List<ITeam>> teamsInDivision;
    private Map<IConference, List<IDivision>> divisionsInConference;
    private Map<ITeam, Integer> scheduledMatches;
    private Map<String, Integer> matchesOnADay;
    private StateMachine machine;
    private ILeague league;
    private ITime timeConcept;

    public SchedulerSeason() {
        timeConcept = new LeagueTimeConcept();
        calendar = Calendar.getInstance();
//        this.totalDivisions = 0;
//        this.totalTeams = 0;
//        //this.currentSeason = ;
//
//        conferenceList = new ArrayList<>();
//        divisionList = new ArrayList<>();
//        teamList = new ArrayList<>();
//        timeConcept = new LeagueTimeConcept();
//
//        teamsInConference = new HashMap<>();
//        teamsInDivision = new HashMap<>();
//        divisionsInConference = new HashMap<>();
//        scheduledMatches = new HashMap<>();
//        int currentYear = this.calendar.get(Calendar.YEAR);
//        currentYear += this.currentSeason;                          //check it
//        this.currentYear = String.valueOf(currentYear);
//        this.regSeasonYear = currentYear;
//        this.playoffsYear = currentYear + 1;

    }

//    public SchedulerSeason() {
//
//    }

//    SchedulerSeason(Calendar calendar, int currentSeason, StateMachine machine) {
//        this.machine = machine;
//        this.league = this.machine.getLeague();
//        this.currentSeason = currentSeason;
//        this.calendar = calendar;
//        int currentYear = this.calendar.get(Calendar.YEAR);
//        currentYear += this.currentSeason;
//        this.currentYear = String.valueOf(currentYear);
//        this.regSeasonYear = currentYear;
//        this.playoffsYear = currentYear + 1;
//    }


    public String getStartDayOfSeason() {
        String startDate = Configurables.START_DAY_OF_SEASON.getAction() + this.currentYear;

        return startDate;
    }

    /**
     * Season start date: 1st October
     **/
    public String getFirstDayOfSeason() {
        String firstDay = "01-10-" + this.currentYear;

        return firstDay;
    }

    /**
     * Season end date: First Saturday in April
     **/
    public String getLastDayOfSeason() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, playoffsYear);
        String seasonDay = String.valueOf(calendar.get(Calendar.DATE));
        String lastDay = seasonDay + "-04-" + String.valueOf(playoffsYear);
        try {
            lastDay = dateFormat.format(dateFormat.parse(lastDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lastDay;
    }

    /**
     * Stanley Playoffs start date: Second Wednesday in April
     **/
    public String getFirstDayOfStanleyPlayoffs() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, playoffsYear);
        String seasonDay = String.valueOf(calendar.get(Calendar.DATE));
        String lastDay = seasonDay + "-04-" + String.valueOf(playoffsYear);
        try {
            lastDay = dateFormat.format(dateFormat.parse(lastDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lastDay;
    }

    /**
     * Stanley Playoffs end date: June 1st
     **/
    public String getLastDayOfStanleyPlayoffs() {
        String lastDay = "01-06-" + String.valueOf(playoffsYear);

        return lastDay;
    }

    public String enterIntoPlayerDraft() {
        String playerDraftDate = "15-07-" + String.valueOf(playoffsYear);

        return playerDraftDate;
    }


    /**
     * Trade deadline: Last Monday in February
     **/
    public String getLastDayOfTrade() {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.YEAR, playoffsYear);

        return String.valueOf(calendar.get(Calendar.DATE));
    }


    public boolean isLastDayOfTrade(String currentDate, int playoffsYear) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(getLastDayOfTrade());
        String lastDayOfTrade = getLastDayOfTrade() + "-02-" + String.valueOf(playoffsYear);
        lastDayOfTrade = dateFormat.format(dateFormat.parse(lastDayOfTrade));
        try {
            Date start = new SimpleDateFormat("dd-MM-yyyy").parse(currentDate);
            Date end = new SimpleDateFormat("dd-MM-yyyy").parse(lastDayOfTrade);
            if (start.compareTo(end) < 0) {
                return false;
            }
            if (start.compareTo(end) >= 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean isLastDayOfSeason(String currentDate, String lastDate) {
        try {
            Date start = new SimpleDateFormat("dd-MM-yyyy").parse(currentDate);
            Date end = new SimpleDateFormat("dd-MM-yyyy").parse(lastDate);
            if (start.compareTo(end) >= 0) {
                return true;
            }
            if (start.compareTo(end) < 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public String getCurrentDay() {
        return this.currentDay;
    }

    public void generateSchedule(StateMachine machine) throws ParseException {
        this.calendar = Calendar.getInstance();
        this.currentSeason = machine.getLeague().getSeason();
        int currentYear = this.calendar.get(Calendar.YEAR);
        currentYear += this.currentSeason;                          //check it
        this.currentYear = String.valueOf(currentYear);
        this.regSeasonYear = currentYear;
        this.playoffsYear = currentYear + 1;
        machine.setPlayoffsYear(this.playoffsYear);

        scheduleList = new ArrayList<>();
        listTeamStanding = new ArrayList<>();
        String startDateOfSeason = getStartDayOfSeason();
        currentDay = getStartDayOfSeason(); //check krvaa
        lastDay = getLastDayOfSeason();
        playerDraftDate = enterIntoPlayerDraft();
        machine.getLeague().setDate(startDateOfSeason);
        machine.getLeague().setLastDateOfSeason(lastDay);
        machine.getLeague().setPlayerDraftDate(playerDraftDate);
        initialize(machine.getLeague());
        for (IConference conference : machine.getLeague().getConferences()) {
            for (IDivision division : conference.getDivisions()) {
                for (ITeam team : division.getTeams()) {
                    ITeamStanding teamStanding = new TeamStandings();
                    // teamList.add(team);
                    teamStanding.setDivision(division.getDivisionName());
                    teamStanding.setConference(conference.getConferenceName());
                    teamStanding.setTeam(team);
                    listTeamStanding.add(teamStanding);
                    incrementCurrentDay(currentDay, lastDay);
                    //setMatches();
                    createSchedule();

                }
            }
        }
        machine.getLeague().setSchedules(scheduleList);
        machine.getLeague().setTeamStandingList(listTeamStanding);
        machine.setTotalTeamList(teamList);
    }


    public boolean incrementCurrentDay(String currentDay, String lastDay) throws ParseException {

        if (currentDay.equals(lastDay)) {
            return false;
        } else {
            String date = timeConcept.nextDate(currentDay);
            return true;
        }
    }

    private void initialize(ILeague league) {
        this.totalDivisions = 0;
        this.totalTeams = 0;

        conferenceList = new ArrayList<>();
        divisionList = new ArrayList<>();
        teamList = new ArrayList<>();

        teamsInConference = new HashMap<>();
        teamsInDivision = new HashMap<>();
        divisionsInConference = new HashMap<>();
        scheduledMatches = new HashMap<>();

        List<IConference> retrievedConferences = league.getConferences();

        for (int i = 0; i < retrievedConferences.size(); i++) {
            IConference conferenceName = retrievedConferences.get(i);
            List<IDivision> retrievedDivisions = retrievedConferences.get(i).getDivisions();

            this.conferenceList.add(conferenceName);
            this.totalDivisions += retrievedDivisions.size();

            for (int j = 0; j < retrievedDivisions.size(); j++) {
                IDivision divisionName = retrievedDivisions.get(j);
                List<ITeam> retrievedTeams = retrievedDivisions.get(j).getTeams();

                this.divisionList.add(divisionName);
                this.totalTeams += retrievedTeams.size();

                for (int k = 0; k < retrievedTeams.size(); k++) {
                    ITeam teamName = retrievedTeams.get(k);

                    this.teamList.add(teamName);
                    scheduledMatches.put(teamName, 0);
                }

                teamsInConference.put(conferenceName, teamList);
                teamsInDivision.put(divisionName, teamList);
            }
            divisionsInConference.put(conferenceName, divisionList);

        }

    }

//    private void setMatches() {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date d1 = null;
//        Date d2 = null;
//        try {
//            d1 = sdf.parse(firstDay);
//            d2 = sdf.parse(lastDay);
//            DateTime dt1 = new DateTime(d1);
//            DateTime dt2 = new DateTime(d2);
//            int totalDays = Days.daysBetween(dt1, dt2).getDays();
//            int totalMatches = (totalTeams * 82);
//            double temp = Math.ceil(((double) totalMatches / (double) totalDays));
//            int count = (int) temp;
//            matchesPerDay = count;
//            System.out.println("Total days: " + totalDays + "\nMatches per day: " + matchesPerDay);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    private void createSchedule() throws ParseException {

        String startDate = getFirstDayOfSeason();

        for (IConference conference : conferenceList) {

            List<ITeam> teamsInConf = teamsInConference.get(conference);
            for (ITeam team : teamsInConf) {

                Set<Map.Entry<IDivision, List<ITeam>>> entrySet = teamsInDivision.entrySet();
                IDivision divisionName = null;
                for (Map.Entry<IDivision, List<ITeam>> iterate : entrySet) {
                    if (iterate.getValue().contains(team)) {
                        divisionName = iterate.getKey();
                    }
                }
                startDate = scheduleRegularSeasonGames(conference, divisionName, team, startDate);
            }
        }
    }

    private String scheduleRegularSeasonGames(IConference conferenceName, IDivision divisionName, ITeam teamName, String startDateOfSeason) throws ParseException {
        String currentDate = startDateOfSeason;
        currentDate = scheduleIntraDivGames(divisionName, teamName, currentDate);
        currentDate = scheduleInterDivGames(conferenceName, divisionName, teamName, currentDate);
        currentDate = scheduleInterConfGames(conferenceName, teamName, currentDate);
        return currentDate;
    }

    private String scheduleIntraDivGames(IDivision divisionName, ITeam teamName, String currentDate) throws ParseException {
        List<ITeam> teamsInDiv = teamsInDivision.get(divisionName);
        currentDate = schedule(teamsInDiv, teamName, currentDate);
        return currentDate;
    }

    private String scheduleInterDivGames(IConference conferenceName, IDivision divisionName, ITeam teamName, String currentDate) throws ParseException {
        List<ITeam> teamsInOtherDivision = new ArrayList<>();
        List<IDivision> divisionsInConf = divisionsInConference.get(conferenceName);

        for (Map.Entry<IDivision, List<ITeam>> entry : teamsInDivision.entrySet()) {
            if (divisionsInConf.contains(entry.getKey())) {
                if (entry.getKey().getDivisionName().equalsIgnoreCase(divisionName.getDivisionName())) {
                    continue;
                }
                teamsInOtherDivision.addAll(teamsInDivision.get(entry.getKey()));
            }
        }
        currentDate = schedule(teamsInOtherDivision, teamName, currentDate);
        return currentDate;
    }

    private String scheduleInterConfGames(IConference conferenceName, ITeam teamName, String currentDate) throws ParseException {
        List<ITeam> teamsInOtherConferences = new ArrayList<>();
        for (Map.Entry<IConference, List<ITeam>> entry : teamsInConference.entrySet()) {
            if (entry.getKey().getConferenceName().equalsIgnoreCase(conferenceName.getConferenceName())) {
                continue;
            }
            teamsInOtherConferences.addAll(teamsInConference.get(entry.getKey()));
        }
        currentDate = schedule(teamsInOtherConferences, teamName, currentDate);
        return currentDate;
    }


    public String schedule(List<ITeam> teamsInFormat, ITeam teamName, String currentScheduleDate) throws ParseException {
        int i = 0;
        //String currentScheduleDate = getFirstDayOfSeason();
        int gameCounter = 0;
        for (ITeam team : teamsInFormat) {
            if (gameCounter < 28) {
                if (team.getTeamName().equalsIgnoreCase(teamName.getTeamName())) {
                    continue;
                } else {
                    addSchedule(team, teamName, currentScheduleDate, Configurables.REGULAR.getAction());
                    boolean isIncrement = incrementCurrentDay(currentScheduleDate, lastDay);
                    if (isIncrement) {
                        currentScheduleDate = timeConcept.nextDate(currentScheduleDate);
                        gameCounter++;
                        continue;
                    } else {
                        currentScheduleDate = getFirstDayOfSeason();
                        gameCounter++;
                    }
                }
            } else {
                break;
            }
        }

        //  }
        return currentScheduleDate;

    }

    public void addSchedule(ITeam team, ITeam opponentTeam, String currentDay, String gameType) {

        ISchedulerSeason schedulerSeason = new SchedulerSeason();
        schedulerSeason.setFirstTeam(opponentTeam);
        schedulerSeason.setSecondTeam(team);
        schedulerSeason.setDateOfMatch(currentDay);
        schedulerSeason.setStatus(Configurables.SCHEDULED.getAction());
        schedulerSeason.setGameType(gameType);
        scheduleList.add(schedulerSeason);
    }

    public void playoffSchedule(StateMachine machine) throws ParseException {
        this.playoffsYear = machine.getPlayoffsYear();
        sortedTeamListPlayoff = new ArrayList<>();
        scheduleList = new ArrayList<>();
        Map<ITeam, Integer> teamListPlayoff = new HashMap<>();
        List<ITeam> finalPlayoffList = new ArrayList<>();
        ILeague league = machine.getLeague();
        String playoffStartDate = getFirstDayOfStanleyPlayoffs();
        String playoffEndDate = getLastDayOfStanleyPlayoffs();
        league.getTeamStandingList().sort((team1, team2) -> Integer.compare(team1.getTotalPoints(), team2.getTotalPoints()));
        sortedTeamListPlayoff = league.getTeamStandingList().subList(0, 10);
        for (ITeamStanding team : sortedTeamListPlayoff) {
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
                    addSchedule(firstTeam, opponentTeam, playoffStartDate, Configurables.PLAYOFF.getAction());
                    boolean isLateDate = incrementCurrentDay(playoffStartDate, playoffEndDate);
                    if (isLateDate) {
                        playoffStartDate = getFirstDayOfStanleyPlayoffs();
                    } else {
                        continue;
                    }
                }
            }
        }
        league.setSchedules(scheduleList);

    }

    @Override
    public ITeam getFirstTeam() {
        return firstTeam;
    }

    @Override
    public ITeam getSecondTeam() {
        return secondTeam;
    }

    @Override
    public String getDateOfMatch() {
        return matchDate;
    }

    @Override
    public String getGameType() {
        return gameType;
    }

    @Override
    public String getStatus() {
        return matchStatus;
    }

    @Override
    public void setFirstTeam(ITeam teamFirst) {
        this.firstTeam = teamFirst;

    }

    @Override
    public void setSecondTeam(ITeam teamSecond) {
        this.secondTeam = teamSecond;

    }

    @Override
    public void setDateOfMatch(String date) {
        this.matchDate = date;

    }

    @Override
    public void setGameType(String gameType) {
        this.gameType = gameType;

    }

    @Override
    public void setStatus(String status) {
        this.matchStatus = status;
    }

}

//References
//Convert map element ( key=value) to string value: https://stackoverflow.com/questions/43177542/list-of-map-entrystring-string
//Convert map element ( key=value) to string value: https://www.geeksforgeeks.org/map-entry-interface-java-example/

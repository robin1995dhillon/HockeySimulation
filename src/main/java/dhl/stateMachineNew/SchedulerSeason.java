package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import org.joda.time.DateTime;
import org.joda.time.Days;

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
public class SchedulerSeason implements ISchedulerSeason{
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
    private List<ISchedulerSeason> scheduleList;


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


    SchedulerSeason(Calendar calendar, IUserOutput output) {
        this.totalDivisions = 0;
        this.totalTeams = 0;
        this.calendar = calendar;
        this.output = output;

        //Model lists
        conferenceList = new ArrayList<>();
        divisionList = new ArrayList<>();
        teamList = new ArrayList<>();

        //Model mappers
        teamsInConference = new HashMap<>();
        teamsInDivision = new HashMap<>();
        divisionsInConference = new HashMap<>();
        scheduledMatches = new HashMap<ITeam, Integer>();

    }

    SchedulerSeason(Calendar calendar, int currentSeason) {
        this.currentSeason = currentSeason;
        this.calendar = calendar;
        int currentYear = this.calendar.get(Calendar.YEAR);
        currentYear += this.currentSeason;
        this.currentYear = String.valueOf(currentYear);
        this.regSeasonYear = currentYear;
        this.playoffsYear = currentYear + 1;
    }

    SchedulerSeason(){}

    public String getStartDayOfSeason() {
        String startDate = "30-09-" + this.currentYear;

        return startDate;
    }

    /**
     * Season start date: 1st October
     **/
    public String getFirstDayOfSeason() {
        String firstDay = "1-10-" + this.currentYear;

        return firstDay;
    }

    /**
     * Season end date: First Saturday in April
     **/
    public String getLastDayOfSeason() {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, playoffsYear);
        String dDay = String.valueOf(calendar.get(Calendar.DATE));
        String lastDay = dDay + "-04-" + String.valueOf(playoffsYear);

        return lastDay;
    }

    /**
     * Stanley Playoffs start date: Second Wednesday in April
     **/
    public String getFirstDayOfStanleyPlayoffs() {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.YEAR, playoffsYear);

        return String.valueOf(calendar.get(Calendar.DATE));
    }

    /**
     * Stanley Playoffs end date: June 1st
     **/
    public String getLastDayOfStanleyPlayoffs() {
        String lastDay = "1-06-" + String.valueOf(playoffsYear);

        return lastDay;
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

    public boolean isLastDayOfTrade(String currentDate) {
        String lastDayOfTrade = getLastDayOfTrade() + "-02-" + String.valueOf(playoffsYear);
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

    public boolean isLastDayOfSeason(String currentDate) {
        try {
            Date start = new SimpleDateFormat("dd-MM-yyyy").parse(currentDate);
            Date end = new SimpleDateFormat("dd-MM-yyyy").parse(getLastDayOfStanleyPlayoffs());
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

    public void generateSchedule(ILeague league) {
        scheduleList = new ArrayList<>();
        initialize(league);
        for(IConference conference : league.getConferences()){
            for(IDivision division : conference.getDivisions()){
                for(ITeam team : division.getTeams()){
                    incrementCurrentDay();
                    //setMatches();
                    createSchedule();
                }
            }
        }
        // add this in league.setSchedule.

    }


    public boolean incrementCurrentDay() {

        if (currentDay.equals(lastDay)) {
            return false;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try {
                calendar.setTime(dateFormat.parse(currentDay));
            } catch (ParseException e) {
                output.setOutput("Exception while getting current date in Advance Time state");
                output.sendOutput();
            }

            // add a day to current date if it is not last date for the season
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            currentDay = dateFormat.format(calendar.getTime());
            return true;
        }
    }

    private void initialize(ILeague league) {

        ArrayList<IConference> retrievedConferences = league.getConferences();

        for (int i = 0; i < retrievedConferences.size(); i++) {
            IConference conferenceName = retrievedConferences.get(i);
            ArrayList<IDivision> retrievedDivisions = retrievedConferences.get(i).getDivisions();

            this.conferenceList.add(conferenceName);
            this.totalDivisions += retrievedDivisions.size();

            for (int j = 0; j < retrievedDivisions.size(); j++) {
                IDivision divisionName = retrievedDivisions.get(j);
                ArrayList<ITeam> retrievedTeams = retrievedDivisions.get(j).getTeams();

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

    private void setMatches() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(firstDay);
            d2 = sdf.parse(lastDay);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            int totalDays = Days.daysBetween(dt1, dt2).getDays();
            int totalMatches = (totalTeams * 82);
            double temp = Math.ceil(((double) totalMatches / (double) totalDays));
            int count = (int) temp;
            matchesPerDay = count;
            System.out.println("Total days: " + totalDays + "\nMatches per day: " + matchesPerDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void createSchedule() {

        for (IConference conference : conferenceList) {

            List<ITeam> teamsInConf = teamsInConference.get(conference);
            for (ITeam team : teamsInConf) {

                Set<Map.Entry<IDivision, List<ITeam>>> entrySet = teamsInDivision.entrySet();
                IDivision divisionName = null;
                for (Map.Entry<IDivision, List<ITeam>> itr : entrySet) {
                    if (itr.getValue().contains(team)) {
                        divisionName = itr.getKey();
                    }
                }
                scheduleRegularSeasonGames(conference, divisionName, team);
            }
        }
    }

    private void scheduleRegularSeasonGames(IConference conferenceName, IDivision divisionName, ITeam teamName) {
        scheduleIntraDivGames(divisionName, teamName);
        scheduleInterDivGames(conferenceName, divisionName, teamName);
        scheduleInterConfGames(conferenceName, teamName);
    }

    private void scheduleIntraDivGames(IDivision divisionName, ITeam teamName) {
        List<ITeam> teamsInDiv = teamsInDivision.get(divisionName);
        schedule(teamsInDiv, teamName);
    }

    private void scheduleInterDivGames(IConference conferenceName, IDivision divisionName, ITeam teamName) {
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
        schedule(teamsInOtherDivision, teamName);
    }

    private void scheduleInterConfGames(IConference conferenceName, ITeam teamName) {
        List<ITeam> teamsInOtherConferences = new ArrayList<>();
        for (Map.Entry<IConference, List<ITeam>> entry : teamsInConference.entrySet()) {
            if (entry.getKey().getConferenceName().equalsIgnoreCase(conferenceName.getConferenceName())) {
                continue;
            }
            teamsInOtherConferences.addAll(teamsInConference.get(entry.getKey()));
        }
        schedule(teamsInOtherConferences, teamName);
    }


    private void schedule(List<ITeam> teamsInFormat, ITeam teamName) {
        int matchCounter = 0;
        //int loopCounter = 28 / (teamsInFormat.size() - 1);
        int i = 0;
        int gameCounter = 0;

        for (ITeam team : teamsInFormat) {
            while (gameCounter < 28){
                if (team.getTeamName().equalsIgnoreCase(teamName.getTeamName())) {
                    continue;
                } else {

                     addSchedule(team, teamName, currentDay, Configurables.REGULAR.getAction());
                     incrementCurrentDay();
                }
            }

        }

    }

    public void addSchedule(ITeam team, ITeam teamName, String currentDay, String gameType) {

        ISchedulerSeason schedulerSeason = new SchedulerSeason();
        schedulerSeason.setFirstTeam(teamName);
        schedulerSeason.setSecondTeam(team);
        schedulerSeason.setDateOfMatch(currentDay);
        schedulerSeason.setStatus(Configurables.SCHEDULED.getAction());
        schedulerSeason.setGameType(gameType);
        scheduleList.add(schedulerSeason);
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

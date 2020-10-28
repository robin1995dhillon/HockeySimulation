package dhl.InternalStateMachine;

import dhl.InOut.IUserOutput;
import dhl.LeagueModel.IConference;
import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.ILeague;
import dhl.LeagueModel.ITeam2;
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
public class Scheduler {
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
    private boolean isWinnerDeclared; // Stanley cup winner decided
    private String lastSeasonDay;
    private String seasonWinner;
    private boolean isSeasonOver;
    private Calendar calendar;
    private IUserOutput output;
    private Map<String, List<Map<String, String>>> finalSchedule;
    private List<String> conferenceList;
    private List<String> divisionList;
    private List<String> teamList;
    private Map<String, List<String>> teamsInConference;
    private Map<String, List<String>> teamsInDivision;
    private Map<String, List<String>> divisionsInConference;
    private Map<String, Integer> matchScheduledForTeam;
    private Map<String, Integer> matchesOnADay;


    Scheduler(Calendar calendar, IUserOutput output) {
        this.totalDivisions = 0;
        this.totalTeams = 0;
        this.calendar = calendar;
        this.output = output;

        //Model lists
        conferenceList = new ArrayList<String>();
        divisionList = new ArrayList<String>();
        teamList = new ArrayList<String>();

        //Model mappers
        teamsInConference = new HashMap<String, List<String>>();
        teamsInDivision = new HashMap<String, List<String>>();
        divisionsInConference = new HashMap<String, List<String>>();
        matchScheduledForTeam = new HashMap<String, Integer>();
        finalSchedule = new HashMap<String, List<Map<String, String>>>();
        matchesOnADay = new HashMap<String, Integer>();

    }

    Scheduler(Calendar calendar, int currentSeason) {
        this.currentSeason = currentSeason;
        this.calendar = calendar;
        int currentYear = this.calendar.get(Calendar.YEAR);
        currentYear += this.currentSeason;
        this.currentYear = String.valueOf(currentYear);
        this.regSeasonYear = currentYear;
        this.playoffsYear = currentYear + 1;
    }

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
//        matchesOnADay.put(this.currentDay, 0);
    }

    public String getCurrentDay() {
        return this.currentDay;
    }

    public String getSeasonWinner() {
        return seasonWinner;
    }

    public void setSeasonWinner(String seasonWinner) {
        this.seasonWinner = seasonWinner;
    }

    public void setSeasonOverStatus(boolean over) {
        this.isSeasonOver = over;
    }

    public boolean getSeasonOverStatus() {
        return isSeasonOver;
    }

    public void setLastSeasonDay(String date) {
        this.lastSeasonDay = date;
    }

    public String getLastSeasonDay() {
        return this.lastSeasonDay;
    }

    public void generateSchedule(ILeague league) {
        incrementCurrentDay();
        initModel(league);
        setMatchesPerDay();
        createSchedule();
    }

    public Map<String, List<Map<String, String>>> getFinalSchedule() {
        return this.finalSchedule;
    }

    public void setFinalSchedule(Map<String, List<Map<String, String>>> schedule) {
        this.finalSchedule = schedule;
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

    private void initModel(ILeague league) {

        ArrayList<IConference> retrievedConferences = league.getConferences();

        for (int i = 0; i < retrievedConferences.size(); i++) {
            String conferenceName = retrievedConferences.get(i).getConferenceName();
            ArrayList<IDivision> retrievedDivisions = retrievedConferences.get(i).getDivisions();

            this.conferenceList.add(conferenceName);
            this.totalDivisions += retrievedDivisions.size();

            for (int j = 0; j < retrievedDivisions.size(); j++) {
                String divisionName = retrievedDivisions.get(j).getDivisionName();
                ArrayList<ITeam2> retrievedTeams = retrievedDivisions.get(j).getTeams();

                this.divisionList.add(divisionName);
                this.totalTeams += retrievedTeams.size();

                for (int k = 0; k < retrievedTeams.size(); k++) {
                    String teamName = retrievedTeams.get(k).getTeamName();

                    this.teamList.add(teamName);
                    matchScheduledForTeam.put(teamName, 0);
                }

                teamsInConference.put(conferenceName, teamList);
                teamsInDivision.put(divisionName, teamList);
            }
            divisionsInConference.put(conferenceName, divisionList);
        }

    }

    private void setMatchesPerDay() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(firstDay);
            d2 = sdf.parse(lastDay);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            int totalDays = Days.daysBetween(dt1, dt2).getDays();
            int totalMatches = (totalTeams * 84);
            //Each team plays at least 82 matches but we bring it to 84 to get a nice round off for 84 / 3 = 28
            double temp = Math.ceil(((double) totalMatches / (double) totalDays));
            int count = (int) temp;
            matchesPerDay = count;
            System.out.println("Total days: " + totalDays + "\nMatches per day: " + matchesPerDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void createSchedule() {

        for (String conference : conferenceList) {

            List<String> teamsInConf = teamsInConference.get(conference);
            for (String team : teamsInConf) {

                Set<Map.Entry<String, List<String>>> entrySet = teamsInDivision.entrySet();
                String divisionName = "";
                for (Map.Entry<String, List<String>> itr : entrySet) {
                    if (itr.getValue().contains(team)) {
                        divisionName = itr.getKey();
                    }
                }
                scheduleRegularSeasonGames(conference, divisionName, team);
            }
        }
    }

    private void scheduleRegularSeasonGames(String conferenceName, String divisionName, String teamName) {
        scheduleIntraDivGames(divisionName, teamName);
        scheduleInterDivGames(conferenceName, divisionName, teamName);
        scheduleInterConfGames(conferenceName, teamName);
    }

    private void scheduleIntraDivGames(String divisionName, String teamName) {
        List<String> teamsInDiv = teamsInDivision.get(divisionName);
        schedule(teamsInDiv, teamName);
    }

    private void scheduleInterDivGames(String conferenceName, String divisionName, String teamName) {
        List<String> teamsInOtherDivision = new ArrayList<>();
        List<String> divisionsInConf = divisionsInConference.get(conferenceName);

        for (Map.Entry<String, List<String>> entry : teamsInDivision.entrySet()) {
            if (divisionsInConf.contains(entry.getKey())) {
                if (entry.getKey().equalsIgnoreCase(divisionName)) {
                    continue;
                }
                teamsInOtherDivision.addAll(teamsInDivision.get(entry.getKey()));
            }
        }
        schedule(teamsInOtherDivision, teamName);
    }

    private void scheduleInterConfGames(String conferenceName, String teamName) {
        List<String> teamsInOtherConferences = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : teamsInConference.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(conferenceName)) {
                continue;
            }
            teamsInOtherConferences.addAll(teamsInConference.get(entry.getKey()));
        }
        schedule(teamsInOtherConferences, teamName);
    }


    private void schedule(List<String> teamsInFormat, String teamName) {
        int matchCounter = 0;
        int loopCounter = 28 / (teamsInFormat.size() - 1);
        int i = 0;
        do {
            for (String team : teamsInFormat) {
                if (team.equalsIgnoreCase(teamName)) {
                    continue;
                }
                if (matchScheduledForTeam.containsKey(teamName) && matchCounter < 29) {
                    if (matchesOnADay.get(currentDay) < matchesPerDay) {
                        Map<String, String> teamsCompeting = new HashMap<String, String>();
                        teamsCompeting.put(teamName, team);

                        if (finalSchedule.containsKey(currentDay)) {
                            List<Map<String, String>> matchList = finalSchedule.get(currentDay);
                            matchList.add(teamsCompeting);
                            finalSchedule.put(currentDay, matchList);
                        } else {
                            List<Map<String, String>> matchList = new ArrayList<>();
                            matchList.add(teamsCompeting);
                            finalSchedule.put(currentDay, matchList);
                        }

                        if (matchesOnADay.containsKey(currentDay)) {
                            int matchCount = matchesOnADay.get(currentDay);
                            matchesOnADay.put(currentDay, matchCount + 1);
                        } else {
                            matchesOnADay.put(currentDay, 1);
                        }
                        matchCounter++;

                    } else {
                        incrementCurrentDay();
                        Map<String, String> teamsCompeting = new HashMap<String, String>();
                        teamsCompeting.put(teamName, team);


                        if (finalSchedule.containsKey(currentDay)) {
                            List<Map<String, String>> matchList = finalSchedule.get(currentDay);
                            matchList.add(teamsCompeting);
                            finalSchedule.put(currentDay, matchList);
                        } else {
                            List<Map<String, String>> matchList = new ArrayList<>();
                            matchList.add(teamsCompeting);
                            finalSchedule.put(currentDay, matchList);
                        }

                        if (matchesOnADay.containsKey(currentDay)) {
                            int matchCount = matchesOnADay.get(currentDay);
                            matchesOnADay.put(currentDay, matchCount + 1);
                        } else {
                            matchesOnADay.put(currentDay, 1);
                        }
                        matchCounter++;
                    }
                    int totalMatchForATeam = matchScheduledForTeam.get(teamName);
                    matchScheduledForTeam.put(teamName, totalMatchForATeam + 1);
                } else {
                    break;
                }
            }
            i++;
        } while (i < loopCounter + 1);
    }
}

//References
//Line No: Convert map element ( key=value) to string value: https://stackoverflow.com/questions/43177542/list-of-map-entrystring-string
//Line No: Convert map element ( key=value) to string value: https://www.geeksforgeeks.org/map-entry-interface-java-example/

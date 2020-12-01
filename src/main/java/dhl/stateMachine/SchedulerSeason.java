package dhl.stateMachine;

import dhl.Configurables;
import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SchedulerSeason implements ISchedulerSeason {
    private String currentYear;
    private int regSeasonYear;
    private int playoffsYear;
    private int currentSeason;
    private String currentDay;
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

    private Map<IConference, List<ITeam>> teamsInConference;
    private Map<IDivision, List<ITeam>> teamsInDivision;
    private Map<IConference, List<IDivision>> divisionsInConference;
    private Map<ITeam, Integer> scheduledMatches;
    private StateMachine machine;
    private ITime timeConcept;

    public SchedulerSeason() {
        timeConcept = new LeagueTimeConcept();
        calendar = Calendar.getInstance();
    }

    public String getStartDayOfSeason() {
        String startDate = Configurables.START_DAY_OF_SEASON.getAction() + this.currentYear;

        return startDate;
    }

    public String getFirstDayOfSeason() {
        String firstDay = "01-10-" + this.currentYear;

        return firstDay;
    }

    public String getLastDayOfSeason() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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

    @Override
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


    public String getLastDayOfStanleyPlayoffs() {
        String lastDay = "01-06-" + String.valueOf(playoffsYear);

        return lastDay;
    }

    public String enterIntoPlayerDraft() {
        String playerDraftDate = "15-07-" + String.valueOf(playoffsYear);

        return playerDraftDate;
    }

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
        List<ITeam> allTeamsList = new ArrayList<>();
        this.machine = machine;
        this.calendar = Calendar.getInstance();
        this.currentSeason = machine.getLeague().getSeason();
        int currentYear = this.calendar.get(Calendar.YEAR);
        currentYear += this.currentSeason;
        this.currentYear = String.valueOf(currentYear);
        this.regSeasonYear = currentYear;
        this.playoffsYear = currentYear + 1;
        machine.setPlayoffsYear(this.playoffsYear);
        scheduleList = new ArrayList<>();
        listTeamStanding = new ArrayList<>();
        String startDateOfSeason = getStartDayOfSeason();
        currentDay = getStartDayOfSeason();
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
                    allTeamsList.add(team);
                    teamStanding.setDivision(division.getDivisionName());
                    teamStanding.setConference(conference.getConferenceName());
                    teamStanding.setTeam(team);
                    listTeamStanding.add(teamStanding);
                    incrementCurrentDay(currentDay, lastDay);
                    createSchedule();

                }
            }
        }
        machine.getLeague().setSchedules(scheduleList);
        machine.getLeague().setTeamStandingList(listTeamStanding);
        machine.setTotalTeamList(allTeamsList);
    }


    public boolean incrementCurrentDay(String currentDay, String lastDay) throws ParseException {

        if (currentDay.equals(lastDay)) {
            return false;
        } else {
            String date = timeConcept.nextDate(currentDay);
            return true;
        }
    }


    public void initialize(ILeague league) {
        teamsInConference = new HashMap<>();
        teamsInDivision = new HashMap<>();
        divisionsInConference = new HashMap<>();
        scheduledMatches = new HashMap<>();

        for(IConference conference : league.getConferences()){
            List<ITeam> teamLists = new ArrayList<>();
            for(IDivision division : conference.getDivisions()){
                for(ITeam team : division.getTeams()){
                    teamLists.add(team);
                    scheduledMatches.put(team, 0);
                }
                teamsInDivision.put(division, division.getTeams());
                teamsInConference.put(conference, teamLists);
            }
            divisionsInConference.put(conference, conference.getDivisions());
        }
    }

    private void createSchedule() throws ParseException {

        String startDate = getFirstDayOfSeason();

        for (IConference conference : machine.getLeague().getConferences()) {

            List<ITeam> teamsInConf = teamsInConference.get(conference);
            for (ITeam team : teamsInConf) {

                Set<Map.Entry<IDivision, List<ITeam>>> entrySet = teamsInDivision.entrySet();
                for (Map.Entry<IDivision, List<ITeam>> iterate : entrySet) {
                    if (iterate.getValue().contains(team)) {
                        IDivision divisionName = iterate.getKey();
                        startDate = scheduleRegularSeasonGames(conference, divisionName, team, startDate);
                        break;
                    }
                }
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

    public String scheduleIntraDivGames(IDivision divisionName, ITeam teamName, String currentDate) throws ParseException {
        List<ITeam> teamsInDiv = teamsInDivision.get(divisionName);
        currentDate = schedule(teamsInDiv, teamName, currentDate);
        return currentDate;
    }

    public String scheduleInterDivGames(IConference conferenceName, IDivision divisionName, ITeam teamName, String currentDate) throws ParseException {
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

    public String scheduleInterConfGames(IConference conferenceName, ITeam teamName, String currentDate) throws ParseException {
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
        for (ITeam team : teamsInFormat) {
            if (team.getGameCount() < 82) {
                if (team.getTeamName().equalsIgnoreCase(teamName.getTeamName())) {
                    continue;
                } else {
                    addSchedule(team, teamName, currentScheduleDate, Configurables.REGULAR.getAction());
                    boolean isIncrement = incrementCurrentDay(currentScheduleDate, lastDay);
                    if (isIncrement) {
                        currentScheduleDate = timeConcept.nextDate(currentScheduleDate);
                        team.setGameCount(team.getGameCount() + 1);
                        continue;
                    } else {
                        currentScheduleDate = getFirstDayOfSeason();
                        team.setGameCount(team.getGameCount() + 1);
                    }
                }
            } else {
                break;
            }
        }
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
                    boolean isNotLateDate = incrementCurrentDay(playoffStartDate, playoffEndDate);
                    if (isNotLateDate) {
                        playoffStartDate = timeConcept.nextDate(playoffStartDate);
                        continue;
                    } else {
                        playoffStartDate = getFirstDayOfStanleyPlayoffs();
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

    public void setCurrentYear(String currentYear){
        this.currentYear = currentYear;
    }

    public void setPlayoffsYear(int playoffsYear){
        this.playoffsYear = playoffsYear;
    }

    public void setLastDayOfSeason(String lastDay){
        this.lastDay = lastDay;
    }

    public Map<IConference, List<IDivision>> getDivisionsInConference() {
        return divisionsInConference;
    }

    public void setDivisionsInConference(Map<IConference, List<IDivision>> divisionsInConference) {
        this.divisionsInConference = divisionsInConference;
    }

    public Map<IDivision, List<ITeam>> getTeamsInDivision() {
        return teamsInDivision;
    }

    public void setTeamsInDivision(Map<IDivision, List<ITeam>> teamsInDivision) {
        this.teamsInDivision = teamsInDivision;
    }

    public Map<IConference, List<ITeam>> getTeamsInConference() {
        return teamsInConference;
    }

    public void setTeamsInConference(Map<IConference, List<ITeam>> teamsInConference) {
        this.teamsInConference = teamsInConference;
    }

    public void setScheduleList(List<ISchedulerSeason> list){
        this.scheduleList = list;
    }

    public List<ISchedulerSeason> getScheduleList(){
        return this.scheduleList;
    }

}


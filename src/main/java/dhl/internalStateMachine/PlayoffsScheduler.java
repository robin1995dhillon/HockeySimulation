package dhl.internalStateMachine;

import dhl.inputOutput.IUserInput;
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


public class PlayoffsScheduler {
    private IUserInput input;
    private IUserOutput output;
    private String currentDay;
    private String firstDay;
    private String lastDay;
    private int seasonType;
    private Calendar calendar;
    private int matchesPerDay;
    private Map<String, List<String>> teamsInConference;
    private List<String> conferenceList;
    private List<String> divisionList;
    private List<String> teamList;

    PlayoffsScheduler(IUserInput input, IUserOutput output) {
        this.input = input;
        this.output = output;
        this.seasonType = 1;
        teamsInConference = new HashMap<>();

    }

    private void init(ILeague league) {
        if (league == null) {
            return;
        }
        ArrayList<IConference> retrievedConferences = league.getConferences();

        for (int i = 0; i < retrievedConferences.size(); i++) {
            String conferenceName = retrievedConferences.get(i).getConferenceName();
            ArrayList<IDivision> retrievedDivisions = retrievedConferences.get(i).getDivisions();

            this.conferenceList.add(conferenceName);

            for (int j = 0; j < retrievedDivisions.size(); j++) {
                String divisionName = retrievedDivisions.get(j).getDivisionName();
                ArrayList<ITeam> retrievedTeams = retrievedDivisions.get(j).getTeams();

                this.divisionList.add(divisionName);

                for (int k = 0; k < retrievedTeams.size(); k++) {
                    String teamName = retrievedTeams.get(k).getTeamName();
                    this.teamList.add(teamName);
                }
            }
        }
    }

    public void generate(List<String> teamsToCompete, String currentDay) {
        this.currentDay = currentDay;

        int totalTeams = teamsToCompete.size();
        for (int i = 0; i < totalTeams / 2; i++) {
            Map<String, String> teamsCompeting = new HashMap<String, String>();
            teamsCompeting.put(teamsToCompete.get(i), teamsToCompete.get(totalTeams - 1 - i));
            List<Map<String, String>> matchList = new ArrayList<>();
            matchList.add(teamsCompeting);

        }
    }

    private void scheduleMatches() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(firstDay);
            d2 = sdf.parse(lastDay);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            int totalDays = Days.daysBetween(dt1, dt2).getDays();
            int totalMatches = (100 * 84);
            //Each team plays at least 82 matches but we bring it to 84 to get a nice round off for 84 / 3 = 28
            double temp = Math.ceil(((double) totalMatches / (double) totalDays));
            int count = (int) temp;
            matchesPerDay = count;
            System.out.println("Total days: " + totalDays + "\nMatches per day: " + matchesPerDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean incrementDay() {

        if (currentDay.equals(lastDay)) {
            return false;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try {
                calendar.setTime(dateFormat.parse(currentDay));
            } catch (ParseException e) {
                output.setOutput("Exception while getting current date in Playoff Schedule state");
                output.sendOutput();
            }

            // add a day to current date if it is not last date for the season
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            currentDay = dateFormat.format(calendar.getTime());
            return true;
        }
    }


}

package dhl.simulationStateMachine;

import dhl.database.*;
import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.*;
import dhl.StoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreateTeamState implements IState {
    private ILeague league;
    private StateContext context;
    private IUserInput input;
    private IUserOutput output;
    private String stateName;
    private String nextStateName;
    private String teamName;

    public CreateTeamState(ILeague league, StateContext context, IUserInput input, IUserOutput output, String teamName) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.teamName = teamName;
        this.stateName = "CreateTeamState";
    }

    public void runState() {
        List<IConference> Conference;
        List<IDivision> Divisions;
        List<ITeam> Teams;
        List<IPlayers> Players;
        IHeadCoach HeadCoach;
        if (league == null){
            return;
        }
        String leagueName = league.getLeagueName();
        System.out.println("entering saveLeague Method");
        JSONObject league_obj = saveLeague(leagueName);
        boolean league_bool = (boolean) league_obj.get("Status");
        int league_id = (int) league_obj.get("id");
        if (league_bool) {
            Conference = league.getConferences();
            for (IConference c : Conference) {
                JSONObject conference_obj = saveConference(c.getConferenceName());
                boolean conference_bool = (boolean) conference_obj.get("Status");
                int conference_id = (int) conference_obj.get("id");
                if (conference_bool) {
                    Divisions = c.getDivisions();
                    for (IDivision d : Divisions) {
                        JSONObject division_obj = saveDivision(d.getDivisionName());
                        boolean division_bool = (boolean) division_obj.get("Status");
                        int division_id = (int) division_obj.get("id");
                        if (division_bool) {
                            Teams = d.getTeams();
                            for (ITeam t : Teams) {
                                Players = t.getPlayers();
                                HeadCoach = t.getHeadCoach();
                                JSONObject team_obj = saveTeam(t.getTeamName(), t.getGeneralManager());
                                boolean team_bool = (boolean) team_obj.get("Status");
                                int team_id = (int) team_obj.get("id");
                                if (team_bool) {
                                    saveDHL(league_id, conference_id, division_id, team_id);
                                    for (IPlayers p : Players) {
                                        savePlayer(p.getPlayerName(), p.getPosition(), p.getCaptain(), team_id  );
                                    }
                                }
                            }
                        } else {
                            System.out.println("Something went wrong in division");
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Something went wrong in conference");
                    System.exit(0);
                }
            }

        } else {
            System.out.println("Something went wrong in League");
            System.exit(0);
        }
        System.exit(0);
    }

    public JSONObject saveLeague(String leagueName) {
        JSONObject return_obj = new JSONObject();
        System.out.println("entering stored procedure");
//        StoredProcedure SP = new StoredProcedure("create_league");
//        SP.addParameter(leagueName);
        ICreateStoredProcedure s = new CreateLeague(leagueName);
        try {
            s.executeProcedure();
            int league_id = s.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", league_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);
        }
        return return_obj;
    }

    public JSONObject saveConference(String conferenceName) {
        JSONObject return_obj = new JSONObject();
//        StoredProcedure SP = new StoredProcedure("create_conference");
//        SP.addParameter(conferenceName);
        ICreateStoredProcedure SP = new CreateConference(conferenceName);
        try {
            SP.executeProcedure();
            int conference_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", conference_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);
        }
        return return_obj;
    }

    public JSONObject saveDivision(String divisionName) {
        JSONObject return_obj = new JSONObject();
//        StoredProcedure SP = new StoredProcedure("create_division");
//        SP.addParameter(divisionName);
        ICreateStoredProcedure SP = new CreateDivision("Atlantic");
        try {
            SP.executeProcedure();
            int division_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", division_id);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);

        }
        return return_obj;
    }

    public JSONObject saveTeam(String teamName, String generalManager) {
        JSONObject return_obj = new JSONObject();
        StoredProcedure SP = new StoredProcedure("create_team");
//        SP.addParameter(teamName, generalManager);
//
//        try {
//            SP.executeProcedure();
//            int team_id = SP.getInsertedId();
//            return_obj.put("Status", true);
//            return_obj.put("id", team_id);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return_obj.put("Status", false);
//            return_obj.put("id", null);
//        }
        return return_obj;
    }

    public boolean savePlayer(String playerName, String position, boolean captain, int team_id) {
        StoredProcedure SP = new StoredProcedure("create_player");
        SP.addParameter(playerName, position, captain, team_id);
        ICreateStoredProcedure s = new CreatePlayer("zongyu", "goalie", false, 22,10,4,9,18,1, false,false,0);
        try {
            SP.executeProcedure();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean saveDHL(int league_id, int conference_id, int division_id, int team_id) {
        ICreateStoredProcedure SP = new CreateDHLTable(league_id,conference_id,division_id, team_id);
//        StoredProcedure SP = new StoredProcedure("create_DHL_table");
//        SP.addParameter(league_id, conference_id, division_id, team_id);
        try {
            SP.executeProcedure();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void forward(StateContext context) {
        this.nextStateName = "SimulateLeagueState";
        context.setState(new SimulateLeagueState(league, input, output, teamName));
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }
}

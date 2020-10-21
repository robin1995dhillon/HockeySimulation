package dhl.SimulationStateMachine;

import dhl.LeagueModel.*;
import dhl.StoredProcedure;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CreateTeamState {

    public CreateTeamState() {

    }

    public boolean SaveToDB(ILeague ILeague) {
        ArrayList<IConference> IConference;
        ArrayList<IDivision> IDivisions;
        ArrayList<ITeam2> ITeam2;
        ArrayList<IPlayers2> IPlayers2;
        IHeadCoach IHeadCoach;

        String leagueName = ILeague.getLeagueName();
        System.out.println("entering saveLeague Method");   //commenttt
        JSONObject league_obj = saveLeague(leagueName);
        boolean league_bool = (boolean) league_obj.get("Status");
        int league_id = (int) league_obj.get("id");
        if (league_bool) {
            IConference = ILeague.getConferences();
            for (IConference c : IConference) {
                JSONObject conference_obj = saveConference(c.getConferenceName());
                boolean conference_bool = (boolean) conference_obj.get("Status");
                int conference_id = (int) conference_obj.get("id");
                if (conference_bool) {
                    IDivisions = c.getDivisions();
                    for (IDivision d : IDivisions) {
                        JSONObject division_obj = saveDivision(d.getDivisionName());
                        boolean division_bool = (boolean) division_obj.get("Status");
                        int division_id = (int) division_obj.get("id");
                        if (division_bool) {
                            ITeam2 = d.getTeams();
                            for (ITeam2 t : ITeam2) {
                                IPlayers2 = t.getPlayers();
                                IHeadCoach = t.getHeadCoach();

                                JSONObject team_obj = saveTeam(t.getTeamName(), t.getGeneralManager());
                                boolean team_bool = (boolean) team_obj.get("Status");
                                int team_id = (int) team_obj.get("id");
                                if (team_bool) {
                                    saveDHL(league_id, conference_id, division_id, team_id);
//                                    for (Players p : Players) {
//                                        savePlayer(p.getPlayerName(), p.getPosition(), p.getCaptain(), team_id);
//                                    }
                                }
                            }
                        } else {
                            System.out.println("Something went wrong in division");
                            return false;
                        }
                    }
                } else {
                    System.out.println("Something went wrong in conference");
                    return false;
                }
            }

        } else {
            System.out.println("Something went wrong in League");
            return false;
        }
        return false;
    }

    public JSONObject saveLeague(String leagueName) {
        JSONObject return_obj = new JSONObject();
        System.out.println("entering stored procedure");
        StoredProcedure SP = new StoredProcedure("create_league");
        SP.addParameter(leagueName);

        try {
            SP.executeProcedure();
            int league_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", league_id);
        } catch (IOException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);
        }
        return return_obj;
    }

    public JSONObject saveConference(String conferenceName) {
        JSONObject return_obj = new JSONObject();
        StoredProcedure SP = new StoredProcedure("create_conference");
        SP.addParameter(conferenceName);
        try {
            SP.executeProcedure();
            int conference_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", conference_id);
        } catch (IOException e) {
            e.printStackTrace();
            return_obj.put("Status", false);
            return_obj.put("id", null);
        }
        return return_obj;
    }

    public JSONObject saveDivision(String divisionName) {
        JSONObject return_obj = new JSONObject();
        StoredProcedure SP = new StoredProcedure("create_division");
        SP.addParameter(divisionName);
        try {
            SP.executeProcedure();
            int division_id = SP.getInsertedId();
            return_obj.put("Status", true);
            return_obj.put("id", division_id);
        } catch (IOException e) {
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
        try {
            SP.executeProcedure();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean saveDHL(int league_id, int conference_id, int division_id, int team_id) {
        StoredProcedure SP = new StoredProcedure("create_DHL_table");
        SP.addParameter(league_id, conference_id, division_id, team_id);
        try {
            SP.executeProcedure();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

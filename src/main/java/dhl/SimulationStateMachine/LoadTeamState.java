package dhl.SimulationStateMachine;

import dhl.StoredProcedure;

import java.io.IOException;

public class LoadTeamState {

    public boolean loadTeam(String teamName) {
        StoredProcedure SP = new StoredProcedure("check_team");
        SP.addParameter(teamName);
        boolean is_exist = false;
        try {
            SP.executeProcedure();
            is_exist = SP.getExist();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is_exist;
    }
}

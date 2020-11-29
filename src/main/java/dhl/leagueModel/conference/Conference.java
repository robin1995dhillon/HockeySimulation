package dhl.leagueModel.conference;

import dhl.inputOutput.UserOutput;
import dhl.leagueModel.division.IDivision;
import dhl.Configurables;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Conference implements IConference {

    private String conferenceName;
    private List<IDivision> divisions;
    private UserOutput userOutput = new UserOutput();

    public Conference() {
    }

    public Conference(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Conference(String conferenceName, List<IDivision> division) {
        this.conferenceName = conferenceName;
        this.divisions = division;
    }

    @Override
    public String getConferenceName() {
        return conferenceName;
    }

    @Override
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    @Override
    public List<IDivision> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(List<IDivision> divisions) {
        this.divisions = divisions;
    }


}

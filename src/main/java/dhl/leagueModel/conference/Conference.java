package dhl.leagueModel.conference;

import dhl.leagueModel.division.IDivision;
import dhl.persistence.saving.ConferencePersistence;
import dhl.persistence.saving.IConferencePersistence;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Conference implements IConference {

    String conferenceName;
    ArrayList<IDivision> divisions;

    public Conference() {
    }

    public Conference(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Conference(String conferenceName, ArrayList<IDivision> division) {
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
    public ArrayList<IDivision> getDivisions() {
        return divisions;
    }

    @Override
    public void setDivisions(ArrayList<IDivision> divisions) {
        this.divisions = divisions;
    }

    @Override
    public void saveConference(List<Integer> DhlID) {

        IConferencePersistence conferencePersistence = new ConferencePersistence();
        System.out.println("Saving Conference: " + this.conferenceName);
        JSONObject resultObject = conferencePersistence.saveConferenceToDB(this.conferenceName);
        List<IDivision> divisionArray = this.getDivisions();
        int conferenceID = (int) resultObject.get("id");
        DhlID.add(1,conferenceID);
        for(IDivision d: divisionArray) {
            d.saveDivision(DhlID);
        }
    }
}

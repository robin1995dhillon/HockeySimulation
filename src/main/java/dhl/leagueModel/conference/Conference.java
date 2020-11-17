package dhl.leagueModel.conference;

import dhl.inputOutput.UserOutput;
import dhl.leagueModel.division.IDivision;
import dhl.Configurables;
import dhl.persistence.saving.ConferencePersistence;
import dhl.persistence.saving.IConferencePersistence;
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

    @Override
    public void saveConference(List<Integer> DhlID) {

        IConferencePersistence conferencePersistence = new ConferencePersistence();
        userOutput.setOutput("Saving Conference: " + this.conferenceName);
        userOutput.sendOutput();
        JSONObject resultObject = conferencePersistence.saveConferenceToDB(this.conferenceName);
        List<IDivision> divisionArray = this.getDivisions();
        int conferenceID = (int) resultObject.get(Configurables.ID.getAction());
        DhlID.add(1, conferenceID);
        for (IDivision d : divisionArray) {
            d.saveDivision(DhlID);
        }
    }
}

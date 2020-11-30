package dhl.mock;

import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.LeagueModelAbstractFactory;

public class MockConference {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IConference conference;
    IDivision division;

    public MockConference() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        conference = leagueModelAbstractFactory.getConference();
        division = leagueModelAbstractFactory.getDivision();
    }

//    public IConference createConferenceMock() {
//        this.conference.setConferenceName("Conference1");
//        this.conference.setDivisions();
//    }
}

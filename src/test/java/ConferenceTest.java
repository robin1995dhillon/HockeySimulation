import dhl.LeagueModel.Conference;
import org.junit.jupiter.api.Test;

class ConferenceTest {

    @Test
    void getConferenceName() {
        Conference conference = new Conference("Eastern");
        conference.getConferenceName();
    }

    @Test
    void setConferenceName() {
        Conference conference = new Conference("Eastern");
        conference.setConferenceName("Western");
        System.out.println(conference.getConferenceName());

    }
}
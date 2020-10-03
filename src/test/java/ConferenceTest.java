import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
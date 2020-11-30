package dhl.leagueModel;

import dhl.mock.MockHeadCoach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeadCoachTest {

    MockHeadCoach mockHeadCoach;
    IHeadCoach headCoach;

    public HeadCoachTest() {
        mockHeadCoach = new MockHeadCoach();
    }

    @Test
    void getName() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        assertEquals("Head1", headCoach.getName());
    }

    @Test
    void setName() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        headCoach.setName("Head2");
        assertEquals("Head2", headCoach.getName());
    }

    @Test
    void getSkating() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        assertEquals(17, headCoach.getSkating());
    }

    @Test
    void setSkating() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        headCoach.setSkating(18);
        assertEquals(18, headCoach.getSkating());
    }

    @Test
    void getShooting() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        assertEquals(15, headCoach.getShooting());
    }

    @Test
    void setShooting() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        headCoach.setShooting(20);
        assertEquals(20, headCoach.getShooting());
    }

    @Test
    void getChecking() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        assertEquals(16, headCoach.getChecking());
    }

    @Test
    void setChecking() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        headCoach.setChecking(20);
        assertEquals(20, headCoach.getChecking());
    }

    @Test
    void getSaving() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        assertEquals(14, headCoach.getSaving());
    }

    @Test
    void setSaving() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        headCoach.setSaving(15);
        assertEquals(15, headCoach.getSaving());
    }

    @Test
    void getCoachFromList() {
        ArrayList<IHeadCoach> coachList = new ArrayList<>();
        headCoach = MockHeadCoach.createMock();
        coachList.add(headCoach);
        assertEquals(headCoach, headCoach.getCoachFromList(coachList, "Head1"));
    }

}

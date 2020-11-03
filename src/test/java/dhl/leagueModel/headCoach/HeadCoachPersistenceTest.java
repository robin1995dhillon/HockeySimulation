package dhl.leagueModel.headCoach;

import dhl.persistence.saving.HeadCoachPersistence;
import dhl.persistence.saving.IHeadCoachPersistence;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeadCoachPersistenceTest {

    @Test
    void saveHeadCoachToDB() {
        IHeadCoachPersistence headCoachPersistence = new HeadCoachPersistence();
        double[] headCoachAttributes = {13, 14, 15, 15};
        JSONObject resultObject = headCoachPersistence.saveHeadCoachToDB("Head1", headCoachAttributes, 2);
        assertEquals(true, resultObject.get("Status"));
    }
}

package dhl.presentation;

import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.mock.MockManager;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DisplayManagerListTest {
    @Test
    public void displayManagerTest() {
        List<IGeneralManager> managerList = MockManager.createMock();
        IDisplayManagerList d = new DisplayManagerList();
        d.displayManager(managerList);
    }
}

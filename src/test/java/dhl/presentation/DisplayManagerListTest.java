package dhl.presentation;

import dhl.mock.MockManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayManagerListTest {
    @Test
    public void displayManagerTest(){
        ArrayList<String> managerList = MockManager.createMock();
        IDisplayManagerList d = new DisplayManagerList();
        d.displayManager(managerList);
    }
}

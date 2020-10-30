package Presentation;

import dhl.Presentation.DisplayManagerList;
import dhl.Presentation.IDisplayManagerList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayManagerListTest {
    @Test
    public void displayManagerTest(){
        ArrayList<String> managerList = new ArrayList();
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        IDisplayManagerList d = new DisplayManagerList();
        d.displayManager(managerList);
    }
}

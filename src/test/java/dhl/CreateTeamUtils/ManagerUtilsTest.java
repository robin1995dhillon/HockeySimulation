package dhl.CreateTeamUtils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ManagerUtilsTest {
    @Test
    public void displayManagerTest(){
        ArrayList<String> managerList = new ArrayList();
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        IManagerUtils managerUtils = new ManagerUtils();
        managerUtils.displayManager(managerList);
    }

    @Test
    public void removeManagerTest(){
        ArrayList<String> managerList = new ArrayList();
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        IManagerUtils managerUtils = new ManagerUtils();
        System.out.println("Before remove:");
        managerUtils.displayManager(managerList);
        managerUtils.removeManager(managerList, "Joseph Squidly");
        System.out.println("\nAfter remove:");
        managerUtils.displayManager(managerList);
    }
}

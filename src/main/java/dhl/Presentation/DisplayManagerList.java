package dhl.Presentation;

import java.util.List;

public class DisplayManagerList implements IDisplayManagerList{
    @Override
    public void displayManager(List<String> managerList) {
        for (String s : managerList) {
            System.out.println(s);
        }
    }
}

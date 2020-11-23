package dhl.presentation;

import dhl.leagueModel.generalManager.IGeneralManager;

import java.util.List;

public class DisplayManagerList implements IDisplayManagerList {
    @Override
    public void displayManager(List<IGeneralManager> managerList) {
        System.out.printf("%-20s\t%-20s%n", "name", "personality");
        for (IGeneralManager manager : managerList) {
            System.out.printf("%-20s\t", manager.getName());
            System.out.printf("%-20s%n", manager.getPersonality());
        }
    }
}

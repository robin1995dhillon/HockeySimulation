package dhl.presentation;

import dhl.leagueModel.headCoach.IHeadCoach;

import java.util.List;

public class DisplayCoachList implements IDisplayCoachList {

    @Override
    public void displayCoach(List<IHeadCoach> coachList) {
        System.out.printf("%-20s\t%-10s\t%-10s\t%-10s%-10s%n", "name", "skating", "shooting", "checking", "saving");
        for (IHeadCoach headCoach : coachList) {
            System.out.printf("%-20s\t", headCoach.getName());
            System.out.printf("%-10.1f\t", headCoach.getSkating());
            System.out.printf("%-10.1f\t", headCoach.getShooting());
            System.out.printf("%-10.1f\t", headCoach.getChecking());
            System.out.printf("%-10.1f\t%n", headCoach.getSaving());
        }
    }
}

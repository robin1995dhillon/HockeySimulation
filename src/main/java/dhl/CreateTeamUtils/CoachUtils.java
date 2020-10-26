package dhl.CreateTeamUtils;

import dhl.LeagueModel.IHeadCoach;

import java.util.ArrayList;

public class CoachUtils implements ICoachUtils{
    @Override
    public void displayCoach(ArrayList<IHeadCoach> coachList) {
        System.out.println(String.format("%-20s\t%-10s\t%-10s\t%-10s%-10s", "name","skating","shooting","checking","saving"));
        for (IHeadCoach headCoach : coachList) {
            System.out.print(String.format("%-20s\t", headCoach.getName()));
            System.out.print(String.format("%-10.1f\t", headCoach.getSkating()));
            System.out.print(String.format("%-10.1f\t", headCoach.getShooting()));
            System.out.print(String.format("%-10.1f\t", headCoach.getChecking()));
            System.out.println(String.format("%-10.1f\t", headCoach.getSaving()));
        }
    }

    @Override
    public void removeCoach(ArrayList<IHeadCoach> coachList, String coachName) {
        for (IHeadCoach headCoach : coachList){
            if(headCoach.getName().equals(coachName)){
                coachList.remove(headCoach);
            }
        }
    }
}

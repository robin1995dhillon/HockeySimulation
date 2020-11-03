package dhl.presentation;

import dhl.leagueModel.freeAgents.IFreeAgents;

import java.util.List;

public class DisplayFreeAgentList implements IDisplayFreeAgentList {
    @Override
    public void displayFreeAgent(List<IFreeAgents> freeAgentList) {
        System.out.printf("%-20s\t%-10s\t%-5s\t%-10s\t%-10s\t%-10s\t%-10s%n", "name", "position", "age", "skating", "shooting", "checking", "saving");
        for (IFreeAgents freeAgent : freeAgentList) {
            System.out.printf("%-20s\t", freeAgent.getPlayerName());
            System.out.printf("%-10s\t", freeAgent.getPosition());
            System.out.printf("%-5d\t", freeAgent.getAge());
            System.out.printf("%-10d\t", freeAgent.getSkating());
            System.out.printf("%-10d\t", freeAgent.getShooting());
            System.out.printf("%-10d\t", freeAgent.getChecking());
            System.out.printf("%-10d%n", freeAgent.getSaving());
        }
    }
}

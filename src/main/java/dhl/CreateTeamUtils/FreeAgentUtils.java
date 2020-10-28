package dhl.CreateTeamUtils;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;

import java.util.ArrayList;
import java.util.List;

public class FreeAgentUtils implements IFreeAgentUtils {
    @Override
    public void displayFreeAgent(List<IFreeAgents> freeAgentList) {
        System.out.printf("%-20s\t%-10s\t%-5s\t%-10s\t%-10s\t%-10s\t%-10s%n","name","position","age","skating","shooting","checking","saving");
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

    @Override
    public IFreeAgents getPlayer(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if(freeAgent.getPlayerName().equals(freeAgentName)){
                return freeAgent;
            }
        }
        return null;
    }

    @Override
    public void removeFreeAgent(List<IFreeAgents> freeAgentList, String freeAgentName) {
        freeAgentList.removeIf(freeAgent -> freeAgent.getPlayerName().equals(freeAgentName));
    }

    @Override
    public boolean checkPosition(List<IFreeAgents> freeAgentList, String playerName, String position) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if(freeAgent.getPlayerName().equals(playerName)){
                if(freeAgent.getPosition().equals(position)){
                    return true;
                }
            }
        }
        return false;
    }

}


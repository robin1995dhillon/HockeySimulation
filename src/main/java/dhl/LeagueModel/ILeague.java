package dhl.LeagueModel;

import java.util.ArrayList;

public interface ILeague {
    public ArrayList<IConference> getConferences();

    public void setConferences(ArrayList<IConference> conferences);

    public String getLeagueName();

    public void setLeagueName(String leagueName);
    public ArrayList<IFreeAgents> getfreeAgents();
    public ArrayList<String> getGeneralManagers();
    public ArrayList<IHeadCoach> getCoaches();

    public void setfreeAgents(ArrayList<IFreeAgents> freeAgents);
    public  boolean isValid(ILeague league);
    public boolean isLeagueNamePresent();

}

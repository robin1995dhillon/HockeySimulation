package dhl.leagueModel;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

public abstract class LeagueModelAbstractFactory {

    private static LeagueModelAbstractFactory instance = null;

    public static LeagueModelAbstractFactory instance() {

        if (instance == null) {
            instance = new LeagueModelConcrete();
        }
        return instance;
    }


    public abstract ILeague getLeague();

    public abstract void setLeague(ILeague league);

    public abstract IConference getConference();

    public abstract void setConference(IConference conference);

    public abstract IDivision getDivision();

    public abstract void setDivision(IDivision division);

    public abstract ITeam getTeam();

    public abstract void setTeam(ITeam team);

    public abstract IPlayers getPlayers();

    public abstract void setPlayers(IPlayers players);

    public abstract IHeadCoach getHeadCoach();

    public abstract void setHeadCoach(IHeadCoach headCoach);

    public abstract IGeneralManager getGeneralManager();

    public abstract void setGeneralManager(IGeneralManager generalManager);

    public abstract IFreeAgents getFreeAgents();

    public abstract void setFreeAgents(IFreeAgents freeAgents);

    public abstract IGamePlayConfig getGamePlayConfig();

    public abstract void setGamePlayConfig(IGamePlayConfig gamePlayConfig);
}

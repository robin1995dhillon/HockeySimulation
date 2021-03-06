package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.trade.*;

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

    public abstract IPlayers getNewPlayers();

    public abstract void setPlayers(IPlayers players);

    public abstract IHeadCoach getHeadCoach();

    public abstract void setHeadCoach(IHeadCoach headCoach);

    public abstract IGeneralManager getGeneralManager();

    public abstract void setGeneralManager(IGeneralManager generalManager);

    public abstract IFreeAgents getFreeAgents();

    public abstract IFreeAgents getNewFreeAgents();

    public abstract void setFreeAgents(IFreeAgents freeAgents);

    public abstract IGamePlayConfig getGamePlayConfig();

    public abstract void setGamePlayConfig(IGamePlayConfig gamePlayConfig);

    public abstract IPlayerTrainingCondition getPlayerTrainingCondition();

    public abstract void setPlayerTrainingCondition(IPlayerTrainingCondition playerTrainingCondition);


    public abstract IAddDropPlayers getAddDropPlayers();

    public abstract IPlayerTradingCondition getPLayerTradingCondition();

    public abstract IStrongestWeakestPlayers getStrongestWeakestPlayers();

    public abstract void  setAddDropPlayers(IAddDropPlayers addDropPlayers);

    public abstract void  setPLayerTradingCondition(IPlayerTradingCondition playerTradingCondition);

    public abstract void  setStrongestWeakestPlayers(IStrongestWeakestPlayers strongestWeakestPlayers);

    public abstract void setPlayerTrade(IPlayerTrade playerTrade);

    public abstract IPlayerTrade getPlayerTrade();

    public abstract void setAllPlayers(IAllPlayers allPlayers);

    public abstract IAllPlayers getAllPlayers();

}

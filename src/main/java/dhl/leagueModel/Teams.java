package dhl.leagueModel;

import dhl.Configurables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Teams implements ITeam {
    private static final Logger logger = LogManager.getLogger(Teams.class);

    public String teamName;
    public IGeneralManager generalManager;
    public IHeadCoach headCoach;
    public List<IPlayers> players;
    public List<IPlayers> activeRoster;
    public List<IPlayers> inActiveRoster;
    public String teamType = Configurables.AI.getAction();
    public int lossPoints;
    public double teamStrength;
    private boolean isUser = false;
    private double shots;
    private double saves;
    private double penalties;
    private double goals;
    private int gameCount;

    public Teams() {
    }

    public Teams(String teamName, IGeneralManager generalManager, IHeadCoach headCoach, List<IPlayers> players) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
        this.players = players;
    }

    public Teams(String teamName, IGeneralManager generalManager, IHeadCoach headCoach) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
    }

    @Override
    public List<IPlayers> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(List<IPlayers> players) {
        this.players = players;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public IGeneralManager getGeneralManager() {
        return generalManager;
    }

    @Override
    public void setGeneralManager(IGeneralManager generalManager) {
        this.generalManager = generalManager;
    }

    @Override
    public String getTeamType() {
        return teamType;
    }

    @Override
    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    @Override
    public IHeadCoach getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoach headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public int getLossPoints() {
        return lossPoints;
    }

    @Override
    public void setLossPoints(int lossPoints) {
        this.lossPoints = lossPoints;
    }

    @Override
    public double getTeamStrength() {
        return teamStrength;
    }

    @Override
    public void setTeamStrength(double teamStrength) {
        this.teamStrength = teamStrength;
    }

    @Override
    public List<IPlayers> getActiveRoster() {
        return activeRoster;
    }

    @Override
    public void setActiveRoster(List<IPlayers> activeRoster) {
        this.activeRoster = activeRoster;
    }

    @Override
    public List<IPlayers> getInActiveRoster() {
        return inActiveRoster;
    }

    @Override
    public void setInActiveRoster(List<IPlayers> inActiveRoster) {
        this.inActiveRoster = inActiveRoster;
    }

    @Override
    public void setGoals(double goals) {
        this.goals = goals;
    }

    @Override
    public double getGoals() {
        return this.goals;
    }

    @Override
    public void setSaves(double saves) {
        this.saves = saves;
    }

    @Override
    public double getSaves() {
        return this.saves;
    }

    @Override
    public void setShots(double shots) {
        this.shots = shots;
    }

    @Override
    public double getShots() {
        return this.shots;
    }

    @Override
    public void setPenalties(double penalties) {
        this.penalties = penalties;
    }

    @Override
    public double getPenalties() {
        return this.penalties;
    }

    @Override
    public void setGameCount(int count) {
        this.gameCount = count;
    }

    @Override
    public int getGameCount() {
        return this.gameCount;
    }

    @Override
    public double calculateTeamStrength(ITeam team) {
        List<IPlayers> players;
        players = team.getPlayers();
        double teamStrength = 0;
        for (IPlayers player : players) {
            double playerStrength = player.calculateStrength();
            teamStrength += playerStrength;
        }
        team.setTeamStrength(teamStrength);
        logger.info(team.getTeamName() + "'s strength is" + team.getTeamStrength());
        return teamStrength;
    }

    @Override
    public boolean getIsUser() {
        return this.isUser;
    }

    @Override
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    @Override
    public ILeague createTeam(ILeague league, String[] locationAttributes, IHeadCoach headCoach, List<IPlayers> playerList, IGeneralManager generalManager) {
        List<IConference> conferenceList;
        List<IDivision> divisionList;
        String conferenceName = locationAttributes[0];
        String divisionName = locationAttributes[1];
        String teamName = locationAttributes[2];
        conferenceList = league.getConferences();
        for (IConference conference : conferenceList) {
            if (conference.getConferenceName().toLowerCase().equals(conferenceName.toLowerCase())) {
                divisionList = conference.getDivisions();
                for (IDivision division : divisionList) {
                    if (division.getDivisionName().toLowerCase().equals(divisionName.toLowerCase())) {
                        ITeam team = new Teams();
                        team.setGeneralManager(generalManager);
                        team.setPlayers(playerList);
                        team.setHeadCoach(headCoach);
                        team.setTeamName(teamName);
                        team.setIsUser(true);
                        team.setTeamType(Configurables.USER.getAction());
                        division.addTeam(team);
                        logger.info(teamName + "is created in " + divisionName + " in " + conferenceName);
                    }
                }
            }
        }
        return league;
    }

    @Override
    public void createRoster() throws Exception {
        List<IPlayers> allSkaters = new ArrayList<>();
        List<IPlayers> allGoalie = new ArrayList<>();
        if(this.players == null) {
            logger.error("Player Array is empty while creating roster.");
            throw new Exception("Player Array is empty while creating roster.");
        } else {
            for (IPlayers players : this.players) {
                players.calculateStrength();
                if (players.getPosition().equals(Configurables.FORWARD.getAction()) || players.getPosition().equals(Configurables.DEFENSE.getAction())) {
                    allSkaters.add(players);
                } else {
                    allGoalie.add(players);
                }
            }
            List<IPlayers> bestSkaters = bestPlayersInATeamSorted(allSkaters);
            List<IPlayers> bestGoalie  = bestPlayersInATeamSorted(allGoalie);
            setRoster(bestSkaters,bestGoalie);
            logger.info("Active and inactive player rosters for " + this.teamName + " is created.");
        }
    }

    private List<IPlayers> bestPlayersInATeamSorted(List<IPlayers> skatingPlayers) {
        skatingPlayers.sort(Collections.reverseOrder(Comparator.comparingDouble(IAllPlayers::getStrength)));
        return skatingPlayers;
    }

    private void setRoster(List<IPlayers> bestSkaters, List<IPlayers> bestGoalie) {
        List<IPlayers> activeRoster = new ArrayList<>();
        List<IPlayers> inActiveRoster = new ArrayList<>();
        int index = 0;
        int goalieIndex = 0;
        for(IPlayers players: bestSkaters) {
            if(index>=18) {
                inActiveRoster.add(players);
            } else {
                activeRoster.add(players);
            }
            index = index + 1;
        }
        for(IPlayers players : bestGoalie) {
            if(goalieIndex>=2) {
                inActiveRoster.add(players);
            }
            else {
                activeRoster.add(players);
            }
            goalieIndex = goalieIndex + 1;

        }
        this.setActiveRoster(activeRoster);
        this.setInActiveRoster(inActiveRoster);
    }

    @Override
    public void swapForPlayerInInactiveRoster(IPlayers players) throws Exception {
        if(this.inActiveRoster == null) {
            logger.error("In-active Roster is empty.");
            throw new Exception("In-active Roster is empty.");
        } else {
            for(IPlayers inActivePlayer: this.inActiveRoster) {
                if(inActivePlayer.isInjured() == false && players.getPosition().equals(inActivePlayer.getPosition())) {
                    addPlayerToInactiveRoster(players);
                    addPlayerToActiveRoster(inActivePlayer);
                    removePlayerFromInactiveRoster(inActivePlayer);
                    removePlayerFromActiveRoster(players);
                    break;
                }
            }
            setInActiveRoster(bestPlayersInATeamSorted(this.inActiveRoster));
            setActiveRoster(bestPlayersInATeamSorted(this.activeRoster));
        }
        logger.info("Swapping completed for inactive roster players for " + this.teamName);
    }

    public void removePlayerFromInactiveRoster(IPlayers players) {
        this.inActiveRoster.remove(players);
    }

    public void addPlayerToInactiveRoster(IPlayers players) {
        this.inActiveRoster.add(players);
    }

    public void addPlayerToActiveRoster(IPlayers players) {
        this.activeRoster.add(players);
    }

    public void removePlayerFromActiveRoster(IPlayers players) {
        this.activeRoster.remove(players);
    }

    @Override
    public void addPlayerToTeam(IPlayers players) {
        this.players.add(players);
    }

    @Override
    public void removePlayerFromTeam(IPlayers players) {
        this.players.remove(players);
    }

    @Override
    public void checkForInactiveRosterPlayerInjuryRecovery() {
        List<IPlayers> activeRoster;
        List<IPlayers> inActiveRoster;
        activeRoster = this.activeRoster;
        inActiveRoster = this.inActiveRoster;
        for(int i=0;i<inActiveRoster.size();i++) {
            if(inActiveRoster.get(0).isInjured() == false) {
                for (int j = 0; j < activeRoster.size(); j++) {
                    if(inActiveRoster.get(i).getPosition().equals(activeRoster.get(j).getPosition()) && inActiveRoster.get(i).getStrength() > activeRoster.get(j).getStrength()) {
                        addPlayerToActiveRoster(inActiveRoster.get(i));
                        removePlayerFromActiveRoster(activeRoster.get(j));
                        addPlayerToInactiveRoster(activeRoster.get(j));
                        removePlayerFromInactiveRoster(inActiveRoster.get(i));
                        logger.info("Player swapped in" + inActiveRoster.get(i).getPlayerName() + "to active roster of " + this.teamName);
                        logger.info("Player swapped out" + activeRoster.get(j).getPlayerName() + "to inactive roster of " + this.teamName);
                    }
                }
            }
            setInActiveRoster(bestPlayersInATeamSorted(this.inActiveRoster));
            setActiveRoster(bestPlayersInATeamSorted(this.activeRoster));
        }
    }

    @Override
    public void dropTeamToThirty() {
        List<IPlayers> playerList = this.players;
        List<IPlayers> forwardPlayerList = new ArrayList<>();
        List<IPlayers> defensePlayerList = new ArrayList<>();
        List<IPlayers> goaliePlayerList = new ArrayList<>();
        for(IPlayers players: playerList) {
            if(players.getPosition().equals(Configurables.FORWARD.getAction())) {
                forwardPlayerList.add(players);
            }
            else if (players.getPosition().equals(Configurables.DEFENSE.getAction())) {
                defensePlayerList.add(players);
            }
            else {
                goaliePlayerList.add(players);
            }
        }
        forwardPlayerList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        defensePlayerList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));
        goaliePlayerList.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));

        List<IPlayers> finalTeamList = new ArrayList<>();
        finalTeamList = setPlayersOfAPositionInTeam(forwardPlayerList, finalTeamList, 16);
        finalTeamList = setPlayersOfAPositionInTeam(defensePlayerList, finalTeamList, 10);
        finalTeamList = setPlayersOfAPositionInTeam(goaliePlayerList, finalTeamList, 4);
        this.setPlayers(finalTeamList);
        logger.info(this.teamName + "has been dropped down to 30 players.");
    }

    public List<IPlayers> setPlayersOfAPositionInTeam(List<IPlayers> playerList, List<IPlayers> finalTeamList, int maxPlayersOfAPosition) {
        int count = 0;
        for(IPlayers players: playerList) {
            if(count < maxPlayersOfAPosition) {
                finalTeamList.add(players);
            }
            count = count + 1;
        }
        return finalTeamList;
    }
}

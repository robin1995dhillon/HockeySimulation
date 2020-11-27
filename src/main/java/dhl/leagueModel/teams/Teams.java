package dhl.leagueModel.teams;

import dhl.inputOutput.UserOutput;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.Configurables;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teams implements ITeam {

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
    UserOutput userOutput = new UserOutput();

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
    public double calculateTeamStrength(ITeam team) {
        List<IPlayers> players;
        players = team.getPlayers();
        double teamStrength = 0;

        for (IPlayers player : players) {
            IPlayers strength = new Players();
            double playerStrength = strength.calculateStrength(player);
            teamStrength += playerStrength;
        }
        team.setTeamStrength(teamStrength);
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
        String managerName = locationAttributes[3];
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
                        division.addTeam(team);
                    }
                }
            }
        }
        return league;
    }
//    @Override
//    public ILeague createTeam(ILeague league, String[] locationAttributes, IHeadCoach headCoach, List<IPlayers> playerList) {
//
//        // Remove this method when general Manager thing is solved.
//        return league;
//    }

    @Override
    public void createRoster() throws Exception {
        List<IPlayers> allSkaters = new ArrayList<>();
        List<IPlayers> allGoalie = new ArrayList<>();
        List<Double> allSkatersStrength = new ArrayList<>();
        List<Double> allGoalieStrength = new ArrayList<>();
        if(this.players == null) {
            throw new Exception("Player Array is empty while creating roster.");
        } else {
            for (IPlayers players : this.players) {
                players.calculateStrength(players);
                System.out.println(players.getPlayerName());
                if (players.getPosition().equals(Configurables.FORWARD.getAction()) || players.getPosition().equals(Configurables.DEFENSE.getAction())) {
                    allSkaters.add(players);
                    allSkatersStrength.add(players.getStrength());
                } else {
                    allGoalie.add(players);
                    allGoalieStrength.add(players.getStrength());
                }
            }
            List<IPlayers> bestSkaters = bestSkatersInATeam(allSkaters, allSkatersStrength);
            List<IPlayers> bestGoalie  = bestSkatersInATeam(allGoalie, allGoalieStrength);
            setRoster(bestSkaters,bestGoalie);
        }
    }

    private List<IPlayers> bestSkatersInATeam(List<IPlayers> skatingPlayers, List<Double> skatingPlayersStrength) {
        List<IPlayers> bestSkaters = new ArrayList<>();
        Collections.sort(skatingPlayersStrength, Collections.reverseOrder());
//        for(Double val: skatingPlayersStrength) {
//            for(IPlayers players: skatingPlayers) {
//                if(val.equals(players.getStrength())) {
//                    bestSkaters.add(players);
//                }
//            }
//        }
//        for(IPlayers players: skatingPlayers) {
//            for(Double val: skatingPlayersStrength) {
//                if(val.equals(players.getStrength())) {
//                    bestSkaters.add(players);
//                    skatingPlayers.remove(players);
//                    skatingPlayersStrength.remove(val);
//                    break;
//                }
//            }
//        }

        for(int i=0; i<skatingPlayers.size();i++) {
            for(int j=0; j<skatingPlayersStrength.size();j++) {
                if(skatingPlayersStrength.get(j).equals(skatingPlayers.get(i).getStrength())) {
                    bestSkaters.add(skatingPlayers.get(i));
                    skatingPlayers.remove(skatingPlayers.get(i));
                    skatingPlayersStrength.remove(skatingPlayersStrength.get(j));
                }
            }
        }
        return bestSkaters;
    }

    private void setRoster(List<IPlayers> bestSkaters, List<IPlayers> bestGoalie) {
        List<IPlayers> activeRoster = new ArrayList<>();
        List<IPlayers> inActiveRoster = new ArrayList<>();
        int index = 0;
        int goalieIndex = 0;
        for(IPlayers players: bestSkaters) {
            if(index>=18) {
                activeRoster.add(players);
            } else {
                inActiveRoster.add(players);
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
    public void saveTeams(List<Integer> id) {
//        ITeamPersistence teamPersistence = new TeamPersistence();
//        String headCoach = this.headCoach.getName();
//        JSONObject resultObject = teamPersistence.saveTeamToDB(this.teamName, this.generalManager, headCoach, this.isUser);
//        int teamID = (int) resultObject.get(Configurables.ID.getAction());
//        userOutput.setOutput("Saving Team " + teamID + ": " + this.getTeamName());
//        userOutput.sendOutput();
//        id.add(3, teamID);
//        IDHLPersistence idhlPersistence = new DHLPersistence();
//        idhlPersistence.saveDHLTable(id.get(0), id.get(1), id.get(2), id.get(3));
//        List<IPlayers> playersArray = getPlayers();
//        IHeadCoach iHeadCoach = getHeadCoach();
//        iHeadCoach.saveHeadCoach(teamID);
//
//        for (IPlayers player : playersArray) {
//            player.savePlayer(teamID);
//        }
    }

}

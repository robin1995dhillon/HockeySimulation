package dhl;

import dhl.LeagueModel.*;
import dhl.LeagueModel.conference.Conference;
import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.league.League;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.teams.Teams;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class SerializeModelToJSONTest {

    @Test
    void serializeModelToJSONTest() throws IOException {
        ArrayList<IPlayers> playerList = new ArrayList<>();
        ArrayList<ITeam> teamList = new ArrayList<>();
        ArrayList<IDivision> divisionList = new ArrayList<>();
        ArrayList<IConference> conferenceList = new ArrayList<>();
        ArrayList<IFreeAgents> freeAgentList = new ArrayList<>();
        ArrayList<IHeadCoach> coachList = new ArrayList<>();
        ArrayList<String> managerList = new ArrayList<>();
        ILeague league = new League("Dalhousie Hockey League", conferenceList, freeAgentList);
        league.setFreeAgents(freeAgentList);
        league.setHeadCoach(coachList);
        league.setGeneralManager(managerList);
        IConference conference = new Conference("Eastern Conference", divisionList);
        conferenceList.add(conference);
        IDivision division = new Division("Atalantic", teamList);
        divisionList.add(division);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("Mary Smith");
        headCoach.setSkating(0.5);
        headCoach.setShooting(0.8);
        headCoach.setChecking(0.3);
        headCoach.setSaving(0.5);
        ITeam team = new Teams("Boston", "Mister Fred", headCoach, playerList);
        teamList.add(team);
        IPlayers player1 = new Players("Player One", "forward", true);
        player1.setAge(27);
        player1.setSkating(15);
        player1.setShooting(18);
        player1.setChecking(12);
        player1.setSaving(0);
        playerList.add(player1);
        IPlayers player2 = new Players("Player Two", "defense", false);
        player2.setAge(20);
        player2.setSkating(10);
        player2.setShooting(10);
        player2.setChecking(10);
        player2.setSaving(0);
        playerList.add(player2);
        IPlayers player3 = new Players("Player Three", "goalie", false);
        player3.setAge(33);
        player3.setSkating(10);
        player3.setShooting(4);
        player3.setChecking(9);
        player3.setSaving(18);
        playerList.add(player3);
        IFreeAgents freeAgent1 = new FreeAgents("Agent One", "forward");
        freeAgent1.setAge(25);
        freeAgent1.setSkating(10);
        freeAgent1.setShooting(10);
        freeAgent1.setChecking(10);
        freeAgent1.setSaving(0);
        freeAgentList.add(freeAgent1);
        IFreeAgents freeAgent2 = new FreeAgents("Agent Two", "defense");
        freeAgent2.setAge(25);
        freeAgent2.setSkating(10);
        freeAgent2.setShooting(10);
        freeAgent2.setChecking(10);
        freeAgent2.setSaving(0);
        freeAgentList.add(freeAgent2);
        IFreeAgents freeAgent3 = new FreeAgents("Agent Three", "goalie");
        freeAgent3.setAge(25);
        freeAgent3.setSkating(10);
        freeAgent3.setShooting(5);
        freeAgent3.setChecking(5);
        freeAgent3.setSaving(10);
        freeAgentList.add(freeAgent3);
        IHeadCoach coach1 = new HeadCoach();
        coach1.setName("Joe Smith");
        coach1.setSkating(0.5);
        coach1.setShooting(0.8);
        coach1.setChecking(0.3);
        coach1.setSaving(1.0);
        coachList.add(coach1);
        IHeadCoach coach2 = new HeadCoach();
        coach2.setName("Frank Smith");
        coach2.setSkating(0.5);
        coach2.setShooting(0.8);
        coach2.setChecking(0.3);
        coach2.setSaving(0.5);
        coachList.add(coach2);
        IHeadCoach coach3 = new HeadCoach();
        coach3.setName("Samantha Smith");
        coach3.setSkating(1.0);
        coach3.setShooting(0.5);
        coach3.setChecking(0.5);
        coach3.setSaving(0.0);
        coachList.add(coach3);
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        SerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}
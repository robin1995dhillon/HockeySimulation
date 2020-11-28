package dhl.stateMachineNew;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.LeagueModelAbstractFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDraft {

    List<String> firstNameList = Arrays.asList("Wayne", "Jonathan", "Connor", "Gordie", "Mario", "John", "Steven");
    List<String> lastNameList = Arrays.asList("Gretzky", "Toews", "McDavid", "Lemieux", "Stamkos", "Benn", "Richard");
    private String firstName;
    private String lastName;
    private String fullName;
    private int draftingRounds = 7;
    List<IPlayers> draftingPlayerList;
    LeagueModelAbstractFactory leagueModelAbstractFactory;

    public PlayerDraft() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        draftingPlayerList = new ArrayList<>();
    }

    public void generateFirstName() {
        Collections.shuffle(this.firstNameList);
        String firstName = this.firstNameList.get(0);
        this.setFirstName(firstName);
    }

    public void generateLastName() {
        Collections.shuffle(this.lastNameList);
        String lastName = this.lastNameList.get(0);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String generateFullName() {
        this.generateFirstName();
        this.generateLastName();
        String fullName = this.firstName + " " + this.lastName;
        this.setFullName(fullName);
        return fullName;
    }

    public List<IPlayers> getDraftingPlayerList() {
        return draftingPlayerList;
    }

    public void setDraftingPlayerList(List<IPlayers> draftingPlayerList) {
        this.draftingPlayerList = draftingPlayerList;
    }

    public int getSkatingValueForForward() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int skating;
        if(randomNumber >= 70) {
            skating = ThreadLocalRandom.current().nextInt(15, 21);
        } else {
            skating = ThreadLocalRandom.current().nextInt(12, 21);
        }
        return skating;
    }

    public int getSkatingValueForDefense() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int skating;
        if(randomNumber >= 70) {
            skating = ThreadLocalRandom.current().nextInt(14, 20);
        } else {
            skating = ThreadLocalRandom.current().nextInt(10, 19);
        }
        return skating;
    }

    public int getSkatingValueForGoalie() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int skating;
        if(randomNumber >= 70) {
            skating = ThreadLocalRandom.current().nextInt(11, 16);
        } else {
            skating = ThreadLocalRandom.current().nextInt(8, 16);
        }
        return skating;
    }

    public int getShootingForForward() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int shooting;
        if(randomNumber >= 70) {
            shooting = ThreadLocalRandom.current().nextInt(16, 21);
        } else {
            shooting = ThreadLocalRandom.current().nextInt(12, 21);
        }
        return shooting;
    }

    public int getShootingForDefense() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int shooting;
        if(randomNumber >= 70) {
            shooting = ThreadLocalRandom.current().nextInt(14, 19);
        } else {
            shooting = ThreadLocalRandom.current().nextInt(9, 19);
        }
        return shooting;
    }

    public int getShootingForGoalie() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int shooting;
        if(randomNumber >= 70) {
            shooting = ThreadLocalRandom.current().nextInt(5, 11);
        } else {
            shooting = ThreadLocalRandom.current().nextInt(1, 11);
        }
        return shooting;
    }

    public int getCheckingForForward() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int checking;
        if(randomNumber >= 70) {
            checking = ThreadLocalRandom.current().nextInt(13, 19);
        } else {
            checking = ThreadLocalRandom.current().nextInt(9, 19);
        }
        return checking;
    }

    public int getCheckingForDefense() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int checking;
        if(randomNumber >= 70) {
            checking = ThreadLocalRandom.current().nextInt(15, 21);
        } else {
            checking = ThreadLocalRandom.current().nextInt(12, 21);
        }
        return checking;
    }

    public int getCheckingForGoalie() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int checking;
        if(randomNumber >= 70) {
            checking = ThreadLocalRandom.current().nextInt(5, 13);
        } else {
            checking = ThreadLocalRandom.current().nextInt(1, 13);
        }
        return checking;
    }

    public int getSavingForForward() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int saving;
        if(randomNumber >= 70) {
            saving = ThreadLocalRandom.current().nextInt(4, 8);
        } else {
            saving = ThreadLocalRandom.current().nextInt(1, 8);
        }
        return saving;
    }

    public int getSavingForDefense() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int saving;
        if(randomNumber >= 70) {
            saving = ThreadLocalRandom.current().nextInt(4, 13);
        } else {
            saving = ThreadLocalRandom.current().nextInt(1, 13);
        }
        return saving;
    }

    public int getSavingForGoalie() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
        int saving;
        if(randomNumber >= 70) {
            saving = ThreadLocalRandom.current().nextInt(15, 21);
        } else {
            saving = ThreadLocalRandom.current().nextInt(12, 21);
        }
        return saving;
    }

    public int generateAge() {
        int randomAge = ThreadLocalRandom.current().nextInt(18,22);
        return randomAge;
    }

    public int generateDay() {
        int randomDay = ThreadLocalRandom.current().nextInt(1,31);
        return randomDay;
    }

    public int generateMonth() {
        int randomMonth = ThreadLocalRandom.current().nextInt(1,13);
        return randomMonth;
    }

    public int generateYear(int age) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int year = currentYear - age;
        return year;
    }

    public List<IPlayers> generateRandomPlayers(int numberOfTeams) {
        int numberOfPlayers = draftingRounds * numberOfTeams;
        int numberOfForwardPlayers = (int) Math.ceil(numberOfPlayers * 0.5);
        int numberOfDefensePlayers = (int) Math.ceil(numberOfPlayers * 0.4);
        int numberOfGoaliePlayers = numberOfPlayers - numberOfForwardPlayers - numberOfDefensePlayers;

        draftingPlayerList.addAll(generateForwardPlayers(numberOfForwardPlayers));
        draftingPlayerList.addAll(generateDefensePlayers(numberOfDefensePlayers));
        draftingPlayerList.addAll(generateGoaliePlayers(numberOfGoaliePlayers));

        return draftingPlayerList;
    }

    public List<IPlayers> generateForwardPlayers(int numberOfForwardPlayers) {
        List<IPlayers> forwardPlayerList = new ArrayList<>();
        for(int i=0;i<numberOfForwardPlayers;i++) {
            IPlayers players = leagueModelAbstractFactory.getNewPlayers();
            players.setPlayerName(generateFullName());
            players.setSkating(getSkatingValueForForward());
            players.setShooting(getShootingForForward());
            players.setChecking(getCheckingForForward());
            players.setSaving(getSavingForForward());
            players.setPosition("forward");
            players.setCaptain(false);
            players.setAge(generateAge());
            players.setBirthYear(generateYear(players.getAge()));
            players.setBirthMonth(generateMonth());
            players.setBirthDay(generateDay());
            forwardPlayerList.add(players);
        }
        return forwardPlayerList;
    }

    public List<IPlayers> generateDefensePlayers(int numberOfDefensePlayers) {
        List<IPlayers> defensePLayerList = new ArrayList<>();
        for(int i=0;i<numberOfDefensePlayers;i++) {
            IPlayers players = leagueModelAbstractFactory.getNewPlayers();
            players.setPlayerName(generateFullName());
            players.setSkating(getSkatingValueForDefense());
            players.setShooting(getShootingForDefense());
            players.setChecking(getCheckingForDefense());
            players.setSaving(getSavingForDefense());
            players.setPosition("defense");
            players.setCaptain(false);
            players.setAge(generateAge());
            players.setBirthYear(generateYear(players.getAge()));
            players.setBirthMonth(generateMonth());
            players.setBirthDay(generateDay());
            defensePLayerList.add(players);
        }
        return defensePLayerList;

    }

    public List<IPlayers> generateGoaliePlayers(int numberOfGoaliePlayers) {
        List<IPlayers> goaliePlayerList = new ArrayList<>();
        for(int i=0;i<numberOfGoaliePlayers;i++) {
            IPlayers players = leagueModelAbstractFactory.getNewPlayers();
            players.setPlayerName(generateFullName());
            players.setSkating(getSkatingValueForGoalie());
            players.setShooting(getShootingForGoalie());
            players.setChecking(getCheckingForGoalie());
            players.setSaving(getSavingForGoalie());
            players.setPosition("goalie");
            players.setCaptain(false);
            players.setAge(generateAge());
            players.setBirthYear(generateYear(players.getAge()));
            players.setBirthMonth(generateMonth());
            players.setBirthDay(generateDay());
            goaliePlayerList.add(players);
        }
        return goaliePlayerList;
    }

}

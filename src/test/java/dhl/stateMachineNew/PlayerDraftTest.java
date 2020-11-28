package dhl.stateMachineNew;

import dhl.leagueModel.IPlayers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDraftTest {

    @Test
    void generateFirstName() {
    }

    @Test
    void generateLastName() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getFullName() {
    }

    @Test
    void setFullName() {
    }

    @Test
    void generateFullName() {
    }

    @Test
    void getDraftingPlayerList() {
    }

    @Test
    void setDraftingPlayerList() {
    }

    @Test
    void getSkatingValueForForward() {
    }

    @Test
    void getSkatingValueForDefense() {
    }

    @Test
    void getSkatingValueForGoalie() {
    }

    @Test
    void getShootingForForward() {
    }

    @Test
    void getShootingForDefense() {
    }

    @Test
    void getShootingForGoalie() {
    }

    @Test
    void getCheckingForForward() {
    }

    @Test
    void getCheckingForDefense() {
    }

    @Test
    void getCheckingForGoalie() {
    }

    @Test
    void getSavingForForward() {
    }

    @Test
    void getSavingForDefense() {
    }

    @Test
    void getSavingForGoalie() {
    }

    @Test
    void generateAge() {
    }

    @Test
    void generateDay() {
    }

    @Test
    void generateMonth() {
    }

    @Test
    void generateYear() {
    }

    @Test
    void generateRandomPlayers() {
        List<IPlayers> playerDraftList = new ArrayList<>();
        PlayerDraft playerDraft = new PlayerDraft();
        playerDraftList = playerDraft.generateRandomPlayers(5);
        for(IPlayers players: playerDraftList) {
            System.out.println(players.getPlayerName());
            System.out.println(players.getPosition());
            System.out.println("Skating Value: " + players.getSkating());
            System.out.println("Shooting Value: " + players.getShooting());
            System.out.println("Checking Value: " + players.getChecking());
            System.out.println("Saving Value: " + players.getSaving());
        }
    }

    @Test
    void generateForwardPlayers() {
    }

    @Test
    void generateDefensePlayers() {
    }

    @Test
    void generateGoaliePlayers() {
    }
}

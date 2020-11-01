package dhl.leagueModel.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersPersistenceTest {

    @Test
    void savePlayerToDB() {
        IPlayersPersistence playersPersistence = new PlayersPersistence();
        boolean[] booleanAttribute = {true,false,true};
        int[] playerAttributes = {15,16,17,17};
        boolean result = playersPersistence.savePlayerToDB("Player1","forward",booleanAttribute,25,playerAttributes,3,15);
        assertEquals(true,result);
    }
}
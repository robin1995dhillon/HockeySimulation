package dhl.persistence.saving;

public interface IPlayersPersistence {
    boolean savePlayerToDB(String playerName, String position, boolean[] booleanAttribute, int age, int[] playerAttributes, int team_id, int injuryDays);
}

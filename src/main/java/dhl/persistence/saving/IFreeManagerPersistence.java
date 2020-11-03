package dhl.persistence.saving;

public interface IFreeManagerPersistence {
    boolean saveFreeManagerToDB(String managerName, int leagueID);
}

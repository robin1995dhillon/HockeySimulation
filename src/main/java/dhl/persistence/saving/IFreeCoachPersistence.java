package dhl.persistence.saving;

public interface IFreeCoachPersistence {
    boolean saveFreeCoachToDB(String coachName, double[] coachAttributes, int leagueID);
}

package dhl.gamePlayConfig;

public interface IInjuries {
    double getRandomInjuryChance();

    void setRandomInjuryChance(double randomInjuryChance);

    int getInjuryDaysLow();

    void setInjuryDaysLow(int injuryDaysLow);

    int getInjuryDaysHigh();

    void setInjuryDaysHigh(int injuryDaysHigh);
}

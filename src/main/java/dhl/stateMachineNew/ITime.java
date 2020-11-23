package dhl.stateMachineNew;

import java.text.ParseException;

public interface ITime {

    String nextDate(String currentDate) throws ParseException;
}

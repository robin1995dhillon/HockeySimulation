package dhl.stateMachine;

import java.text.ParseException;

public interface ITime {

    String nextDate(String currentDate) throws ParseException;
}

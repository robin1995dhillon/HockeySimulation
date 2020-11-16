package dhl.inputOutput;

import java.util.Scanner;

public class UserInput implements IUserInput {

    private String inputValue;

    public UserInput() {
        setDefaultInput();
    }

    @Override
    public void setDefaultInput() {
        inputValue = "";
    }

    @Override
    public String getInput() {
        return this.inputValue;
    }

    @Override
    public void setInput() {
        Scanner scInput = new Scanner(System.in);
        scInput.useDelimiter("\n");
        this.inputValue = scInput.nextLine();

    }
}

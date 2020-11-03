package dhl.inputOutput;

import java.util.Scanner;

public class UserInput implements IUserInput {

    private String InputValue;

    public UserInput() {
        setDefaultInput();
    }

    @Override
    public void setDefaultInput() {
        InputValue = "";
    }

    @Override
    public String getInput() {
        return this.InputValue;
    }

    @Override
    public void setInput() {
        Scanner scInput = new Scanner(System.in);
        scInput.useDelimiter("\n");
        this.InputValue = scInput.nextLine();

    }
}

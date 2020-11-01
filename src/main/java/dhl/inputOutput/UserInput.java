package dhl.inputOutput;

import java.util.Scanner;

public class UserInput implements IUserInput {

    private String InputValue;

    public UserInput() {
        setDefaultInput();
    }

    public void setDefaultInput() {
        InputValue = "";
    }

    public String getInput() {
        return this.InputValue;
    }

    public void setInput() {
        Scanner scInput = new Scanner(System.in);
        this.InputValue = scInput.nextLine();
    }
}

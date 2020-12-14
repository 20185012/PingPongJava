package com.PongPingJava.GameUtils;

import java.util.Scanner;

public class UserInput {
    Scanner input = new Scanner(System.in);

    public String getUserInput() {
        return input.next();
    }

    public int getNumericalInput() {
        System.out.println("Enter number: ");
        do {

            String input = getUserInput();

            try {
                int numericalInput = Integer.parseInt(input);
                return numericalInput;
            } catch (NumberFormatException e) {
                System.out.println("Your input is not a valid number, try again: ");
            }
        } while (true);
    }

    public MovingDirection inputMovingDirection(String UpKey, String DownKey) {

        String key = getUserInput();

        if (key.equals(UpKey)) return MovingDirection.Up;
        else if (key.equals(DownKey)) return MovingDirection.Down;
        else return MovingDirection.None;
    }

    public Position inputPosition() {
        Position position = new Position();

        System.out.print("Enter X coordinate: ");
        position.setX(getNumericalInput());

        System.out.println("Enter Y coordinate: ");
        position.setY(getNumericalInput());

        return position;
    }

    public boolean userWantsToPlayAgain() {
        System.out.println("Do you want to play again? y/anyKey");
        if (getUserInput().toUpperCase().equals("Y")) return true;
        return false;
    }
}

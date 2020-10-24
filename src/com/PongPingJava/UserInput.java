package com.PongPingJava;

import java.util.Scanner;

public class UserInput {
    Scanner input = new Scanner(System.in);

    public String getUserInput()
    {
        return input.next();
    }

    public MovingDirection makeMovingDirection(String UpKey, String DownKey, String key) {
        if (key.equals(UpKey)) return MovingDirection.Up;
        else if (key.equals(DownKey)) return MovingDirection.Down;
        else return MovingDirection.None;
    }
}

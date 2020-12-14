package com.PongPingJava.GameUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovingDirectionFactory {
    public MovingDirection getMovingDirection(String directionText) {
        if (directionText.toUpperCase().equals("UPRIGHT")) {
            return MovingDirection.UpRight;
        } else if (directionText.toUpperCase().equals("UPLEFT")) {
            return MovingDirection.UpLeft;
        } else if (directionText.toUpperCase().equals("DOWNRIGHT")) {
            return MovingDirection.DownRight;
        } else if (directionText.toUpperCase().equals("DOWNLEFT")) {
            return MovingDirection.DownLeft;
        } else if (directionText.toUpperCase().equals("UP")) {
            return MovingDirection.Up;
        } else if (directionText.toUpperCase().equals("DOWN")) {
            return MovingDirection.Down;
        } else {
            return MovingDirection.None;
        }

    }
}

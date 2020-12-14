package com.PongPingJava.GameObject;

import com.PongPingJava.GameUtils.MovingDirection;
import com.PongPingJava.GameUtils.Position;
import lombok.Data;

@Data
public class GameObject {
    protected Position position;
    protected MovingDirection movingDirection = MovingDirection.None;

    public void move() {
        moveGameObjectInDirection(this.movingDirection);
    }

    public int getX() {
        return position.getX();
    }

    public void moveGameObjectInDirection(MovingDirection movingDirection) {
        switch (movingDirection) {
            case Up -> position = position.up();
            case Down -> position = position.down();
            case UpRight -> position = position.upRight();
            case UpLeft -> position = position.upLeft();
            case DownRight -> position = position.downRight();
            case DownLeft -> position = position.downLeft();
        }
    }
}

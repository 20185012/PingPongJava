package com.PongPingJava.GameObject;

import com.PongPingJava.GameRules.BallGameRules;
import com.PongPingJava.GameUtils.MovingDirection;
import com.PongPingJava.GameUtils.Position;
import lombok.Data;


@Data
public class Ball extends GameObject {

    public Ball(Position position, MovingDirection movingDirection, BallGameRules ballGameRules) {
        this.position = position;
        this.movingDirection = movingDirection;
    }

    public void move(MovingDirection movingDirection) {
        moveGameObjectInDirection(movingDirection);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "position=" + position +
                '}';
    }
}

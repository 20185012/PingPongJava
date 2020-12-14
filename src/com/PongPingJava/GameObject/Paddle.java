package com.PongPingJava.GameObject;

import com.PongPingJava.GameRules.PaddleGameRules;
import com.PongPingJava.GameUtils.Controls;
import com.PongPingJava.GameUtils.MovingDirection;
import com.PongPingJava.GameUtils.Position;
import lombok.Data;

@Data
public class Paddle extends GameObject {
    private Controls controls;
    private int paddleLength = 5;

    public Paddle(Position position, String controlUp, String controlDown, PaddleGameRules paddleGameRules) {
        this.position = position;
        controls = new Controls(controlUp, controlDown);
    }

    public int getX() {
        return position.getX();
    }

    public Position getTopOfPaddle() {
        return new Position(position.getY() - paddleLength / 2, getX());
    }

    public Position getBottomOfPaddle() {
        return new Position(position.getY() + paddleLength / 2, getX());
    }

    public void setMovingDirection(MovingDirection movingDirection) {
        this.movingDirection = movingDirection;
    }

    public boolean collidesWithPaddle(Position position) {
        return pointMatchesWithPaddle(position.getY(), position.getX());
    }

    public boolean pointMatchesWithPaddle(int y, int x) {
        return x == getBottomOfPaddle().getX() &&
                (y <= getBottomOfPaddle().getY() && y >= getTopOfPaddle().getY());
    }

    public boolean pointMatchesWithPaddle(Position position) {
        return pointMatchesWithPaddle(position.getY(), position.getX());
    }

    @Override
    public String toString() {
        return "Paddle{" +
                "position=" + position +
                '}';
    }
}

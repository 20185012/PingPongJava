package com.PongPingJava;

public class Ball {
    Position position;
    int xVelocity = 1;
    int yVelocity = 1;

    MovingDirection movingDirection;
    GameMap map;

    public Ball(Position position, MovingDirection movingDirection, GameMap map) {
        this.position = position;
        this.movingDirection = movingDirection;
        this.map = map;
    }

    public MovingDirection getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(MovingDirection movingDirection) {
        this.movingDirection = movingDirection;
    }

    public Position getPosition() {
        return position;
    }

    public void move(GameLevel gameLevel)
    {
        BallCollisionBehavior.collidesWithWall(map,this, gameLevel.getRightPaddle(), gameLevel.getLeftPaddle());

        switch (movingDirection)
        {
            case Up -> position = position.up();
            case Down -> position = position.down();
            case Right -> position = position.right();
            case Left -> position = position.left();
            case UpRight -> position = position.upRight();
            case UpLeft -> position = position.upLeft();
            case DownRight -> position = position.downRight();
            case DownLeft -> position =  position.downLeft();
        }
    }

}

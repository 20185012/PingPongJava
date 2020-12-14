package com.PongPingJava.GameRules;

import com.PongPingJava.GameObject.Ball;
import com.PongPingJava.GameObject.Paddle;
import com.PongPingJava.GameUtils.GameMap;
import com.PongPingJava.GameUtils.MovingDirection;

import java.util.List;

public class BallGameRules extends GameRules {
    private GameMap gameMap;

    private static final BallGameRules instance = new BallGameRules();

    private BallGameRules() {

    }

    public static BallGameRules getInstance() {
        return instance;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    public boolean collisionWithWall(Ball ball) {
        return gameMap.isWall(ball.getPosition());
    }

    public boolean collisionWithPaddle(Ball ball, List<Paddle> paddles) {
        return paddles.stream().anyMatch(paddle -> paddle.pointMatchesWithPaddle(ball.getPosition()));
    }


    public Ball ricochetOfWall(Ball ball) {
        ball.setMovingDirection(afterXAxisCollision(ball));
        return ball;
    }

    public Ball ricochetOfPaddle(Ball ball) {
        ball.setMovingDirection(afterYaxisCollision(ball));
        return ball;
    }


    public boolean touchesWallBehindPaddle(Ball ball) {
        return gameMap.isOnYAxisBorder(ball.getPosition()) || gameMap.isCorner(ball.getPosition());
    }


    public MovingDirection afterXAxisCollision(Ball ball) {
        return movingDirectionXAxisCollision(ball.getMovingDirection());
    }

    public MovingDirection afterYaxisCollision(Ball ball) {
        return movingDirectionYAxisCollision(ball.getMovingDirection());
    }

    public MovingDirection afterCornerCollision(Ball ball) {
        return movingDirectionCornerCollision(ball.getMovingDirection());
    }


    private MovingDirection movingDirectionXAxisCollision(MovingDirection movingDirection) {
        switch (movingDirection) {
            case UpRight -> movingDirection = MovingDirection.DownRight;
            case UpLeft -> movingDirection = MovingDirection.DownLeft;
            case DownRight -> movingDirection = MovingDirection.UpRight;
            case DownLeft -> movingDirection = MovingDirection.UpLeft;
        }
        return movingDirection;
    }

    private MovingDirection movingDirectionYAxisCollision(MovingDirection movingDirection) {
        switch (movingDirection) {
            case UpRight -> movingDirection = MovingDirection.UpLeft;
            case UpLeft -> movingDirection = MovingDirection.UpRight;
            case DownRight -> movingDirection = MovingDirection.DownLeft;
            case DownLeft -> movingDirection = MovingDirection.DownRight;
        }
        return movingDirection;
    }

    private MovingDirection movingDirectionCornerCollision(MovingDirection movingDirection) {
        switch (movingDirection) {
            case UpRight -> movingDirection = MovingDirection.DownLeft;
            case UpLeft -> movingDirection = MovingDirection.DownRight;
            case DownRight -> movingDirection = MovingDirection.UpLeft;
            case DownLeft -> movingDirection = MovingDirection.UpRight;
        }
        return movingDirection;
    }

}

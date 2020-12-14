package com.PongPingJava.GameUtils;


import com.PongPingJava.GameObject.Ball;
import com.PongPingJava.GameObject.Paddle;
import com.PongPingJava.GameRules.BallGameRules;
import com.PongPingJava.GameRules.PaddleGameRules;
import com.PongPingJava.Memento.GameLevelState;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameLevel {

    private GameMap gameMap;
    private Ball ball;
    List<Paddle> paddles;
    private PaddleGameRules paddleRules;
    private BallGameRules ballRules;
    private UserInput input = new UserInput();
    private MovingDirectionFactory directionFactory = new MovingDirectionFactory();
    private boolean isGameOver = false;

    public GameLevel(GameMap gameMap, Ball ball, List<Paddle> paddles, PaddleGameRules paddleRules, BallGameRules ballRules) {
        this.gameMap = gameMap;
        this.ball = ball;
        this.paddles = paddles;
        this.paddleRules = paddleRules;
        this.ballRules = ballRules;
    }

    public void nextFrame() throws InterruptedException {
        movePaddle();
        moveBall();
        if (ballRules.touchesWallBehindPaddle(ball)) isGameOver = true;
    }

    private void moveBall() {
        if (ballRules.collisionWithWall(ball)) {
            ball = ballRules.ricochetOfWall(ball);
        } else if (ballRules.collisionWithPaddle(ball, paddles)) {
            ball = ballRules.ricochetOfPaddle(ball);
        }
        ball.move();
    }

    private void movePaddle() {
        String userInput = input.getUserInput();

        for (Paddle paddle : paddles) {
            if (paddle.getControls().isControlUp(userInput)) {
                if (!paddleRules.paddleTouchesTopOfTheMap(paddle)) {
                    paddle.moveGameObjectInDirection(directionFactory.getMovingDirection("UP"));
                }
                break;
            } else if (paddle.getControls().isControlDown(userInput)) {
                if (!paddleRules.paddleTouchesBottomOfTheMap(paddle)) {
                    paddle.moveGameObjectInDirection(directionFactory.getMovingDirection("DOWN"));
                }
                break;
            }
        }
    }

    public GameLevelState saveGame() {
        List<Position> paddlePositions = new ArrayList<>();
        for (Paddle paddle : paddles) paddlePositions.add(paddle.getPosition());

        return new GameLevelState(ball.getPosition(), paddlePositions);
    }

    public void restore(GameLevelState savedGame) {
        ball.setPosition(savedGame.getSavedBallPosition());
        for (int i = 0; i < paddles.size(); i++) {
            paddles.get(i).setPosition(savedGame.getPaddlePositions().get(i));
        }
        isGameOver = false;
    }
}

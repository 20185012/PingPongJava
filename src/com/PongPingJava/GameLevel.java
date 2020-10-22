package com.PongPingJava;

public class GameLevel {
    private GameMap gameMap;
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    public GameLevel(GameMap gameMap, Ball ball, Paddle leftPaddle, Paddle rightPaddle) {
        setGameMap(gameMap);
        setBall(ball);
        setRightPaddle(rightPaddle);
        setLeftPaddle(leftPaddle);
    }

    public Paddle getLeftPaddle() {
        return leftPaddle;
    }

    private void setLeftPaddle(Paddle leftPaddle) {
        this.leftPaddle = leftPaddle;
    }

    public Paddle getRightPaddle() {
        return rightPaddle;
    }

    private void setRightPaddle(Paddle rightPaddle) {
        this.rightPaddle = rightPaddle;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }



    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}

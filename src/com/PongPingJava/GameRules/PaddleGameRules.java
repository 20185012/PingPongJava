package com.PongPingJava.GameRules;

import com.PongPingJava.GameObject.Paddle;
import com.PongPingJava.GameUtils.GameMap;

public class PaddleGameRules extends GameRules {
    GameMap gameMap;

    private static PaddleGameRules instance = new PaddleGameRules();

    private PaddleGameRules() {

    }

    public static PaddleGameRules getInstance() {
        return instance;
    }


    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    public boolean collisionFound(Paddle paddle) {
        return paddleTouchesTopOfTheMap(paddle) || paddleTouchesBottomOfTheMap(paddle);
    }


    public boolean paddleTouchesTopOfTheMap(Paddle paddle) {
        return gameMap.isOnXAxisBorder(paddle.getTopOfPaddle());
    }

    public boolean paddleTouchesBottomOfTheMap(Paddle paddle) {
        return gameMap.isOnXAxisBorder(paddle.getBottomOfPaddle());
    }
}

package com.PongPingJava.GameRules;

import com.PongPingJava.GameUtils.GameMap;

public abstract class GameRules {
    public GameMap gameMap;

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}

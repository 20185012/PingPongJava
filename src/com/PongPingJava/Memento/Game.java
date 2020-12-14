package com.PongPingJava.Memento;

import com.PongPingJava.GameUtils.GameLevel;
import com.PongPingJava.GameUtils.GameRenderer;

public class Game {

    private GameLevel gameLevel;
    private GameLevelState savedGameLevel;
    private GameRenderer renderer;

    public Game(GameLevel gameLevel, GameRenderer renderer) {
        this.gameLevel = gameLevel;
        this.renderer = renderer;
    }

    public void play() throws InterruptedException {
        renderer.renderMap(gameLevel);
        gameLevel.nextFrame();
    }

    public boolean isGameOver()
    {
        return gameLevel.isGameOver();
    }

    public void save(){
        savedGameLevel = gameLevel.saveGame();
    }

    public void restore()
    {
        gameLevel.restore(savedGameLevel);
    }
}

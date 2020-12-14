package com.PongPingJava.Memento;

import com.PongPingJava.GameUtils.GameLevel;
import com.PongPingJava.GameUtils.Position;

import java.util.ArrayList;
import java.util.List;

public class GameLevelState {
    Position ballPosition;
    List<Position> paddlePositions = new ArrayList<>();

    public GameLevelState(Position ballPosition, List<Position> paddlePositions) {
        this.ballPosition = ballPosition;
        this.paddlePositions = paddlePositions;
    }

    public Position getSavedBallPosition() {
        return ballPosition;
    }

    public List<Position> getPaddlePositions()
    {
        return paddlePositions;
    }
}

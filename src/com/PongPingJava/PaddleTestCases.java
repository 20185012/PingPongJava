package com.PongPingJava;

import com.PongPingJava.GameObject.Ball;
import com.PongPingJava.GameObject.Paddle;
import com.PongPingJava.GameRules.BallGameRules;
import com.PongPingJava.GameRules.PaddleGameRules;
import com.PongPingJava.GameUtils.GameMap;
import com.PongPingJava.GameUtils.MovingDirection;
import com.PongPingJava.GameUtils.Position;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaddleTestCases {
    @Test
    public void shouldBeTrueWhenTouchingBottomOfMap() {
        GameMap map = new GameMap(40, 15);

        PaddleGameRules rules = PaddleGameRules.getInstance();
        rules.setGameMap(map);
        Paddle paddle = new Paddle(new Position(12, 2), "", "", rules);

        assertEquals(true, rules.paddleTouchesBottomOfTheMap(paddle));
    }

    @Test
    public void shouldBeTrueWhenTouchingTopBorder() {
        GameMap map = new GameMap(40, 15);

        PaddleGameRules rules = PaddleGameRules.getInstance();
        rules.setGameMap(map);
        Paddle paddle = new Paddle(new Position(2, 2), "", "", rules);

        assertEquals(true, rules.paddleTouchesTopOfTheMap(paddle));
    }
}

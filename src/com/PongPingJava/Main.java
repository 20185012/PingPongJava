package com.PongPingJava;

import com.PongPingJava.GameObject.Ball;
import com.PongPingJava.GameObject.Paddle;
import com.PongPingJava.GameRules.BallGameRules;
import com.PongPingJava.GameRules.PaddleGameRules;
import com.PongPingJava.GameUtils.*;
import com.PongPingJava.Memento.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GameMap map = new GameMap(40, 15);
        UserInput input = new UserInput();

        BallGameRules ballRules = BallGameRules.getInstance();
        ballRules.setGameMap(map);

        PaddleGameRules paddleRules = PaddleGameRules.getInstance();
        paddleRules.setGameMap(map);


        Ball ball = new Ball(map.getMiddleOfMap(), MovingDirection.DownLeft, ballRules);

        List<Paddle> paddles = new ArrayList<>();
        paddles.add(new Paddle(map.getMiddleOfYAxisNearLeftBorder(), "7", "1", paddleRules));
        paddles.add(new Paddle(map.getgetMiddleOfYAxisNearRightBorder(), "8", "2", paddleRules));

        GameLevel gameLevel = new GameLevel(map, ball, paddles, paddleRules, ballRules);

        GameRenderer renderer = new GameRenderer();

        Game game = new Game(gameLevel, renderer);

        game.save();

        do {
            game.restore();

            while (!game.isGameOver()) {
                game.play();
            }
        } while (input.userWantsToPlayAgain());


    }
}

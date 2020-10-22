package com.PongPingJava;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap(40,15);
        Position middleOfMap = new Position(5,5);

        Ball ball = new Ball(middleOfMap,MovingDirection.UpLeft,map);

        Paddle rightPaddle = new Paddle(new Position(map.getHeight()-14, 2),
                                        new Position(map.getHeight()-2,2));//simplify

        Paddle leftPaddle = new Paddle(new Position(map.getHeight()-14, map.getWidth()-3),
                                       new Position(map.getHeight()-2,map.getWidth()-3));//simplify


        GameLevel gameLevel = new GameLevel(map, ball, rightPaddle, leftPaddle);

        GameRenderer renderer = new GameRenderer();

        renderer.renderMap(gameLevel);

        while (true)
        {
            ball.move(gameLevel);
            renderer.renderMap(gameLevel);
            Thread.sleep(300);
        }
    }
}

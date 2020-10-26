package com.PongPingJava;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap(40,15);
        Position middleOfMap = new Position(5,5);

        Ball ball = new Ball(middleOfMap,MovingDirection.UpLeft,map);

        Paddle rightPaddle = new Paddle(new Position(map.getHeight()-2, 1),
                                        new Position(map.getHeight()-6,1),map,"1","7");//simplify, reduce need of constants, GameMap can't go here

        Paddle leftPaddle = new Paddle(new Position(map.getHeight()-2, map.getWidth()-2),
                                       new Position(map.getHeight()-6,map.getWidth()-2),map,"2","8");


        GameLevel gameLevel = new GameLevel(map, ball, rightPaddle, leftPaddle);

        GameRenderer renderer = new GameRenderer();

        UserInput input = new UserInput();

        renderer.renderMap(gameLevel);

        while (true)
        {
            ball.move(gameLevel);
            renderer.renderMap(gameLevel);
            Thread.sleep(300);

            String key = input.getUserInput();

            if (key.equals(rightPaddle.getControlDown()) || key.equals(rightPaddle.getControlUp()))
                rightPaddle.move(input.makeMovingDirection("7","1",key));

            else if (key.equals(leftPaddle.getControlDown()) || key.equals(leftPaddle.getControlUp()))
                leftPaddle.move(input.makeMovingDirection("8","2", key));
        }
    }
}

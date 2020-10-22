package com.PongPingJava;

public class BallCollisionBehavior {
    public static void collidesWithWall(GameMap map, Ball ball, Paddle rightPaddle, Paddle leftPaddle)
    {
        if (map.isWallOnYAxis(ball.getPosition())) {
            ball.setMovingDirection(newMovingDirectionXAxis(ball.getMovingDirection()));
        }
        else if (map.isWallOnXAxis(ball.getPosition()))
        {
            ball.setMovingDirection(newMovingDirectionYAxis(ball.getMovingDirection()));
        }
        else if (map.isCorner(ball.getPosition()))
        {
            ball.setMovingDirection(newMovingDirectionCorner(ball.getMovingDirection()));
        }

        else if (rightPaddle.isTouchingPaddle(ball.getPosition()))
        {
            ball.setMovingDirection(newMovingDirectionYAxis(ball.getMovingDirection()));
        }

        else if (leftPaddle.isTouchingPaddle(ball.getPosition()))
        {
            ball.setMovingDirection(newMovingDirectionYAxis(ball.getMovingDirection()));
        }
    }



    static MovingDirection newMovingDirectionXAxis(MovingDirection movingDirection)
    {
        switch (movingDirection)
        {
            case Up -> movingDirection = MovingDirection.Down;
            case Down -> movingDirection = MovingDirection.Up;
            case Right -> movingDirection = MovingDirection.Left;
            case Left -> movingDirection = MovingDirection.Right;
            case UpRight -> movingDirection = MovingDirection.DownRight;
            case UpLeft -> movingDirection = MovingDirection.DownLeft;
            case DownRight -> movingDirection = MovingDirection.UpRight;
            case DownLeft -> movingDirection = MovingDirection.UpLeft;
        }
        return movingDirection;
    }

    static MovingDirection newMovingDirectionYAxis(MovingDirection movingDirection)
    {
        switch (movingDirection)
        {
            case Up -> movingDirection = MovingDirection.Down;
            case Down -> movingDirection = MovingDirection.Up;
            case Right -> movingDirection = MovingDirection.Left;
            case Left -> movingDirection = MovingDirection.Right;
            case UpRight -> movingDirection = MovingDirection.UpLeft;
            case UpLeft -> movingDirection = MovingDirection.UpRight;
            case DownRight -> movingDirection = MovingDirection.DownLeft;
            case DownLeft -> movingDirection = MovingDirection.DownRight;
        }
        return movingDirection;
    }

    static MovingDirection newMovingDirectionCorner(MovingDirection movingDirection)
    {
        switch (movingDirection)
        {
            case Up -> movingDirection = MovingDirection.Down;
            case Down -> movingDirection = MovingDirection.Up;
            case Right -> movingDirection = MovingDirection.Left;
            case Left -> movingDirection = MovingDirection.Right;
            case UpRight -> movingDirection = MovingDirection.DownLeft;
            case UpLeft -> movingDirection = MovingDirection.DownRight;
            case DownRight -> movingDirection = MovingDirection.UpLeft;
            case DownLeft -> movingDirection = MovingDirection.UpRight;
        }
        return movingDirection;
    }

}

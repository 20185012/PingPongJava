package com.PongPingJava;

public class GameRenderer {
    public void renderMap(GameLevel gameLevel)
    {
        for (int y = 0; y < gameLevel.getGameMap().getHeight(); y++)
        {
            for (int x = 0; x < gameLevel.getGameMap().getWidth(); x++)
            {
                if (gameLevel.getBall().getPosition().at(y, x))
                    System.out.print("O");

                else if (x == gameLevel.getRightPaddle().getX() && gameLevel.getRightPaddle().pointIsInRangeOfPaddle(y)) {
                    System.out.print("+");
                }

                else if (x == gameLevel.getLeftPaddle().getX() && gameLevel.getLeftPaddle().pointIsInRangeOfPaddle(y)) {
                    System.out.print("+");
                }
                else if (gameLevel.getGameMap().isCorner(y, x))
                    System.out.print("#");

                else if (gameLevel.getGameMap().isEmptySpace(y, x))
                    System.out.print(" ");

                else if(gameLevel.getGameMap().isWallOnXAxis(y, x))
                    System.out.print("|");

                else if (gameLevel.getGameMap().isWallOnYAxis(y, x))
                    System.out.print("-");
            }
            System.out.println();
        }
    }
}

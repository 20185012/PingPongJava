package com.PongPingJava.GameUtils;

public class GameRenderer {
    public void renderMap(GameLevel gameLevel) {
        System.out.println();
        for (int y = 0; y < gameLevel.getGameMap().getHeight(); y++) {
            for (int x = 0; x < gameLevel.getGameMap().getWidth(); x++) {

                int finalY = y;
                int finalX = x;

                if (gameLevel.getBall().getPosition().at(y, x))
                    System.out.print("O");

                else if (gameLevel.getPaddles().stream().anyMatch(paddle -> paddle.pointMatchesWithPaddle(finalY, finalX)))
                    System.out.print("+");

                else if (gameLevel.getGameMap().isCorner(y, x))
                    System.out.print("#");

                else if (gameLevel.getGameMap().isEmptySpace(y, x))
                    System.out.print(" ");

                else if (gameLevel.getGameMap().isOnXAxisBorder(y, x))
                    System.out.print("-");

                else if (gameLevel.getGameMap().isOnYAxisBorder(y, x))
                    System.out.print("|");
            }
            System.out.println();
        }
    }
}

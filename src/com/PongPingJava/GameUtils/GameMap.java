package com.PongPingJava.GameUtils;

public class GameMap {
    private final int width;
    private final int height;

    int wallXAxisRepresentation = 1;
    int wallYAxisRepresentation = 2;
    int emptySpaceRepresentation = 0;
    int cornerRepresentation = 3;

    int[][] model = null;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;

        model = createGameField(width, height);
    }

    private int[][] createGameField(int width, int height) {

        int playGround[][] = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    if (j == 0) playGround[i][j] = cornerRepresentation;
                    else if (j > 0 && j < width - 1) playGround[i][j] = wallXAxisRepresentation;
                    else if (j == width - 1) playGround[i][j] = cornerRepresentation;
                } else if (i > 0 && i < height - 1) {
                    if (j == 0) playGround[i][j] = wallYAxisRepresentation;
                    else if (j > 0 && j < width - 1) playGround[i][j] = emptySpaceRepresentation;
                    else if (j == width - 1) playGround[i][j] = wallYAxisRepresentation;
                } else if (i == height - 1) {
                    if (j == 0) playGround[i][j] = cornerRepresentation;
                    else if (j > 0 && j < width - 1) playGround[i][j] = wallXAxisRepresentation;
                    else if (j == width - 1) playGround[i][j] = cornerRepresentation;
                }
            }
        }

        return playGround;
    }

    public int getWidth() {
        return width;
    }

    public int getXAxisNearLeftBorder() {
        return 2;
    }

    public int getXAxisNearRightBorder() {
        return width - 3;
    }

    public int getHeight() {
        return height;
    }

    public Position getMiddleOfMap() {
        return new Position(getMiddleOfYAxis(), getMiddleOfXAxis());
    }

    public int getMiddleOfYAxis() {
        return height / 2;
    }

    public int getMiddleOfXAxis() {
        return width / 2;
    }

    public Position getMiddleOfYAxisNearLeftBorder() {
        return new Position(getMiddleOfYAxis(), getXAxisNearLeftBorder());
    }

    public Position getgetMiddleOfYAxisNearRightBorder() {
        return new Position(getMiddleOfYAxis(), getXAxisNearRightBorder());
    }

    public boolean isEmptySpace(int y, int x) {
        return model[y][x] == emptySpaceRepresentation;
    }

    public boolean isCorner(int y, int x) {
        return model[y][x] == cornerRepresentation;
    }

    public boolean isOnYAxisBorder(int y, int x) {
        return model[y][x] == wallYAxisRepresentation;
    }

    public boolean isOnXAxisBorder(int y, int x) {
        return model[y][x] == wallXAxisRepresentation;
    }

    public boolean isOnYAxisBorder(Position position) {
        return model[position.getY()][position.getX()] == wallYAxisRepresentation;
    }

    public boolean isOnXAxisBorder(Position position) {
        return model[position.getY()][position.getX()] == wallXAxisRepresentation;
    }

    public boolean isWall(Position position) {
        return isOnXAxisBorder(position);
    }

    public boolean isWallBehindPaddle(Position position) {
        return isOnYAxisBorder(position) || isCorner(position);
    }

    public boolean isCorner(Position position) {
        return model[position.getY()][position.getX()] == cornerRepresentation;
    }
}

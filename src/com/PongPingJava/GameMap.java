package com.PongPingJava;

public class GameMap {
    private int width;
    private int height;

    public int width() {
        return width;
    }

    public int heigth() {
        return height;
    }

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

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (i == 0)
                {
                    if (j==0) playGround[i][j] = cornerRepresentation;
                    else if (j > 0 && j < width-1) playGround[i][j] = wallYAxisRepresentation;
                    else if (j == width - 1) playGround[i][j] = cornerRepresentation;
                }
                else if (i > 0 && i < height - 1)
                {
                    if (j == 0) playGround[i][j] = wallXAxisRepresentation;
                    else if (j > 0 && j < width - 1) playGround[i][j] = emptySpaceRepresentation;
                    else if (j == width - 1) playGround[i][j] = wallXAxisRepresentation;
                }
                else if (i == height - 1)
                {
                    if (j==0) playGround[i][j] = cornerRepresentation;
                    else if (j > 0 && j < width-1) playGround[i][j] = wallYAxisRepresentation;
                    else if (j == width - 1) playGround[i][j] = cornerRepresentation;
                }
            }
        }

        return playGround;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isEmptySpace(int y, int x) { return model[y][x] == emptySpaceRepresentation; }

    public boolean isCorner(int y, int x) { return model[y][x] == cornerRepresentation; }

    public boolean isWallOnYAxis(int y, int x) { return model[y][x] == wallYAxisRepresentation; }

    public boolean isWallOnXAxis(int y, int x) { return model[y][x] == wallXAxisRepresentation; }

    public boolean isWallOnYAxis(Position position) { return model[position.getY()][position.getX()] == wallYAxisRepresentation; }

    public boolean isWallOnXAxis(Position position) { return model[position.getY()][position.getX()] == wallXAxisRepresentation; }
    public boolean isCorner(Position position) { return model[position.getY()][position.getX()] == cornerRepresentation; }
}

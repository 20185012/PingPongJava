package com.PongPingJava;

public class Paddle {
    Position paddleBottom;
    Position paddleTop;
    GameMap gameMap;
    String controlUp;
    String controlDown;

    public Paddle(Position paddleBottom,Position paddleTop, GameMap gamemap, String controlDown, String controlUp) { //not good sending gamemap to paddle
        setPaddleBottom(paddleBottom);
        setPaddleTop(paddleTop);
        setGameMap(gamemap);
        setControlDown(controlDown);
        setControlUp(controlUp);
    }

    public String getControlUp() {
        return controlUp;
    }

    private void setControlUp(String controlUp) {
        this.controlUp = controlUp;
    }

    public String getControlDown() {
        return controlDown;
    }

    private void setControlDown(String controlDown) {
        this.controlDown = controlDown;
    }

    public Position getPaddleBottom() {
        return paddleBottom;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    private void setPaddleBottom(Position paddleBottom) {
        this.paddleBottom = paddleBottom;
    }

    public Position getPaddleTop() {
        return paddleTop;
    }

    public int getX() { return paddleBottom.getX(); }

    private void setPaddleTop(Position paddleTop) {
        this.paddleTop = paddleTop;
    }


    public boolean pointIsInRangeOfPaddle(int y)//get this to some other class
    {
        return y <= this.paddleBottom.getY() && y >= this.paddleTop.getY();
    }


    public boolean isTouchingPaddle(Position position)
    {
        return position.getX() == this.paddleBottom.getX() &&
               (position.getY() <= this.paddleBottom.getY() && position.getY() >= this.paddleTop.getY());
    }

    public void move(MovingDirection movingDirection)//will have to moved to other class
    {
            switch (movingDirection) {
                case Up:

                    if (!gameMap.isWallOnYAxis(this.paddleTop)) //make this statment smaller
                    {
                        paddleBottom = paddleBottom.up();
                        paddleTop = paddleTop.up();
                    }
                    break;

                case Down:

                    if (!gameMap.isWallOnYAxis(this.paddleBottom)) //make this statment smaller
                    {
                        paddleBottom = paddleBottom.down();
                        paddleTop = paddleTop.down();
                    }
                    break;
            }
    }
}

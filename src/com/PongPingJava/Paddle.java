package com.PongPingJava;

public class Paddle {
    Position paddleBottom;
    Position paddleTop;

    public Paddle(Position paddleBottom, Position paddleTop) {
        setPaddleBottom(paddleBottom);
        setPaddleTop(paddleTop);
    }

    public Position getPaddleBottom() {
        return paddleBottom;
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

    public boolean pointIsInRangeOfPaddle(int y)
    {
        return y >= this.getPaddleBottom().getY() && y <= this.getPaddleTop().getY();
    }


    public boolean isTouchingPaddle(Position position)
    {
        return position.getX() == this.paddleBottom.getX() &&
               (position.getY() >= this.paddleBottom.getY() && position.getY() <= this.paddleTop.getY());
    }
}

package com.PongPingJava;

public class Position {
    private int x;
    private int y;

    public Position(int y, int x) {
        setX(x);
        setY(y);
    }

    public Position(Position position) {
        setX(position.x);
        setY(position.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Position pos) {
        return this.x == pos.getX() && this.y == pos.getY();
    }

    public Position left() {
        return new Position(y, x-1);
    }

    public Position right() {
        return new Position(y, x+1);
    }

    public Position up() { return new Position(y - 1, x); }

    public Position down() { return new Position(y+1, x  ); }



    public Position upRight() {
        return new Position(y-1, x+1);
    }

    public Position upLeft() {
        return new Position(y-1, x-1);
    }

    public Position downRight() {
        return new Position(y+1, x+1);
    }

    public Position downLeft() { return new Position(y+1, x-1); }



    public Position addX(int dx) {
        this.x += dx;
        return this;
    }

    public Position addY(int dy) {
        this.y += dy;
        return this;
    }

    public boolean at(int y2, int x2) {
        return this.x == x2 && this.y == y2;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

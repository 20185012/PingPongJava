package com.PongPingJava;

import com.PongPingJava.GameUtils.GameMap;
import com.PongPingJava.GameUtils.Position;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapTestCases {

    @Test
    public void shouldBeCornerOfMap() {
        GameMap map = new GameMap(40, 15);
        Position position = new Position(0, 0);

        assertEquals(true, map.isCorner(position));
    }

    @Test
    public void shouldBeXAxisWall() {
        GameMap map = new GameMap(40, 15);
        Position position = new Position(0, 37);

        assertEquals(true, map.isOnXAxisBorder(position));
    }


    @Test
    public void shouldBeYAxisWall() {
        GameMap map = new GameMap(40, 15);
        Position position = new Position(5, 39);

        assertEquals(true, map.isOnYAxisBorder(position));
    }
}

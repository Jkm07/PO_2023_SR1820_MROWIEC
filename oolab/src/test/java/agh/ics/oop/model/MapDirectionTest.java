package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {

    @Test
    public void next() {
        Assertions.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assertions.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    public void previous() {
        Assertions.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        Assertions.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }
}

package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    @Test
    public void rotateRight()
    {
        String[] arg = new String[] {"r", "r", "r", "r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);
        Vector2d constPosition = animal.getPosition();

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.WEST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());
    }

    @Test
    public void rotateLeft()
    {
        String[] arg = new String[] {"l", "l", "l", "l"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.LEFT};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);
        Vector2d constPosition = animal.getPosition();

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.WEST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());
    }

    @Test
    public void rotateMix1()
    {
        String[] arg = new String[] {"r", "l", "l", "r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);
        Vector2d constPosition = animal.getPosition();

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.WEST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());
    }

    @Test
    public void rotateMix2()
    {
        String[] arg = new String[] {"r", "r", "r", "l", "l", "r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);
        Vector2d constPosition = animal.getPosition();

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.WEST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[4], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());

        animal.move((MoveDirection) result[5], map);
        Assertions.assertEquals(MapDirection.SOUTH, animal.getDirection());
        Assertions.assertEquals(constPosition, animal.getPosition());
    }


    @Test
    public void toTopBorder()
    {
        String[] arg = new String[] {"f", "f", "f", "b"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 3), animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 4), animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 4), animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 3), animal.getPosition());
    }

    @Test
    public void toBotBorder()
    {
        String[] arg = new String[] {"b", "b", "b", "f"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 1), animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 0), animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 0), animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.NORTH, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 1), animal.getPosition());
    }

    @Test
    public void toRightBorder()
    {
        String[] arg = new String[] {"r", "f", "f", "f", "b"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 2), animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(3, 2), animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(4, 2), animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(4, 2), animal.getPosition());

        animal.move((MoveDirection) result[4], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(3, 2), animal.getPosition());
    }

    @Test
    public void toLeftBorder()
    {
        String[] arg = new String[] {"r", "b", "b", "b", "f"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD};
        Assertions.assertArrayEquals(expected, result);


        Animal animal = new Animal();
        WorldMap map = new RectangularMap(4, 4);
        map.place(animal);
        Assertions.assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move((MoveDirection) result[0], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2, 2), animal.getPosition());

        animal.move((MoveDirection) result[1], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(1, 2), animal.getPosition());

        animal.move((MoveDirection) result[2], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(0, 2), animal.getPosition());

        animal.move((MoveDirection) result[3], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(0, 2), animal.getPosition());

        animal.move((MoveDirection) result[4], map);
        Assertions.assertEquals(MapDirection.EAST, animal.getDirection());
        Assertions.assertEquals(new Vector2d(1, 2), animal.getPosition());
    }
}

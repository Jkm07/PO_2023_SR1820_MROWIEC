package agh.ics.oop.model;

import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RectangularMapTest {
    WorldMap map;
    List<Animal> animals;
    @BeforeEach
    public void beforeEach() {
        map = new RectangularMap(4, 4);
        animals = new ArrayList<>();
    }

    @Test
    public void rotateRight() throws PositionAlreadyOccupiedException {

        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d constPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.SOUTH, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.WEST, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void rotateLeft() throws PositionAlreadyOccupiedException {

        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d constPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.WEST, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.SOUTH, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(constPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void moveToNorth() throws PositionAlreadyOccupiedException {

        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d currPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, 1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, 1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void moveToEast() throws PositionAlreadyOccupiedException {

        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d currPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void moveToWest() throws PositionAlreadyOccupiedException {

        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d currPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(-1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(-1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void moveToSouth() throws PositionAlreadyOccupiedException {
        animals.add(new Animal());
        map.place(animals.get(0));
        checkAnimalMapCohesion(animals.get(0));
        Vector2d currPosition = animals.get(0).getPosition();

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, -1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, -1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
    }

    @Test
    public void collisionDetect() throws PositionAlreadyOccupiedException {
        animals.add(new Animal(new Vector2d(2, 2)));
        animals.add(new Animal(new Vector2d(3, 2)));
        animals.add(new Animal(new Vector2d(1, 2)));
        animals.add(new Animal(new Vector2d(2, 3)));
        animals.add(new Animal(new Vector2d(2, 1)));
        map.place(animals.get(0));
        map.place(animals.get(1));
        map.place(animals.get(2));
        map.place(animals.get(3));
        map.place(animals.get(4));
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
        var center = animals.get(0).getPosition();
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(center, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(center, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
        map.move(animals.get(0), MoveDirection.RIGHT);
        Assertions.assertEquals(center, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(center, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(center, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        checkAnimalMapCohesion(animals.get(2));
        checkAnimalMapCohesion(animals.get(3));
        checkAnimalMapCohesion(animals.get(4));
    }

    @Test
    public void collisionDetectMove() throws PositionAlreadyOccupiedException {
        animals.add(new Animal(new Vector2d(2, 2)));
        animals.add(new Animal(new Vector2d(2, 3)));
        map.place(animals.get(0));
        map.place(animals.get(1));
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2, 2), animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        map.move(animals.get(1), MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2, 4), animals.get(1).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        Assertions.assertFalse(map.isOccupied(new Vector2d(2, 3)));
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2, 3), animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        Assertions.assertFalse(map.isOccupied(new Vector2d(2, 2)));
        map.move(animals.get(1), MoveDirection.BACKWARD);
        Assertions.assertEquals(new Vector2d(2, 4), animals.get(1).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        map.move(animals.get(0), MoveDirection.RIGHT);
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(3, 3), animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
        map.move(animals.get(1), MoveDirection.BACKWARD);
        Assertions.assertEquals(new Vector2d(2, 3), animals.get(1).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
    }

    @Test
    public void placeErrorTest() throws PositionAlreadyOccupiedException {
        animals.add(new Animal(new Vector2d(2, 2)));
        animals.add(new Animal(new Vector2d(2, 2)));
        Assertions.assertDoesNotThrow(() -> map.place(animals.get(0)));
        Assertions.assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animals.get(1)));
    }
    @Test
    public void placeErrorMoveTest() throws PositionAlreadyOccupiedException {
        animals.add(new Animal(new Vector2d(2, 2)));
        animals.add(new Animal(new Vector2d(2, 2)));
        Assertions.assertDoesNotThrow(() -> map.place(animals.get(0)));
        Assertions.assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animals.get(1)));
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertDoesNotThrow(() -> map.place(animals.get(1)));
    }

    @Test
    public void moveBeforePlaceTest() {
        var position = new Vector2d(2, 2);
        animals.add(new Animal(position));
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position));
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position.add(new Vector2d(0, 1))));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position));
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position.add(new Vector2d(0, -1))));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
    }

    private void checkAnimalMapCohesion(Animal animal) {
        Assertions.assertEquals(animal, map.objectAt(animal.getPosition()));
    }
}

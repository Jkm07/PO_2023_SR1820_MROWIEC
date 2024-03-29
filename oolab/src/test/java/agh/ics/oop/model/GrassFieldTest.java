package agh.ics.oop.model;

import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GrassFieldTest {

    GrassField map;
    List<Animal> animals;
    final int quantityOfGrass = 10;
    @BeforeEach
    public void beforeEach() {
        map = new GrassField(quantityOfGrass);
        animals = new ArrayList<>();
    }

    @Test
    public void countGrassTest() {
        int countedGrass = 0;
        for (int i = -100; i <= 100; i++) {
            for(int j = -100; j <= 100; j++)
                if(map.objectAt(new Vector2d(i, j)).orElse(null) instanceof Grass) countedGrass++;
        }
        Assertions.assertEquals(quantityOfGrass, countedGrass);

        countedGrass = 0;
        for (int i = 0; i <= 10; i++) {
            for(int j = 0; j <= 10; j++)
                if(map.objectAt(new Vector2d(i, j)).orElse(null) instanceof Grass) countedGrass++;
        }
        Assertions.assertEquals(quantityOfGrass, countedGrass);
    }

    @Test
    public void assertIsOccupied() throws PositionAlreadyOccupiedException {
        for (int i = 0; i <= 10; i++) {
            for(int j = 0; j <= 10; j++)
            {
                var position = new Vector2d(i, j);
                if(map.objectAt(position).orElse(null) instanceof Grass) {
                    var animal = new Animal(position);
                    map.place(animal);
                    Assertions.assertInstanceOf(Animal.class, map.objectAt(position).orElse(null));
                    map.move(animal, MoveDirection.FORWARD);
                    Assertions.assertInstanceOf(Grass.class, map.objectAt(position).orElse(null));
                }
            }

        }
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
        currPosition = currPosition.add(new Vector2d(0, 1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, 1));
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
        currPosition = currPosition.add(new Vector2d(1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(1, 0));
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
        currPosition = currPosition.add(new Vector2d(-1, 0));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.EAST, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(-1, 0));
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
        currPosition = currPosition.add(new Vector2d(0, -1));
        Assertions.assertEquals(currPosition, animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));

        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        currPosition = currPosition.add(new Vector2d(0, -1));
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
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2, 3), animals.get(0).getPosition());
        checkAnimalMapCohesion(animals.get(0));
        checkAnimalMapCohesion(animals.get(1));
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
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position).orElse(null));
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position.add(new Vector2d(0, 1))).orElse(null));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.BACKWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position).orElse(null));
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position.add(new Vector2d(0, -1))).orElse(null));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position).orElse(null));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
        map.move(animals.get(0), MoveDirection.FORWARD);
        Assertions.assertNotEquals(animals.get(0), map.objectAt(position).orElse(null));
        Assertions.assertEquals(position, animals.get(0).getPosition());
        Assertions.assertEquals(MapDirection.NORTH, animals.get(0).getDirection());
    }

    @Test
    public void sortTest() throws Exception
    {
        map.place(new Animal(new Vector2d(2, 1)));
        map.place(new Animal(new Vector2d(3, 1)));
        map.place(new Animal(new Vector2d(1, 1)));
        var sortedAnimals = map.getOrderedAnimals();
        testArraySorted(sortedAnimals);
    }

    @Test
    public void testAlreadySorted() throws Exception
    {
        map.place(new Animal(new Vector2d(1, 1)));
        map.place(new Animal(new Vector2d(2, 1)));
        map.place(new Animal(new Vector2d(3, 1)));
        var sortedAnimals = map.getOrderedAnimals();
        testArraySorted(sortedAnimals);
    }

    @Test
    public void testReverseOrder() throws Exception
    {
        map.place(new Animal(new Vector2d(3, 1)));
        map.place(new Animal(new Vector2d(2, 1)));
        map.place(new Animal(new Vector2d(1, 1)));
        var sortedAnimals = map.getOrderedAnimals();
        testArraySorted(sortedAnimals);
    }

    @Test
    public void testSortXSame() throws Exception
    {
        map.place(new Animal(new Vector2d(1, 2)));
        map.place(new Animal(new Vector2d(1, 3)));
        map.place(new Animal(new Vector2d(1, 1)));
        var sortedAnimals = map.getOrderedAnimals();
        testArraySorted(sortedAnimals);
    }

    private void testArraySorted(List<WorldElement> sortedAnimals)
    {
        for(int i = 1; i < sortedAnimals.size(); i++)
        {
            var prevAnimal = sortedAnimals.get(i - 1).getPosition();
            var nextAnimal = sortedAnimals.get(i).getPosition();
            Assertions.assertFalse(prevAnimal.x() > nextAnimal.x());
            if (prevAnimal.x() == nextAnimal.x())
                Assertions.assertFalse(prevAnimal.y() > nextAnimal.y());
        }
    }

    private void checkAnimalMapCohesion(Animal animal) {
        Assertions.assertEquals(animal, map.objectAt(animal.getPosition()).orElse(null));
    }
}

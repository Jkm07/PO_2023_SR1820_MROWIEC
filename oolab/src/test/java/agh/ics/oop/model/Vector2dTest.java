package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Vector2dTest {

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 3", "3, 2", "0, 0"})
    public void equalsTrue(int x, int y) {
        Vector2d first = new Vector2d(x, y);
        Vector2d second = new Vector2d(x, y);
        Assertions.assertTrue(first.equals(first));
        Assertions.assertTrue(first.equals(second));
        Assertions.assertTrue(second.equals(first));
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1, 2", "1, 1, 2, 1", "2, 3, 3, 2", "4, -4, 4, 4"})
    public void equalsFalse(int x1, int y1, int x2, int y2) {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);
        Assertions.assertFalse(first.equals(second));
        Assertions.assertFalse(second.equals(first));
    }

    @Test
    public void equalsCasting()
    {
        Vector2d vector = new Vector2d(1, 2);
        Object object = new Object();
        Assertions.assertFalse(vector.equals(object));
        Assertions.assertFalse(object.equals(vector));
    }

    @Test
    public void equalsNULL()
    {
        Vector2d vector = new Vector2d(1, 2);
        Vector2d vectorNull = null;
        Assertions.assertFalse(vector.equals(vectorNull));
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"1| 2| (1,2)", "1| 1| (1,1)", "2| 3| (2,3)", "4| -4| (4,-4)"})
    public void toStringTest(int x, int y, String expected)
    {
        Vector2d vector = new Vector2d(x, y);
        Assertions.assertEquals(expected, vector.toString());
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 1, 1", "14, 12, 0, 0", "15, 20, 10, 1"})
    public void precedesTest(int x1, int y1, int x2, int y2)
    {
        Vector2d greater = new Vector2d(x1, y1);
        Vector2d smaller = new Vector2d(x2, y2);

        Assertions.assertFalse(greater.precedes(smaller));
        Assertions.assertTrue(smaller.precedes(greater));
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 1, 2", "15, 13, 0, 20", "1, 2, 2, 1"})
    public void precedesTestDiff(int x1, int y1, int x2, int y2)
    {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Assertions.assertFalse(first.precedes(second));
        Assertions.assertFalse(second.precedes(first));
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "0, 0", "-1, -1", })
    public void precedesTestEqual(int x, int y)
    {
        Vector2d first = new Vector2d(x, y);
        Vector2d second = new Vector2d(x, y);

        Assertions.assertTrue(first.precedes(second));
        Assertions.assertTrue(second.precedes(first));
    }

    @Test
    public void precedesNULL()
    {
        Vector2d first = new Vector2d(1, 1);
        Vector2d second = null;

        Assertions.assertFalse(first.precedes(second));
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 1, 1", "14, 12, 0, 0", "15, 20, 10, 1"})
    public void followTest(int x1, int y1, int x2, int y2)
    {
        Vector2d greater = new Vector2d(x1, y1);
        Vector2d smaller = new Vector2d(x2, y2);

        Assertions.assertTrue(greater.follows(smaller));
        Assertions.assertFalse(smaller.follows(greater));
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 1, 2", "15, 13, 0, 20", "1, 2, 2, 1"})
    public void followTestDiff(int x1, int y1, int x2, int y2)
    {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Assertions.assertFalse(first.follows(second));
        Assertions.assertFalse(second.follows(first));
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "0, 0", "-1, -1", })
    public void followTestEqual(int x, int y)
    {
        Vector2d first = new Vector2d(x, y);
        Vector2d second = new Vector2d(x, y);

        Assertions.assertTrue(first.follows(second));
        Assertions.assertTrue(second.follows(first));
    }

    @Test
    public void followNULL()
    {
        Vector2d first = new Vector2d(1, 1);
        Vector2d second = null;

        Assertions.assertFalse(first.follows(second));
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2, 1", "0, 0, 1, 1", "1, 2, 2, 1", "2, 1, 1, 2"})
    public void upperRight(int x1, int y1, int x2, int y2) {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Vector2d result = first.upperRight(second);

        Assertions.assertEquals(Math.max(first.getX(), second.getX()), result.getX());
        Assertions.assertEquals(Math.max(first.getY(), second.getY()), result.getY());

        result = second.upperRight(first);

        Assertions.assertEquals(Math.max(first.getX(), second.getX()), result.getX());
        Assertions.assertEquals(Math.max(first.getY(), second.getY()), result.getY());
    }

    @Test
    public void upperRightNull()
    {
        Vector2d vector = new Vector2d(1, 1);
        Vector2d result = vector.upperRight(null);
        Assertions.assertEquals(vector.getX(), result.getX());
        Assertions.assertEquals(vector.getY(), result.getY());
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2, 1", "0, 0, 1, 1", "1, 2, 2, 1", "2, 1, 1, 2"})
    public void lowerLeft(int x1, int y1, int x2, int y2) {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Vector2d result = first.lowerLeft(second);

        Assertions.assertEquals(Math.min(first.getX(), second.getX()), result.getX());
        Assertions.assertEquals(Math.min(first.getY(), second.getY()), result.getY());

        result = second.lowerLeft(first);

        Assertions.assertEquals(Math.min(first.getX(), second.getX()), result.getX());
        Assertions.assertEquals(Math.min(first.getY(), second.getY()), result.getY());
    }

    @Test
    public void lowerLeftNull()
    {
        Vector2d vector = new Vector2d(1, 1);
        Vector2d result = vector.lowerLeft(null);
        Assertions.assertEquals(vector.getX(), result.getX());
        Assertions.assertEquals(vector.getY(), result.getY());
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2, 1", "0, 0, 1, 1", "1, 2, 2, 1", "2, 1, 1, 2", "-1, 2, 0, 0", "-1, 2, -1, -2"})
    public void add(int x1, int y1, int x2, int y2) {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Vector2d result = first.add(second);

        Assertions.assertEquals(first.getX() + second.getX(), result.getX());
        Assertions.assertEquals(first.getY() + second.getY(), result.getY());

        result = second.add(first);

        Assertions.assertEquals(second.getX() + first.getX(), result.getX());
        Assertions.assertEquals(second.getY() + first.getY(), result.getY());
    }

    @Test
    public void addNull()
    {
        Vector2d vector = new Vector2d(1, 1);
        Vector2d result = vector.add(null);
        Assertions.assertEquals(vector.getX(), result.getX());
        Assertions.assertEquals(vector.getY(), result.getY());
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2, 1", "0, 0, 1, 1", "1, 2, 2, 1", "2, 1, 1, 2", "-1, 2, 0, 0", "-1, 2, -1, -2"})
    public void subtract(int x1, int y1, int x2, int y2) {
        Vector2d first = new Vector2d(x1, y1);
        Vector2d second = new Vector2d(x2, y2);

        Vector2d result = first.subtract(second);

        Assertions.assertEquals(first.getX() - second.getX(), result.getX());
        Assertions.assertEquals(first.getY() - second.getY(), result.getY());

        result = second.subtract(first);

        Assertions.assertEquals(second.getX() - first.getX(), result.getX());
        Assertions.assertEquals(second.getY() - first.getY(), result.getY());
    }

    @Test
    public void subtractNull()
    {
        Vector2d vector = new Vector2d(1, 1);
        Vector2d result = vector.subtract(null);
        Assertions.assertEquals(vector.getX(), result.getX());
        Assertions.assertEquals(vector.getY(), result.getY());
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "0, 0", "-1, -1", "1, 2", "-3, 1", "1, -3" })
    public void opposite(int x, int y)
    {
        Vector2d vector = new Vector2d(x, y);
        Vector2d result = vector.opposite();

        Assertions.assertEquals(-vector.getX(), result.getX());
        Assertions.assertEquals(-vector.getY(), result.getY());
    }
}

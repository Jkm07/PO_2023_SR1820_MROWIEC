package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {

    @Test
    public void testForward()
    {
        String[] arg = new String[] {"f"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testBackward()
    {
        String[] arg = new String[] {"b"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testLeft()
    {
        String[] arg = new String[] {"l"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.LEFT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRight()
    {
        String[] arg = new String[] {"r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testEmpty()
    {
        String[] arg = new String[0];
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[0];
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testNotAppropriateArgument()
    {
        String[] arg = new String[]{"h"};
        Assertions.assertThrows(IllegalArgumentException.class,  () -> OptionParser.convert(arg).toArray());
    }

    @Test
    public void testCase1()
    {
        String[] arg = new String[]{"f", "b", "l", "r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testCase2()
    {
        String[] arg = new String[]{"h", "f", "s", "b", "c", "l", "r"};
        Assertions.assertThrows(IllegalArgumentException.class,  () -> OptionParser.convert(arg).toArray());

    }

    @Test
    public void testCase3()
    {
        String[] arg = new String[]{"f", "f", "l", "b", "r", "l", "r"};
        var result = OptionParser.convert(arg).toArray();

        MoveDirection[] expected = new MoveDirection[] {
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testCase4()
    {
        String[] arg = new String[]{"ff", "sf", "lp", "13", "k", "left", "right"};
        Assertions.assertThrows(IllegalArgumentException.class,  () -> OptionParser.convert(arg).toArray());
    }
}

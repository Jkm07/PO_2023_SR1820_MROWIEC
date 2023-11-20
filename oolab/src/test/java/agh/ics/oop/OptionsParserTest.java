package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {

    @Test
    public void testForward()
    {
        String[] arg = new String[] {"f"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testBackward()
    {
        String[] arg = new String[] {"b"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testLeft()
    {
        String[] arg = new String[] {"l"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.LEFT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testRight()
    {
        String[] arg = new String[] {"r"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testEmpty()
    {
        String[] arg = new String[0];
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[0];
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testNotAppropriateArgument()
    {
        String[] arg = new String[]{"h"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[0];
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testCase1()
    {
        String[] arg = new String[]{"f", "b", "l", "r"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testCase2()
    {
        String[] arg = new String[]{"h", "f", "s", "b", "c", "l", "r"};
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testCase3()
    {
        String[] arg = new String[]{"f", "f", "l", "b", "r", "l", "r"};
        MoveDirection[] result = OptionParser.convert(arg);

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
        MoveDirection[] result = OptionParser.convert(arg);

        MoveDirection[] expected = new MoveDirection[0];
        Assertions.assertArrayEquals(expected, result);
    }
}

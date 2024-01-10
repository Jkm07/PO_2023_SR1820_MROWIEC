package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OptionParser {
    public static List<MoveDirection> convert(String[] args)
    {
        return Arrays.stream(args).map(OptionParser::convertArgument).toList();
    }

    private static MoveDirection convertArgument(String arg)
    {
        return switch (arg) {
            case "f" -> MoveDirection.FORWARD;
            case "b" -> MoveDirection.BACKWARD;
            case "l" -> MoveDirection.LEFT;
            case "r" -> MoveDirection.RIGHT;
            default -> throw new IllegalArgumentException(arg + " is not legal move specification");
        };
    }
}

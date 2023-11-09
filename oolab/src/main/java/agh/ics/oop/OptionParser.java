package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;

public class OptionParser {
    public static MoveDirection[] convert(String[] args)
    {
        var list = new ArrayList<MoveDirection>();

        for(var arg : args)
        {
            var move = convertArgument(arg);
            if(move != null)
                list.add(move);
        }

        var out = new MoveDirection[list.size()];
        list.toArray(out);
        return out;
    }

    private static MoveDirection convertArgument(String arg)
    {
        return switch (arg) {
            case "f" -> MoveDirection.FORWARD;
            case "b" -> MoveDirection.BACKWARD;
            case "l" -> MoveDirection.LEFT;
            case "r" -> MoveDirection.RIGHT;
            default -> null;
        };
    }
}

package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("Test map direction");
        //Test printa
        System.out.println("Test printa");
        System.out.println(MapDirection.NORTH);
        System.out.println(MapDirection.EAST);
        System.out.println(MapDirection.SOUTH);
        System.out.println(MapDirection.WEST);
        System.out.println();
        //Test nexta
        System.out.println("Test nexta");
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.EAST.next());
        System.out.println(MapDirection.SOUTH.next());
        System.out.println(MapDirection.WEST.next());
        System.out.println();
        //Test previous
        System.out.println("Test previous");
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.EAST.previous());
        System.out.println(MapDirection.SOUTH.previous());
        System.out.println(MapDirection.WEST.previous());
        System.out.println();
        //Test Vector2d
        System.out.println("To Vector2d");
        System.out.println(MapDirection.NORTH.toUnitVector());
        System.out.println(MapDirection.EAST.toUnitVector());
        System.out.println(MapDirection.SOUTH.toUnitVector());
        System.out.println(MapDirection.WEST.toUnitVector());
        System.out.println();
        /*System.out.println("system wystartował");
        var moves = OptionParser.convert(args);
        run(moves);
        System.out.println("system zakończył działanie");*/
    }

    private static void run(MoveDirection[] moves) {
        System.out.println("Start");
        for (var move: moves) {
            move.printDirection();
        }
        System.out.println("Koniec");
    }
}
package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartował");
        var moves = OptionParser.convert(args);
        run(moves);
        System.out.println("system zakończył działanie");
    }

    private static void run(MoveDirection[] moves) {
        System.out.println("Start");
        for (var move: moves) {
            move.printDirection();
        }
        System.out.println("Koniec");
    }
}
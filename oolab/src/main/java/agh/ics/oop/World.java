package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {

    public static void main(String[] args) {
        try {
            //Arguments prepare
            List<MoveDirection> directions = OptionParser.convert(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(2,2));

            //Map prepare
            var map = new GrassField(10);
            var mapDisplay = new ConsoleMapDisplay();
            map.addListener(mapDisplay);

            //Start simulation
            var simulation = new Simulation(map, positions, directions);
            simulation.run();
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

    }
}
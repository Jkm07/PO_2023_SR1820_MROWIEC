package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {

    public static void main(String[] args) {
        try {
            List<MoveDirection> directions = OptionParser.convert(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(2,2));
            WorldMap map = new GrassField(10);
            Simulation simulation = new Simulation(map, positions, directions);
            simulation.run();
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

    }
}
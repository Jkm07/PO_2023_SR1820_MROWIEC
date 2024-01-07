package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {

        /*List<MoveDirection> directions = OptionParser.convert(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        RectangularMap map = new RectangularMap(4, 4);
        Simulation simulation = new Simulation(map, positions, directions);
        simulation.run();*/

        List<MoveDirection> directions = OptionParser.convert(args);
        List<String> strings = List.of("Ala", "ma", "kota");
        WorldMap map = new TextMap();
        SimulationTextMap simulation = new SimulationTextMap(map, strings, directions);
        simulation.run();
    }
}
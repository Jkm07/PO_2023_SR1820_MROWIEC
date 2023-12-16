package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class World {

    public static void main(String[] args) {
        try {
            //Arguments prepare
            List<MoveDirection> directions = OptionParser.convert(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(2,2));
            var mapDisplay = new ConsoleMapDisplay();

            //Start simulation
            var simulationEngine = new SimulationEngine(getSimulationList(mapDisplay, 1000, directions, positions));
            simulationEngine.runAsyncInThreadPool();
            simulationEngine.awaitSimulationEnd();
            System.out.println("Simulation end");
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    private static List<Simulation> getSimulationList(ConsoleMapDisplay consoleMapDisplay, int size, List<MoveDirection> directions, List<Vector2d> positions)
    {
        List<Simulation> out = new LinkedList<>();
        for(int i = 0; i < size; i++)
        {
            AbstractWorldMap map;
            if (i % 2 == 0) {
                map = new GrassField(UUID.randomUUID(), 10);

            }
            else {
                map = new RectangularMap(UUID.randomUUID(), 4, 4);
            }
            map.addListener(consoleMapDisplay);
            var sim = new Simulation(map, positions, directions);
            sim.prepareGame();
            out.add(sim);
        }
        return out;
    }
}
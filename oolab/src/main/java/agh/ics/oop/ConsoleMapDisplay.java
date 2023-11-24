package agh.ics.oop;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {
    int updateCounter = 0;
    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Update nr " + ++updateCounter);
        System.out.println("Map id " + worldMap.getId());
        System.out.println(message);
        System.out.println(worldMap);
    }
}

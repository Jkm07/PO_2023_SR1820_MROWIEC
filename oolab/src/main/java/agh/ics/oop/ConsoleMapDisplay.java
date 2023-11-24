package agh.ics.oop;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {
    int updateCounter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Update nr " + ++updateCounter);
        System.out.println(message);
        System.out.println(worldMap);
    }
}

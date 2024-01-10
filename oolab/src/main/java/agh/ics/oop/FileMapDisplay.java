package agh.ics.oop;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileMapDisplay implements MapChangeListener {
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Path filePath = Path.of(worldMap.getId() + ".log");
        try (var writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(message);
            writer.newLine();
            writer.write(worldMap.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while appending to the file: " + e.getMessage());
        }
    }
}

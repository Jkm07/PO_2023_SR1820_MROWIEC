package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal, Vector2d>{
    private final Map<Vector2d, Animal> _animals;
    private final MapVisualizer _visualizer;
    private final int _width;
    private final int _height;

    public RectangularMap(int width, int height)
    {
        _width = width;
        _height = height;
        _visualizer = new MapVisualizer(this);
        _animals = new HashMap<>();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isInsideTheBoard(position))
            return false;
        return !_animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) {
        var position = animal.getPosition();
        if(!canMoveTo(position))
            return false;
        _animals.values().remove(animal);
        _animals.put(position, animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animal.move(direction, this);
        place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(!isInsideTheBoard(position))
            return false;
        return _animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return _animals.get(position);
    }

    @Override
    public String toString() {
        return _visualizer.draw(new Vector2d(0, 0), new Vector2d(_width, _height));
    }

    private boolean isInsideTheBoard(Vector2d position) {
        if(position.x() < 0 || position.y() < 0)
            return false;
        if(position.x() > _width || position.y() > _height)
            return false;
        return true;
    }
}

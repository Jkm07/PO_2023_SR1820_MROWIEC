package agh.ics.oop.model;

import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap<WorldElement, Vector2d> {

    protected final Map<Vector2d, WorldElement> _elements;
    private final MapVisualizer _visualizer;
    protected Vector2d _maxVector;
    protected Vector2d _minVector;

    public AbstractWorldMap(Vector2d minVector, Vector2d maxVector)
    {
        _maxVector = maxVector;
        _minVector = minVector;
        _visualizer = new MapVisualizer(this);
        _elements = new HashMap<>();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !_elements.containsKey(position);
    }

    @Override
    public void place(WorldElement element) throws PositionAlreadyOccupiedException{
        var position = element.getPosition();
        if(!canMoveTo(position))
            throw new PositionAlreadyOccupiedException(position);
        _elements.values().remove(element);
        _elements.put(position, element);
    }

    @Override
    public void move(WorldElement animal, MoveDirection direction) {
        var oldPosition = animal.getPosition();
        if (objectAt(oldPosition) != animal) return;
        animal.move(direction, this);
        var newPosition = animal.getPosition();
        if (!canMoveTo(newPosition)) return;
        _elements.remove(oldPosition);
        _elements.put(newPosition, animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return _elements.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return _elements.get(position);
    }

    @Override
    public String toString() {
        return _visualizer.draw(_minVector, _maxVector);
    }

    public Collection<WorldElement> getElements() {
        return _elements.values();
    }
}

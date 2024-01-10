package agh.ics.oop.model;

import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap<WorldElement, Vector2d> {

    protected final Map<Vector2d, WorldElement> _elements;
    private final MapVisualizer _visualizer;
    private final HashSet<MapChangeListener> _listeners;
    private final UUID _id;

    public AbstractWorldMap(UUID id)
    {
        _visualizer = new MapVisualizer(this);
        _elements = new HashMap<>();
        _listeners = new HashSet<>();
        _id = id;
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
        mapChanged("Animal was placed on " + position + " field");
    }

    @Override
    public void move(WorldElement animal, MoveDirection direction) {
        var oldPosition = animal.getPosition();
        if (objectAt(oldPosition).orElse(null) != animal) return;
        animal.move(direction, this);
        var newPosition = animal.getPosition();
        if (oldPosition == newPosition) {
            changeDirectionNotify(animal, direction);
            return;
        }
        _elements.remove(oldPosition);
        _elements.put(newPosition, animal);
        mapChanged("Animal moved from " + oldPosition + " to " + newPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return _elements.containsKey(position);
    }

    @Override
    public Optional<WorldElement> objectAt(Vector2d position) {

        return Optional.ofNullable(_elements.get(position));
    }

    @Override
    public UUID getId() {
        return _id;
    }

    @Override
    public String toString() {
        var boundary = getCurrentBounds();
        return _visualizer.draw(boundary.bottomLeft(), boundary.topRight());
    }

    public Collection<WorldElement> getElements() {
        return _elements.values();
    }

    public boolean addListener(MapChangeListener l) {
        return _listeners.add(l);
    }

    public boolean removeListener(MapChangeListener l) {
        return _listeners.remove(l);
    }

    private void changeDirectionNotify(WorldElement element, MoveDirection direction) {
        switch (direction) {
            case FORWARD:
            case BACKWARD:
                mapChanged("Animal stays in plays after move in " + direction + " direction");
                break;
            case LEFT:
            case RIGHT:
                if (element instanceof Animal) {
                    var mapDirection = ((Animal)element).getDirection();
                    mapChanged("Animal looks on the " + mapDirection);
                }
                else {
                    mapChanged("Element turn on " + direction);
                }
                break;
        }
    }

    private void mapChanged(String message) {
        for(var l : _listeners) {
            l.mapChanged(this, message);
        }
    }

    @Override
    public List<WorldElement> getOrderedAnimals()
    {
        return _elements.keySet().stream()
                .sorted(Comparator.comparing(Vector2d::x).thenComparing(Vector2d::y))
                .map(_elements::get).toList();
    }
}

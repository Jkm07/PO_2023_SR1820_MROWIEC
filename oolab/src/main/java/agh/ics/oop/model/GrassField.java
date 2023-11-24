package agh.ics.oop.model;

import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d, Grass> _grassElements;

    public GrassField(int quantityOfGrassFields) {
        super(null, null);
        _grassElements = new HashMap<>();
        generateGrass(quantityOfGrassFields);
    }

    @Override
    public void place(WorldElement element) throws PositionAlreadyOccupiedException{
        super.place(element);
        updateSizeOfMap(element.getPosition());
    }

    @Override
    public void move(WorldElement animal, MoveDirection direction) {
        super.move(animal, direction);
        var position = animal.getPosition();
        if (objectAt(position) == animal) updateSizeOfMap(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || _grassElements.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        var element = super.objectAt(position);
        if (element != null)
            return element;
        else
            return _grassElements.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        return Stream.concat(super.getElements().stream(), _grassElements.values().stream()).toList();
    }

    private void generateGrass(int quantityInGrass) {
        int range = (int) Math.sqrt(10 * quantityInGrass);
        while (quantityInGrass-- != 0) {
            while (true) {
                int x = (int) (Math.random() * range);
                int y = (int) (Math.random() * range);
                var nwVector = new Vector2d(x, y);
                if(!_grassElements.containsKey(nwVector)) {
                    _grassElements.put(nwVector, new Grass(nwVector));
                    updateSizeOfMap(nwVector);
                    break;
                }
            }
        }
    }

    private void updateSizeOfMap(Vector2d vector) {

        _maxVector = _maxVector != null ? _maxVector.upperRight(vector) : vector;
        _minVector = _minVector != null ? _minVector.lowerLeft(vector) : vector;
    }
}
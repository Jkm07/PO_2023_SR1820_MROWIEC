package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TextMap implements WorldMap<String, Integer>{

    private final List<String> _elements;

    public TextMap() {
        _elements = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position)  {
        throw new RuntimeException("Nie mam pojecia czy miałem robić generyczny move validator więc zostawiłem to tak");
    }

    @Override
    public void place(String element) {
        _elements.add(element);
    }

    @Override
    public void move(String animal, MoveDirection direction) {
        var position = _elements.indexOf(animal);
        switch (direction) {
            case FORWARD -> {
                if (position + 1 != _elements.size()) swapNeighbour(position, position + 1);
            }
            case BACKWARD -> {
                if (position != 0) swapNeighbour(position, position - 1);
            }
        }
    }

    @Override
    public String toString() {
        return _elements.toString();
    }

    @Override
    public boolean isOccupied(Integer position) {
        return positionBelongToList(position);
    }

    @Override
    public Optional<String> objectAt(Integer position) {
        return positionBelongToList(position) ? Optional.of(_elements.get(position)) : Optional.empty();
    }

    @Override
    public Boundary<Integer> getCurrentBounds() {
        return null;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public List<String> getOrderedAnimals() {
        return _elements.stream().sorted().toList();
    }

    private boolean positionBelongToList(Integer position) {
        return 0 <= position && position < _elements.size();
    }

    private void swapNeighbour(Integer position1, Integer position2) {
        var el = _elements.get(position1);
        _elements.set(position1, _elements.get(position2));
        _elements.set(position2, el);
    }
}

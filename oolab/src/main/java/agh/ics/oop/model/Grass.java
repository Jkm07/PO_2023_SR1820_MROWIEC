package agh.ics.oop.model;

public class Grass implements WorldElement{

    private final Vector2d _position;
    public Grass(Vector2d position) {
        _position = position;
    }
    @Override
    public Vector2d getPosition() {
        return _position;
    }
    @Override
    public boolean isAt(Vector2d position) {
        return _position == position;
    }
    @Override
    public String toString() {
        return "*";
    }
}

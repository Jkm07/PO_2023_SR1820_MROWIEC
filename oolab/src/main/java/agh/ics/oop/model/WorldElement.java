package agh.ics.oop.model;

public interface WorldElement {
    Vector2d getPosition();
    boolean isAt(Vector2d position);
    default void move(MoveDirection direction, MoveValidator validator) {};
    String getImagePath();
    String getLabel();
}

package agh.ics.oop.model.exception;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d vector2d) {
        super("Position " + vector2d + " is already occupied.");
    }
}

package agh.ics.oop.model;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;
    public void printDirection()
    {
        switch (this) {
            case FORWARD -> System.out.println("Zwierzak idzie do przodu");
            case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
            case LEFT -> System.out.println("Zwierzak idzie w lewo");
            case RIGHT -> System.out.println("Zwierzak idzie w prawo");
        }
    }
}

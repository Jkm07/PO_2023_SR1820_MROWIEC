package agh.ics.oop.model;

public class Animal {
    private static final int BORDER_TOP = 4;
    private static final int BORDER_BOTTOM = 0;
    private static final int BORDER_LEFT = 0;
    private static final int BORDER_RIGHT = 4;
    private Vector2d _position;
    private MapDirection _direction = MapDirection.NORTH;

    public Animal(Vector2d position)
    {
        _position = position;
        _validMapBorders();
    }

    public Animal()
    {
        this(new Vector2d(2, 2));
    }

    @Override
    public String toString() {
        return  "position=" + _position +
                ", direction=" + _direction;
    }

    public boolean isAt(Vector2d position)
    {
        return _position == position;
    }

    public void move(MoveDirection direction)
    {
        switch (direction) {
            case LEFT-> _direction = _direction.previous();
            case RIGHT-> _direction = _direction.next();
            case FORWARD -> _position = _position.add(_direction.toUnitVector());
            case BACKWARD -> _position = _position.subtract(_direction.toUnitVector());
        }
        _validMapBorders();
    }

    public MapDirection getDirection() {
        return _direction;
    }

    public Vector2d getPosition() {
        return _position;
    }

    private void _validMapBorders()
    {
        int x = _position.x();
        int y = _position.y();

        x = Math.min(x, BORDER_RIGHT);
        x = Math.max(x, BORDER_LEFT);
        y = Math.min(y, BORDER_TOP);
        y = Math.max(y, BORDER_BOTTOM);

        _position = new Vector2d(x, y);
    }
}

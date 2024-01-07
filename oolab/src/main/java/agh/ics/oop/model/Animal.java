package agh.ics.oop.model;

public class Animal {
    private Vector2d _position;
    private MapDirection _direction = MapDirection.NORTH;

    public Animal(Vector2d position)
    {
        _position = position;
    }

    public Animal()
    {
        this(new Vector2d(2, 2));
    }

    @Override
    public String toString() {
        return  switch (_direction) {
            case NORTH -> "↑";
            case SOUTH -> "↓";
            case WEST -> "←";
            case EAST -> "→";
        };
    }

    public boolean isAt(Vector2d position)
    {
        return _position == position;
    }

    public void move(MoveDirection direction, MoveValidator validator)
    {
        switch (direction) {
            case LEFT-> _direction = _direction.previous();
            case RIGHT-> _direction = _direction.next();
            case FORWARD -> {
                var new_pos = _position.add(_direction.toUnitVector());
                if(validator.canMoveTo(new_pos))
                    _position = new_pos;
            }
            case BACKWARD -> {
                var new_pos = _position.subtract(_direction.toUnitVector());
                if(validator.canMoveTo(new_pos))
                    _position = new_pos;
            }
        }
    }

    public MapDirection getDirection() {
        return _direction;
    }

    public Vector2d getPosition() {
        return _position;
    }
}

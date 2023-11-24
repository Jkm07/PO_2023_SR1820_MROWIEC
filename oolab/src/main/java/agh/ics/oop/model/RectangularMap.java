package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {

    private final Boundary<Vector2d> _boundary;
    public RectangularMap(int width, int height)
    {
        _boundary = new Boundary<>(new Vector2d(0, 0), new Vector2d(width, height));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isInsideTheBoard(position))
            return false;
        return super.canMoveTo(position);
    }

    @Override
    public Boundary<Vector2d> getCurrentBounds() {
        return _boundary;
    }

    private boolean isInsideTheBoard(Vector2d position) {
        return _boundary.bottomLeft().precedes(position) && _boundary.topRight().follows(position);
    }
}

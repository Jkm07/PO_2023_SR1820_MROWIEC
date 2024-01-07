package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height)
    {
        super(new Vector2d(0, 0), new Vector2d(width, height));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isInsideTheBoard(position))
            return false;
        return super.canMoveTo(position);
    }
    private boolean isInsideTheBoard(Vector2d position) {
        return _minVector.precedes(position) && _maxVector.follows(position);
    }
}

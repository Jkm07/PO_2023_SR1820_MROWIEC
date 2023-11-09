package agh.ics.oop.model;

public record Vector2d(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        if (other == null) return false;
        return x <= other.x && y <= other.y;
    }

    public boolean follows(Vector2d other) {
        if (other == null) return false;
        return x >= other.x && y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        if (other == null)
            return new Vector2d(this.x, this.y);
        int x = this.x + other.x;
        int y = this.y + other.y;
        return new Vector2d(x, y);
    }

    public Vector2d subtract(Vector2d other) {
        if (other == null)
            return new Vector2d(this.x, this.y);
        int x = this.x - other.x;
        int y = this.y - other.y;
        return new Vector2d(x, y);
    }

    public Vector2d upperRight(Vector2d other) {
        if (other == null)
            return new Vector2d(this.x, this.y);
        int x = Math.max(this.x, other.x);
        int y = Math.max(this.y, other.y);
        return new Vector2d(x, y);
    }

    public Vector2d lowerLeft(Vector2d other) {
        if (other == null)
            return new Vector2d(this.x, this.y);
        int x = Math.min(this.x, other.x);
        int y = Math.min(this.y, other.y);
        return new Vector2d(x, y);
    }

    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }

}

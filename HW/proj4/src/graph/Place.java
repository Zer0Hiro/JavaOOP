package graph;

import java.util.Objects;

public class Place {
    private int x, y;

    public Place(int x, int y, int bound) {
        if (x < 0 || x > (bound - 1) || y < 0 || y > (bound - 1))
            throw new IllegalArgumentException("Coordinates out of bounds\n");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Place))
            return false;

        Place temp = (Place) obj;
        return (this.x == temp.getX() && this.y == temp.getY());

    }

    // Override hashCode for use in HashSet and HashMap
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Place (" + x + ", " + y + ")";
    }

}

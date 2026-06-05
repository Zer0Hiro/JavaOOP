package graph;

public class Place {
    private int x, y, bound;

    public Place(int x, int y, int bound) {
        if (x >= (bound - 1) || y >= (bound - 1))
            throw new IllegalArgumentException();
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
        return (this.x == temp.getX() && this.y == temp.getX());

    }

    @Override
    public int hashCode() {

        // WHAT DA FUK
    }

}

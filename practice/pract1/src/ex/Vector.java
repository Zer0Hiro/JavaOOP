package ex;

public class Vector {
    private int x, y;

    public Vector(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public void doubling(Vector other)
    {
        x = other.x *2;
        y = other.y*2;
    }
}

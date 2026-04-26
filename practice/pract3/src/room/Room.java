package room;

public class Room {
    private int length, width;
    protected int costPerMeter;

    public Room(int length, int width, int costPerMeter) {
        this.length = length;
        this.width = width;
        this.costPerMeter = costPerMeter;
    }

    public int area() {
        return length * width;
    }

    public int cost() {
        return area() * costPerMeter;
    }

    
    protected int perimeter() {
        return length*2 + width*2;
    }


    @Override
    public String toString() {
        return String.format("%s %d X %d, cost = %d",
                getClass().getSimpleName(), length, width, cost());
    }

}

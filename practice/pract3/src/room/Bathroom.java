package room;

public class Bathroom extends Room {
    private int height;

    public Bathroom(int length, int width, int height, int costPerMeter) {
        super(length, width, costPerMeter);
        this.height = height;
    }

    @Override
    public int cost() {
        return super.cost()*height;
    }
}

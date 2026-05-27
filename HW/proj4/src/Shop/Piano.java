package Shop;

public class Piano extends Instrument {
    private int octaves;

    public Piano(String company, int price, int octaves) {
        super(company, price);
        this.octaves = octaves;
    }

    public int getOctaves() {
        return octaves;
    }

    @Override
    public String toString() {
        return "Piano(" + octaves + " octaves) " + company + "(" + serial + "), price = " + price;
    }

    public static void main(String[] args) {
        Piano p1 = new Piano("Yamaha", 1000, 7);
        Piano p2 = new Piano("Donbass", 3000, 5);
        System.err.println(p1);
        System.err.println(p2);
    }
}

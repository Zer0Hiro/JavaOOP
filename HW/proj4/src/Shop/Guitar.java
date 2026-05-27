package Shop;

public class Guitar extends Instrument {
    private Type type;

    public Guitar(String company, int price, Type type) {
        super(company, price);
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Guitar(" + type + ") " + company + "(" + serial + "), price = " + price;
    }

    public static void main(String[] args) {
        Guitar guitar = new Guitar("Fender", 3000, Type.ACOUSTIC);
        System.err.println(guitar);
    }
}

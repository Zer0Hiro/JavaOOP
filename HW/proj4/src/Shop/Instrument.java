package Shop;

public abstract class Instrument {
    protected String company;
    protected int price;
    protected int serial;

    // Create counter for serial Numbers
    private static int serialCounter = 0;

    public Instrument(String company, int price) {
        this.company = company;
        this.price = price;
        this.serial = serialCounter;
        serialCounter++;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getSerial() {
        return serial;
    }

    public Type getType() {
        return null;
    }

}

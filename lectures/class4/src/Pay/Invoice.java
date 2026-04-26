package Pay;

public class Invoice implements Payable {
    private String name;
    private int qty;
    private int price;

    public Invoice(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public int amount() {
        return qty * price;
    }

    public String toString() {
        return "Invoice [name=" + name + ", qty=" + qty + ", price=" + price + "]";
    }
}

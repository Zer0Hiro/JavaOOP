package bank;

public class Account {
    private String name;
    private int amount;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getShekels() {
        return amount;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return name + " has " + amount + " shekels";
    }
    
}

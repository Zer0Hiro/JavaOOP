package bank;

public class ProAccount extends Account {
    private int[] history = new int[100];
    private int historySize = 0;

    public ProAccount(String name) {
        super(name);
    }

    // Creates history of all money movements
    @Override
    public void add(int amount) {
        super.add(amount);
        history[historySize++] = getShekels();
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < historySize; i++) {
            result += "" + history[i];
            if (historySize - i > 1)
                result += ",";
        }
        result += ']';
        return getName() + " has " + getShekels() + " shekels " + result;
    }

    public static void transfer(ProAccount from, ProAccount to, int amount) {
        // Remove amount
        from.add(-1 * amount);

        // Add to other user
        to.add(amount);
    }
}

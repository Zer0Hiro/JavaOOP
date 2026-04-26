package Pay;

/*
Example of how it can work with differenct classes
*/

public class Expenses {
    private int total = 0;
    private Payable mostExp = null;

    public void AddExp(Payable p) {
        total += p.amount();
        if (mostExp == null || p.amount() > mostExp.amount())
            mostExp = p;
    }

    public int getTotal() {
        return total;
    }

    public Payable mostExpensive() {
        return mostExp;
    }
}

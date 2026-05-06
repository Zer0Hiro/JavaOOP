package Forest;

public abstract class Tree {
    private int buyingCost;

    public Tree(int buyingCost) {
        this.buyingCost = buyingCost;
    }

    public abstract String getName();

    protected abstract int costAtYear(int year);

    public int totalCost(int years){
        int total = buyingCost;
        for(int i = 0; i < years; i++)
        {
            total += costAtYear(i);
        }
        return total;
    }
}

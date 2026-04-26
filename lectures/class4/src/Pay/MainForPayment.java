package Pay;

public class MainForPayment {
    public static void PayMe(Payable p) {
        System.out.println(p + " amount: " + p.amount());
    }

    public static void main(String[] args) {
        Expenses e = new Expenses();
        e.AddExp(new Invoice("Nike", 2, 350));
        e.AddExp(new Employee("Dima", 15000));

        System.out.println("Total is " + e.getTotal());
        System.out.println("Most Expensive: " + e.mostExpensive());
    }
}

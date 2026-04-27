package bank;

public class MainForAccount {
    public static void main(String[] args) {
        Account a1 = new Account("Bamba");
        System.out.println(a1);
        a1.add(150);
        System.out.println(a1);
        a1.add(-200);
        System.out.println(a1);
        ProAccount p1 = new ProAccount("Chill Guy");
        p1.add(150);
        p1.add(100);
        p1.add(-50);
        System.out.println(p1);
    }
}

package FuncPointer;

public class MainCounter {
    public static void main(String[] args) {
        String[] a = { "The", "Hello", "Bb", "A", "Zzz", "Coala" };
        ShortPred p = new ShortPred();
        System.out.println("Amount of items with filter(" + p + ") is: " + Counter.count(a, p));
    }
}

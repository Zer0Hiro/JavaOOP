package iterator;

// test Iterator
public class MainForIterator {
    public static void main(String[] args) {

        // MyArray test
        int[] x = { 2, 4, 6, 3, 6, 1, 2, 8, 8 };
        MyIterator it = new MyArray(x);
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println("\n----------------------------");

        // Fibonacci test
        MyIterator fib = new Fibonacci(15);
        while (fib.hasNext())
            System.out.print(fib.next() + " ");
        System.out.println("\n----------------------------");

        // Iterator test
        System.out.println(IteratorToString.toString(new Fibonacci(10)));
        System.out.println("----------------------------");

    }
}

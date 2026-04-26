package FuncPointer;

public class ShortPred implements Predicate {

    @Override
    public boolean f(String x) {
        return x.length() <= 3;
    }

    @Override
    public String toString() {
        return "ShortPredicate";
    }
}

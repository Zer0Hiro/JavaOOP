package iterator;

public class Fibonacci implements MyIterator {
    private int upperBound;
    private int[] temp = new int[2];

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        // first 2 numbers of fibonacci
        this.temp[0] = 0;
        this.temp[1] = 1;
    }

    @Override
    public boolean hasNext() {
        return temp[1] <= upperBound;
    }

    @Override
    public int next() {
        if (!hasNext())
            return temp[0];

        int valReturn = temp[1];
        int nextNum = temp[0] + temp[1];

        // Update new last 2 numbers
        temp[0] = temp[1];
        temp[1] = nextNum;

        return valReturn;
    }
}

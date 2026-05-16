package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
    private int[] arr;
    private int pos;

    public MyArray(int[] arr) {
        this.arr = arr;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < arr.length;
    }

    @Override
    public int next() {
        // Check if there is still elements in arr
        if (!hasNext()) {
            throw new NoSuchElementException("No more numbers in array");
        }
        return arr[pos++];
    }

}

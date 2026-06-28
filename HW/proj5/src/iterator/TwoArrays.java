package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
    private int[] a1, a2;

    public TwoArrays(int[] a1, int[] a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    private class Iterator1 implements Iterator<Integer> {
        private boolean even = false;
        private int index = 0;
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < (a1.length + a2.length);
        }

        @Override
        public Integer next() {
            int value = 0;

            if (!even) {
                if (index < a1.length) {
                    value = a1[index];
                } else if (index + 1 < a2.length) {
                    value = a2[index + 1];
                }
                even = true;

            } else {
                if (index < a2.length) {
                    value = a2[index];
                } else if (index + 1 < a1.length) {
                    value = a1[index + 1];
                }
                even = false;
            }

            counter++;
            if (counter % 2 == 0) {
                index++;
            }

            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator1();
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3, 4 };
        int[] a2 = { 100, 101, 102, 103, 104, 105, 106 };

        TwoArrays aa = new TwoArrays(a1, a2);
        for (int i : aa)
            System.out.print(i + " ");

    }
}

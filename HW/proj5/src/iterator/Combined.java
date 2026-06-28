package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Combined<E> implements Iterable<E> {
    private Iterable<E> first, second;

    @Override
    public Iterator<E> iterator() {
        return new IteratorComb();
    }

    public Combined(Iterable<E> first, Iterable<E> second) {
        this.first = first;
        this.second = second;
    }

    private class IteratorComb implements Iterator<E> {
        private int setIndex = 0;
        private int listIndex = 0;
        

        @Override
        public boolean hasNext() {
            return setIndex < first
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");
        Set<String> set = new TreeSet<>();
        set.addAll(Arrays.asList("B", "A", "D", "C", "E"));
        Combined<String> c = new Combined<>(set, list);
        for (String s : c)
            System.out.print(s + " ");

    }
}

package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Combined<E> implements Iterable<E> {
    private Iterable<E> first, second;

    public Combined(Iterable<E> first, Iterable<E> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final Iterator<E> iter1 = first.iterator();
            private final Iterator<E> iter2 = second.iterator();
            private boolean swap = false;

            @Override
            public boolean hasNext() {
                return iter1.hasNext() || iter2.hasNext();
            }

            @Override
            public E next() {
                if (iter1.hasNext() && swap == false) {
                    // Check if second list is not empty
                    if (iter2.hasNext())
                        swap = true;
                    return iter1.next();
                } else if (iter2.hasNext()) {
                    // Check if first list is not empty
                    if (iter1.hasNext())
                        swap = false;
                    return iter2.next();
                }

                // Throw exception if empty
                throw new NoSuchElementException();
            }

        };
    }
}

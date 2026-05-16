package iterator;

public interface MyIterator {
    // Checks if there is still elements
    boolean hasNext();

    // Returns value of element and moves to the next index
    int next();
}

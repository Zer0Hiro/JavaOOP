package equiv;

import java.util.ArrayList;
import java.util.List;

public class Equiv<E> {
    private List<List<E>> elements;

    public Equiv() {
        // Init arraylist
        this.elements = new ArrayList<>();
    }

    public void add(E e1, E e2) {
        // Look for list of elements
        for (List<E> exist_element : elements) {
            // if e1 exist but e2 not
            if (exist_element.contains(e1) && !exist_element.contains(e2)) {
                exist_element.add(e2);
                return;
            }
            // if e2 exists but e1 not
            if (exist_element.contains(e2) && !exist_element.contains(e1)) {
                exist_element.add(e1);
                return;
            }
        }
        // If not in any of lists, create new list
        List<E> newList = new ArrayList<>();
        // add 2 objects to the same list
        newList.add(e1);
        newList.add(e2);
        elements.add(newList);
    }

    public boolean are(E e1, E e2) {

        // If equal
        if (e1.equals(e2))
            return true;

        // Check if e1,e2 at the same list
        for (List<E> elem : elements) {
            if (elem.contains(e1) && elem.contains(e2))
                return true;
        }
        return false;
    }
}

package Equiv;

import java.util.ArrayList;
import java.util.List;

public class Equiv<E> {
    private List<List<E>> elements;
    private static int index = 0;

    public Equiv(List<E> elements) {
        // Init arraylist
        this.elements = new ArrayList<>();
    }

    public void add(E e1, E e2) {
        // Look for list of elements
        for (List<E> exits_element : elements) {
            // Look for object inside List
            for (E e : exits_element) {
                // Add element to the same list
                if (e.toString() == e1.toString()) {
                    exits_element.add(e2);
                    return;
                }
                if (e.toString() == e2.toString()) {
                    exits_element.add(e1);
                    return;
                }
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
        boolean flag = false;
        boolean found = false;

        // If equal
        if (e1.equals(e2))
            return true;

        for (List<E> elem : elements) {
            // get index of e1
            for (E obj : elem) {
                if (e1.toString() == obj.toString()) {
                    // Found index
                    found = true;
                    break;
                }
            }

            // if found look fot the e2 in the same list
            if (found) {
                for (E obj : elem) {
                    if (e2.toString() == obj.toString()) {
                        // Found e2 in the same list
                        flag = true;
                        break;
                    }
                }
                break;
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        Equiv<String> equiv = new Equiv<>();
        equiv.add("ball", "balloon");
        equiv.add("child", "person");
        equiv.add("girl", "child");
        equiv.add("ball", "sphere");
        equiv.add("sphere", "circle");
        equiv.add("dog", "cat");

        System.out.println(equiv.are("balloon", "circle"));
        System.out.println(equiv.are("child", "girl"));
        System.out.println(equiv.are("sun", "sun"));
        System.out.println(equiv.are("dog", "ball"));
        System.out.println(equiv.are("table", "dog"));

    }
}

package tasks;

import java.util.Arrays;

public class MainForTasks {
    public static void main(String[] args) {
        Tasks t = new Tasks(6);
        t.dependsOn(3, 2);
        t.dependsOn(0, 3);
        t.dependsOn(2, 5);
        t.dependsOn(4, 5);
        // t.dependsOn(5, 3);
        System.out.println(Arrays.toString(t.order()));

        String[] names = { "zero", "one", "two", "three", "four", "five" };
        NamedTasks t2 = new NamedTasks(names);
        t2.dependsOn("three", "two");
        t2.dependsOn("one", "three");
        t2.dependsOn("two", "five");
        t2.dependsOn("four", "five");
        System.out.println(Arrays.toString(t2.nameOrder()));

    }
}

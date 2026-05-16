package tasks;

import java.util.Arrays;

public class MainForTasks {
    public static void main(String[] args) {
        Tasks t1 = new Tasks(10);
        t1.dependsOn(0, 4);
        t1.dependsOn(3, 4); 
        t1.dependsOn(6, 4);         

        int[] test = new int[10];
        TaskNode[] bomba = t1.getTasks();
        t1.oneTaskTree(0, test, bomba[4]);

        System.out.println(Arrays.toString(test));
    }
}

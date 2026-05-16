package tasks;

import java.util.Arrays;

public class Tasks {
    private int num;
    private TaskNode[] tasks;

    public Tasks(int num) {
        this.num = num;
        this.tasks = new TaskNode[num];
        // Create Nodes
        for (int i = 0; i < num; i++) {
            tasks[i] = new TaskNode(i, num);
        }
    }

    // Task2 first -> Task1
    public boolean dependsOn(int task1, int task2) {
        if (task1 >= num || task2 >= num)
            return false;
        tasks[task2].addDependency(tasks[task1]);
        return (task1 > 0 && task2 > 0) && (task1 < num && task2 < num);
    }

    public int[] order() {
        boolean isLoop = true;
        int position = 0;
        int[] orders = new int[this.num];
        // fill orders with -1
        Arrays.fill(orders, -1);

        // Check which one has no dependencies
        for (int i = 0; i < num; i++) {

            if (tasks[i].getMain_size() == 0 && tasks[i].getDep_size() == 0) {
                orders[position++] = i;
                continue;
            }

            // If there is any dependency
            if (tasks[i].getDep_size() == 0) {
                isLoop = false;
                orders[position++] = i;
                position = compareTasks(position, orders, tasks[i]);
            }

        }
        if (isLoop)
            return null;
        return orders;
    }

    // Recursievly check if there is a closed circle, and adds task by its order in
    // orders list
    private int compareTasks(int position, int[] orders, TaskNode task) {
        for (TaskNode ts : task.getChilds()) {
            if (ts != null) {
                // More than one dependecny
                // if(ts.getDep_size() != 1)
                // {

                // }
                int nextNode = ts.getId();
                // If not add to the list
                orders[position++] = nextNode;
                position = compareTasks(position, orders, ts);
            } else
                return position;
        }
        return -1;
    }

    public int oneTaskTree(int position, int[] orders, TaskNode task) {
        for (TaskNode ts : task.getChilds()) {
            if (ts != null) {
                // More than one dependecny
                if (ts.getDep_size() != 1) {

                }
                int nextNode = ts.getId();
                // If not add to the list
                orders[position++] = nextNode;
                position = compareTasks(position, orders, ts);
            } else
                return position;
        }
        return -1;
    }

    public TaskNode[] getTasks() {
        return tasks;
    }

}

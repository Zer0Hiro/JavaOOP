package tasks;

public class NamedTasks extends Tasks {
    private String[] names;

    public NamedTasks(String[] names) {
        super(names.length);
        this.names = names;
    }

    public boolean dependsOn(String task1, String task2) {
        int i = -1;
        int j = -1;
        for (int index = 0; index < names.length; index++) {
            if (names[index] == task1)
                i = index;
            if (names[index] == task2)
                j = index;
        }
        if (i == -1 || j == -1)
            return false;
        return super.dependsOn(i, j);
    }

    public String[] nameOrder() {
        int[] orders = super.order();
        String[] namedOrders = new String[this.names.length];
        int index = 0;
        for (int i : orders) {
            namedOrders[index++] = names[i];
        }
        return namedOrders;
    }
}

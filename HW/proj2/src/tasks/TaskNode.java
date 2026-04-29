package tasks;

public class TaskNode {
    private int id;
    private TaskNode[] depending;
    private TaskNode[] main;
    private int dep_size = 0;
    private int main_size = 0;

    public TaskNode(int id, int taskAmount) {
        this.id = id;
        this.depending = new TaskNode[taskAmount];
        this.main = new TaskNode[taskAmount];
    }

    public int getDep_size() {
        return dep_size;
    }

    public int getMain_size() {
        return main_size;
    }

    public int getId() {
        return id;
    }

    public TaskNode[] getDepending() {
        return depending;
    }

    public TaskNode[] getMain() {
        return main;
    }

    public void setDep_size(int dep_size) {
        this.dep_size = dep_size;
    }

    public void addDependency(TaskNode depends) {
        // add item that depends on this node
        this.main[main_size++] = depends;
        int depend_size = depends.getDep_size();

        // update dependency
        depends.depending[depend_size++] = this;
        depends.setDep_size(depend_size);
    }

}

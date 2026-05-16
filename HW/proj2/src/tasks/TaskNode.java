package tasks;

public class TaskNode {
    private int id;
    private TaskNode[] parents;
    private TaskNode[] childs;
    private int dep_size = 0;
    private int main_size = 0;

    public TaskNode(int id, int taskAmount) {
        this.id = id;
        this.parents = new TaskNode[taskAmount];
        this.childs = new TaskNode[taskAmount];
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

    public TaskNode[] getParents() {
        return parents;
    }

    public TaskNode[] getChilds() {
        return childs;
    }

    public void setDep_size(int dep_size) {
        this.dep_size = dep_size;
    }

    public void addDependency(TaskNode depends) {
        // add item that depends on this node
        this.childs[main_size++] = depends;
        int depend_size = depends.getDep_size();

        // update dependency
        depends.parents[depend_size++] = this;
        depends.setDep_size(depend_size);
    }

}

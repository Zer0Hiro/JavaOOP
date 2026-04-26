public class Node {
    private int val;
    private Node prev, next;

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        if (next != null)
            next.prev = this;
        if (prev != null)
            prev.next = this;
    }

    public int getVal() {
        return val;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Node get(int i) {
        if (i == 0)
            return this;
        if (next == null)
            return null;
        return next.get(i - 1);
    }

    public int discard() {
        if (this.prev != null)
            prev.next = this.next;
        if (this.next != null)
            next.prev = this.prev;
        return this.val;
    }

}

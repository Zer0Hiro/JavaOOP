public class List {
    private Node head, tail;

    public void addAtHead(int val) {
        head = new Node(val, null, head);
        if (tail == null)
            tail = head;
    }

    public void addAtTail(int val) {
        tail = new Node(val, tail, null);
        if (head == null)
            head = tail;
    }

    private int deleteNode(Node n){
        if(n == null)
        {
            System.err.println("node does not exist");
            return -1;
        }
        if(n==head)
            head = head.getNext();
        if(n==tail)
            tail = tail.getPrev();
        return n.discard();
    }

    public int deleteHead() {
        return deleteNode(head);

    }

    public int deleteTail() {
        return deleteNode(tail);

    }

    public int deleteAt(int i) {
        return deleteNode(head.get(i));

    }
}

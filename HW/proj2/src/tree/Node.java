package tree;

public class Node {
    private int count = 0;
    private Node[] children = new Node[26];

    public int num(String s) {
        if (s.length() == 0) {
            return this.count;
        }

        char letter = s.charAt(0);
        int index = letter - 'a';

        // Word not in nodes
        if (children[index] == null)
            return 0;

        return children[index].num(s.substring(1));
    }

    public void add(String s) {
        if (s.length() > 0) {
            // get first letter
            char letter = s.charAt(0);
            // get everything after first letter
            s = s.substring(1);

            int index = letter - 'a';
            // create new node if not exist already
            if (children[index] == null) {
                children[index] = new Node();
                children[index].count = 0;
            }
            children[index].add(s);

        } else {
            this.count++;
        }
    }
}

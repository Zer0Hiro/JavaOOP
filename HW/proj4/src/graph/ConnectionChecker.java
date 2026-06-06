package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
    private GraphInterface<V> g;

    public ConnectionChecker(GraphInterface<V> g) {
        this.g = g;
    }

    public boolean check(V v1, V v2) {
        Set<V> visited = new HashSet<>();

        return dfsHelp(v1, v2, visited);
    }

    private boolean dfsHelp(V current, V target, Set<V> visited) {
        // if neighbour is our target
        if (current.equals(target)) {
            return true;
        }

        // sign node as visited
        visited.add(current);

        for (V neighbour : g.neighbours(current)) {
            // if already visited once
            if (visited.contains(neighbour)) {
                continue;
            }
            // check next node
            if (dfsHelp(neighbour, target, visited)) {
                return true;
            }
        }
        return false;
    }

}

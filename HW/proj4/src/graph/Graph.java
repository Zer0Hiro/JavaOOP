package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
    private Set<V> vertices;
    private Map<V, Set<V>> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashMap<>();
    }

    // Adds new Vertex(node)
    public void addVertex(V v) throws GraphException {
        if (vertices.contains(v)) {
            throw new GraphException("Vertex already in the graph.");
        }

        vertices.add(v);
        // new set for v
        edges.put(v, new HashSet<>());
    }

    // checks if there is edge between v1 and v2
    public boolean hasEdge(V v1, V v2) {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            return false;
        }
        return edges.get(v1).contains(v2);
    }

    // Connects two vertices
    public void addEdge(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("One of vertices does not exist");
        }

        if (hasEdge(v1, v2)) {
            throw new GraphException("Edge already exists between v1 and v2");
        }
        // add edges
        edges.get(v1).add(v2);
        edges.get(v2).add(v1);
    }

    public boolean connected(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("One of vertices does not exist");
        }

        // Run DFS lite
        Set<V> visited = new HashSet<>();
        return dfsAlg(v1, v2, visited);

    }

    // easy DFS alg
    private boolean dfsAlg(V current, V target, Set<V> visited) {
        // if neighbour is our target
        if (current.equals(target))
        {
            return true;
        }

        // sign node as visited
        visited.add(current);
        for (V neighbour : edges.get(current)) {
            // if already visited once
            if (visited.contains(neighbour)) {
                continue;
            }
            // check next node
            if (dfsAlg(neighbour, target, visited)) {
                return true;
            }
        }
        return false;
    }
}

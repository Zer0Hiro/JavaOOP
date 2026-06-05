package graph;

public class Maze {
    private int size;
    private Place start, end;
    private boolean[][] walls;

    public Maze(int size, int startx, int starty, int endx, int endy) throws IllegalArgumentException {
        this.size = size;
        this.start = new Place(startx, starty, size);
        this.end = new Place(endx, endy, size);
        this.walls = new boolean[size][size];
    }

    public boolean addWall(int x, int y) {
        // x,y is wall coordinates, start or end
        if (walls[x][y] || (x == start.getX() && y == start.getY()) || (x == end.getX() && y == end.getY()))
            return false;

        // Add new wall
        walls[x][y] = true;
        return true;
    }

    public boolean isSolvable() throws GraphException {
        Graph<Place> graph = new Graph<>();

        try {
            // Add each point except walls
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    // If don't wall add new Place
                    if (!walls[i][j]) {
                        graph.addVertex(new Place(i, j, size));
                    }
                }
            }

            // Add edges between Verces
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (walls[x][y]) {
                        continue;
                    }

                    Place curPlace = new Place(x, y, size);

                    // Check neighbour down
                    if (x + 1 < size && !walls[x + 1][y]) {
                        Place downNeighbour = new Place(x + 1, y, size);
                        graph.addEdge(curPlace, downNeighbour);
                    }

                    // Check neighbour to the right
                    if (y + 1 < size && !walls[x][y + 1]) {
                        Place rightNeighbour = new Place(x, y + 1, size);
                        graph.addEdge(curPlace, rightNeighbour);
                    }
                }
            }

            return graph.connected(this.start, this.end);
        } catch (GraphException e) {
            // Print error
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Start point
                if (i == start.getX() && j == start.getY())
                    out += "S";
                // End point
                else if (i == end.getX() && j == end.getY())
                    out += "E";
                // Wall point
                else if (walls[i][j])
                    out += "@";
                // Empty point
                else {
                    out += ".";
                }
            }
            out += "\n";
        }
        return out;
    }

}

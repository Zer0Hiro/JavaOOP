package game;

public class Board {
    protected Player[][] board;
    protected int n, m;

    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        this.board = new Player[n][m];
    }

    protected boolean set(int i, int j, Player p) {
        if (board[i][j] == null) {
            board[i][j] = p;
            return true;
        }
        return false;
    }

    public boolean isEmpty(int i, int j) {
        return board[i][j] == null;
    }

    public Player get(int i, int j) {
        return board[i][j];
    }

    public boolean isFull() {
        for (Player[] row : board) {
            for (Player square : row) {
                if (square == null)
                    return false;
            }
        }
        return true;
    }

    protected int maxLineContaining(int i, int j) {
        int maxLine = 0;
        int temp = 0;
        // get all direction
        for (int xAxis = -1; xAxis <= 1; xAxis++) {
            for (int yAxis = -1; yAxis <= 1; yAxis++) {
                if (xAxis == 0 && yAxis == 0)
                    continue;
                temp = rayCast(i, j, xAxis, yAxis) + 1;
                if (maxLine < temp)
                    maxLine = temp;
                // System.out.println("best length is: " + maxLine);
            }
        }
        return maxLine;
    }

    // allows to check length of line in specific direction
    private int rayCast(int x, int y, int posX, int posY) {
        int length = 0;
        char mark = board[x][y].getMark();
        x += posX;
        y += posY;
        // Hit the edge of the map or not the same mark
        if ((x > n - 1 || y > m - 1) || (x < 0 || y < 0)
                || board[x][y] == null || mark != board[x][y].getMark()) {
            return 0;
        }

        // Same Symbol
        length++;
        // System.out.println("Moved to position: [" + x + "," + y + "]");
        // System.out.println("Length is: " + length);
        return length += rayCast(x, y, posX, posY);
    }

    // Draws the map of the board
    @Override
    public String toString() {
        String map = "";
        for (Player[] row : board) {
            for (Player square : row) {
                if (square == null)
                    map += ".";
                else {
                    map += square.getMark();
                }
            }
            map += "\n";
        }
        return map;
    }

}

package mines;

import java.util.Arrays;
import java.util.Random;

public class Mines {
    private int height, width, numMines;
    private boolean mineField[][];
    private int mainField[][];
    private int fieldUnlocked;
    private boolean showAll = false;

    public Mines(int height, int width, int numMines) {
        this.height = height;
        this.width = width;
        this.numMines = numMines;
        this.fieldUnlocked = height * width - numMines;

        // Create main field
        this.mainField = new int[height][width];
        for (int[] row : mainField) {
            Arrays.fill(row, -1);
        }

        // Array for mines
        this.mineField = new boolean[height][width];

        // Fill randomly with numMines of mines
        Random rand = new Random();

        for (int i = 0; i < numMines; i++) {
            int randRow = rand.nextInt(height);
            int randCol = rand.nextInt(width);

            // If already mine there, try again
            if (mineField[randRow][randCol])
                i--;
            else {
                mineField[randRow][randCol] = true;
            }
        }

    }

    // Adds mines
    public boolean addMine(int i, int j) {
        mineField[i][j] = true;
        // -1 spot to unlock full field
        fieldUnlocked--;
        return mineField[i][j];
    }

    // Unlocks cell. In case no mines around, unlocks all neighbour cells
    public boolean open(int i, int j) {
        int counter = 0;
        // Already checked this mine
        if (mainField[i][j] >= 0 || mainField[i][j] == -3)
            return true;

        // If there is mine (End of the game)
        if (mineField[i][j]) {
            // mainField[i][j] = -3;
            return false;
        }

        // Check amount of mines around
        counter = countNeighbors(i, j);

        // Another field unlocked
        fieldUnlocked--;

        if (counter > 0)
            mainField[i][j] = counter;

        // No mines around unlock other cells
        if (counter == 0) {
            mainField[i][j] = 0;

            // Go to other cells
            for (int row = i - 1; row <= i + 1; row++) {
                // If out of field
                if (row < 0 || row >= height)
                    continue;
                // Col check
                for (int col = j - 1; col <= j + 1; col++) {
                    // If out of field
                    if (col < 0 || col >= width)
                        continue;

                    // Check if there is mine
                    open(row, col);
                }
            }
        }
        return true;
    }

    // Counts mines around spot
    private int countNeighbors(int i, int j) {
        int counter = 0;
        for (int row = i - 1; row <= i + 1; row++) {
            if (row < 0 || row >= height)
                continue;
            for (int col = j - 1; col <= j + 1; col++) {
                if (col < 0 || col >= width)
                    continue;
                if (mineField[row][col])
                    counter++;
            }
        }
        return counter;
    }

    // Signs cell to flag, equals to -2 in mainField
    public void toggleFlag(int x, int y) {
        if (mainField[x][y] == -2)
            mainField[x][y] = -1;
        else
            mainField[x][y] = -2;
    }

    // Check if all spots unlocked
    public boolean isDone() {
        if (fieldUnlocked <= 0)
            return true;
        return false;
    }

    public String get(int i, int j) {
        // if showAll
        if (showAll && (mainField[i][j] == -1 || mainField[i][j] == -2)) {
            if (mineField[i][j])
                return "X";
            // check amount of mines in closed spot
            int count = countNeighbors(i, j);
            return count == 0 ? " " : count + "";
        }

        switch (mainField[i][j]) {
            case -3: // Mine
                return "X";
            case -2: // Flag
                return "F";
            case -1: // Locked spot
                return ".";
            case 0: // Empty unlocked spot
                return " ";
            default:
                return mainField[i][j] + "";
        }
    }

    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    // Print whole field
    public String toString() {
        String temp = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                temp += get(i, j);
            }
            temp += "\n";
        }
        return temp;
    }
}

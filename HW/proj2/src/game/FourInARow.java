package game;

public class FourInARow extends Game {

    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
    }

    @Override
    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) >= 4;
    }

    @Override
    protected boolean onePlay(Player p) {
        int col;
        boolean success = false;

        while (!success) {
            System.out.println(p + " please enter column: ");
            col = s.nextInt();

            if (col < 0 || col >= m) {
                System.out.println("Invalid column. Try again.");
                continue;
            }

            int targetRow = -1;
            for (int r = n - 1; r >= 0; r--) {
                if (isEmpty(r, col)) {
                    targetRow = r;
                    break;
                }
            }

            if (targetRow != -1) {
                set(targetRow, col, p);
                success = true;
                System.out.print(this.toString());

                if (doesWin(targetRow, col)) {
                    return true;
                }
            } else {
                System.out.println("This column is full. Please choose another.");
            }
        }
        return false;
    }
}
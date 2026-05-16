package game;

public class TicTacToe extends Game {

    public TicTacToe(String p1, String p2) {
        super(3, 3, new Player(p1, 'X'), new Player(p2, 'O'));
    }

    @Override
    protected boolean doesWin(int x, int y) {
        return maxLineContaining(x, y) >= 3;
    }
}
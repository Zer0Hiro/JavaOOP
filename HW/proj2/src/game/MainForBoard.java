package game;

public class MainForBoard {
    public static void main(String[] args) {
        // FourInARow g = new FourInARow("White", "Black");
        // g.play();

        Game g = new Game(3, 4, new Player("Red", 'R'), new Player("Black", 'B'));
        g.play();

    }
}

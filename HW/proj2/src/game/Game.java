package game;

import java.util.Scanner;

public class Game extends Board {
    protected Player[] players;
    protected Scanner s;

    public Game(int n, int m, Player p1, Player p2) {
        super(n, m);
        this.players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;

        this.s = new Scanner(System.in);
    }

    protected boolean doesWin(int i, int j) {
        return i == 0 && j == 0;
    }

    protected boolean onePlay(Player p) {
        boolean succ = false;
        while (!succ) {
            System.out.println("Player is: " + p);
            System.out.println(p + ", please enter x and y:");
            int x = s.nextInt();
            int y = s.nextInt();

            if (!super.set(x, y, p)) {
                System.out.println("There is a piece there already...");
            } else {
                succ = true;
            }
            if (doesWin(x, y))
                return true;
        }
        System.out.print(this);
        return false;

    }

    public Player play() {
        // first player
        int pl = 0;
        while (!isFull()) {
            Player playerATM = players[pl];
            // Perform one turn
            if (onePlay(playerATM)) {
                System.out.println(playerATM + " Won!");
                return playerATM;
            }
            if (pl == 0) {
                pl++;
            } else {
                pl--;
            }
        }

        // full board
        s.close();
        return null;
    }
}

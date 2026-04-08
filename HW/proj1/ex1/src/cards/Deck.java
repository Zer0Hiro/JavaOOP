package cards;

import java.util.Arrays;

public class Deck {
    private int num;
    private Card[] cards;

    public Deck(int num) {
        this.num = num * 4;
        this.cards = new Card[num * 4];

        // Add cards to Deck
        for (int i = 0; i < this.num; i++) {
            int cardNumber = i / 4;
            int cardSuit = i % 4;
            cards[i] = new Card(cardNumber, cardSuit);
        }
    }

    public Deck(Deck from, int num) {
        this.num = num;
        this.cards = new Card[num];

        // Transfer Cards
        int current = from.num - 1;
        for (int i = 0; i < num; i++) {
            this.cards[i] = from.cards[current];

            // Clean Deck
            from.cards[current--] = null;
            from.num--;
        }
    }

    public Deck(Deck first, Deck second) {
        this.num = first.num + second.num;
        this.cards = new Card[this.num];
        int current = 0;
        int firstIndex = first.num - 1;
        int secondIndex = second.num - 1;

        while (first.num != 0 || second.num != 0) {

            if (first.num != 0) {
                this.cards[current++] = first.cards[firstIndex];
                // Cleanup
                first.cards[firstIndex--] = null;
                first.num--;
            }

            if (second.num != 0) {
                this.cards[current++] = second.cards[secondIndex];
                // Cleanup
                second.cards[secondIndex--] = null;
                second.num--;
            }
        }
    }

    public int getNumCards() {
        return num;
    }

    public Card takeOne() {
        Card temp = this.cards[this.num - 1];
        this.cards[this.num - 1] = null;
        this.num--;
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.cards);
    }

    public void sort() {
        for (int i = 0; i < this.num - 1; i++) {
            for (int j = 0; j < this.num - 1 - i; j++) {
                Card c1 = cards[j];
                Card c2 = cards[j + 1];
                boolean swapFlag = false;

                // Sort by number
                int result = c1.compareTo(c2);
                if (result > 0)
                    swapFlag = true;

                // Sort by suit
                if (result == 0 && c1.getSuit() > c2.getSuit())
                    swapFlag = true;

                if (swapFlag) {
                    cards[j] = c2;
                    cards[j + 1] = c1;
                }
            }

        }
    }
}

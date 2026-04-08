package cards;

public class Card {
    private int num;
    private int suit;
    private char cardType;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
        // get type of the card
        switch (suit) {
            case 0:
                cardType = 'C';
                break;
            case 1:
                cardType = 'D';
                break;
            case 2:
                cardType = 'H';
                break;
            case 3:
                cardType = 'S';
                break;
            default:
                break;
        }
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return num + "" + cardType;
    }

    public int compareTo(Card other) {
        if (this == other)
            return 0;
        return this.num - other.getNum();
    }

}

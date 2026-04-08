package ex1;

public class Timerius {
    // var
    private int h, m, s;

    // constructors
    public Timerius(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public Timerius(int s) {
        m = s / 60;
        h = m / 60;
        m = m % 60;
        this.s = s % 60;
    }

    // methods
    public String toString() {
        return String.format("(%02d:%02d:%02d)", h, m, s);
        /*
         * SECOND OPTION
         * String res = "(";
         * if (m < 10)
         * res += "0";
         * res += m + ":";
         * if (s < 10)
         * res += "0";
         * return res + s + ")";
         */
    }

    public int totalSeconds() {
        return s + m * 60 + h * 60 * 60;
    }

    public boolean tickDown() {
        if (s == 0) {
            if (m == 0)
                if (h != 0) {
                    h--;
                    m = 60;
                } else
                    return false;
            m--;
            s = 59;
        } else
            s--;
        return true;
    }
}

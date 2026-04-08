package root;

public class Rooter {
    private double precision;

    public Rooter(double precision) {
        this.precision = precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double sqrt(double x) {
        double one = x / 2;
        double two;
        while (true) {
            two = x / one;

            // one is sqrt of x
            if (one == two) {
                return one;
            }

            // dif between one and two smaller than precision
            if (Math.abs(two - one) < precision) {
                return one;
            }

            // avg of one and two
            one = (two + one) / 2;
        }
    }

}

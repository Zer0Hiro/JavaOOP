package images;

public class RGB {
    private double red;
    private double green;
    private double blue;

    public RGB(double red, double green, double blue) {
        // allow numbers only between 0.0 - 1.0
        this.red = Math.min(1.0, Math.max(0.0, red));
        this.green = Math.min(1.0, Math.max(0.0, green));
        this.blue = Math.min(1.0, Math.max(0.0, blue));
    }

    public RGB(double grey) {
        this.red = Math.min(1.0, Math.max(0.0, grey));
        this.green = Math.min(1.0, Math.max(0.0, grey));
        this.blue = Math.min(1.0, Math.max(0.0, grey));
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    // Inverts all colors of object
    public RGB invert() {
        double nRed = (1.0 - this.getRed());
        double nGreen = (1.0 - this.getGreen());
        double nBlue = (1.0 - this.getBlue());
        RGB temp = new RGB(nRed, nGreen, nBlue);

        return temp;
    }

    // Multiply colors bt filter
    public RGB filter(RGB filter) {
        double nRed = (this.getRed() * filter.getRed());
        double nGreen = (this.getGreen() * filter.getGreen());
        double nBlue = (this.getBlue() * filter.getBlue());
        RGB temp = new RGB(nRed, nGreen, nBlue);

        return temp;
    }

    // Create new color out of 2 different colors
    public static RGB superpose(RGB rgb1, RGB rgb2) {
        double newRed = rgb1.getRed() + rgb2.getRed();
        double newGreen = rgb1.getGreen() + rgb2.getGreen();
        double newBlue = rgb1.getBlue() + rgb2.getBlue();

        return new RGB(newRed, newGreen, newBlue);
    }

    // Create new color with additional alpha channel
    public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
        double newRed = rgb1.getRed() * alpha + rgb2.getRed() * (1 - alpha);
        double newGreen = rgb1.getGreen() * alpha + rgb2.getGreen() * (1 - alpha);
        double newBlue = rgb1.getBlue() * alpha + rgb2.getBlue() * (1 - alpha);

        return new RGB(newRed, newGreen, newBlue);
    }

    @Override
    public String toString() {
        return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
    }

    public static final RGB BLACK = new RGB(0);
    public static final RGB WHITE = new RGB(1);
    public static final RGB RED = new RGB(1, 0, 0);
    public static final RGB GREEN = new RGB(0, 1, 0);
    public static final RGB BLUE = new RGB(0, 0, 1);

    public static void main(String[] args) {
        Image i1 = new Gradient(500, 500, RGB.BLUE, RGB.BLACK);
        Image i2 = new Transpose(new Gradient(500, 500, RGB.RED, RGB.BLACK));
        Image i3 = new Mix(i1, i2, 0.5);
        Image i4 = new Circle(350, 150, new RGB(1, 1, 0), RGB.BLACK);
        Image i5 = new Circle(200, 100, new RGB(0, 0.5, 1), RGB.BLACK);
        Image i6 = new Circle(500, 200, RGB.WHITE, RGB.BLACK);

        Image i7 = new Superpose(i3, i4);
        Image i8 = new Superpose(i5, i6);
        Image i9 = new Superpose(i7, i8);

        Displayer.display(i9);

    }
}

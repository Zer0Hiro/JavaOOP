package images;

public class Superpose extends BinaryImageDecorator {

    public Superpose(Image img1, Image img2) {
        super(img1, img2);
    }

    @Override
    public RGB get(int x, int y) {
        RGB color1;
        RGB color2;
        if (x < img1.getWidth() && y < img1.getHeight()) {
            color1 = img1.get(x, y);
        } else
            color1 = RGB.BLACK;

        if (x < img2.getWidth() && y < img2.getHeight()) {
            color2 = img2.get(x, y);
        } else
            color2 = RGB.BLACK;

        return RGB.superpose(color1, color2);
    }

    // public static void main(String[] args) {
    //     Image i1 = new Gradient(100, 150, RGB.RED,
    //             RGB.RED);
    //     Image i2 = new Gradient(200, 100, RGB.BLUE,
    //             RGB.BLUE);
    //     Image i = new Superpose(i1, i2);
    //     Displayer.display(i);

    // }
}

package images;

public class Mix extends BinaryImageDecorator {
    private double alpha;

    public Mix(Image img1, Image img2, double alpha) {
        super(img1, img2);
        this.alpha = alpha;
    }

    @Override
    public RGB get(int x, int y) {
        // Check if there is existing pixel
        boolean hasImg1 = (x < img1.getWidth() && y < img1.getHeight());
        boolean hasImg2 = (x < img2.getWidth() && y < img2.getHeight());

        if (hasImg1 && hasImg2) {
            return RGB.mix(img1.get(x, y), img2.get(x, y), this.alpha);
        }

        // No mix return same pixel
        if (hasImg1) {
            return img1.get(x, y);
        }

        if (hasImg2) {
            return img2.get(x, y);
        }

        // In case something is not working
        return RGB.BLACK;
    }

    // public static void main(String[] args) {
    //     Image i1 = new Gradient(100, 150, RGB.RED,
    //             RGB.WHITE);
    //     Image i2 = new Gradient(200, 100, RGB.BLUE,
    //             RGB.GREEN);
    //     Image i = new Mix(i1, i2, 0.7);
    //     Displayer.display(i);

    // }

}

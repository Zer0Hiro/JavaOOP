package images;

public class TwoColorImage extends BaseImage {
    private RGB zero;
    private RGB one;
    private TwoDFunc func;

    public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
        super(width, height);
        this.zero = zero;
        this.one = one;
        this.func = func;
    }

    @Override
    public RGB get(int x, int y) {
        double displayX = (double) x / getWidth();
        double displayY = (double) y / getHeight();

        double alpha = 1.0 - func.f(displayX, displayY);

        // trap for alpha
        if (alpha > 1.0) {
            alpha = 1.0;
        } else if (alpha < 0.0) {
            alpha = 0.0;
        }
        return RGB.mix(zero, one, alpha);
    }

}

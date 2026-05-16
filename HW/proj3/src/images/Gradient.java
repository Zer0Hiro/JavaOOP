package images;

//Creates Gradient image with 2 colors mix
public class Gradient extends BaseImage {
    private RGB start;
    private RGB end;

    public Gradient(int width, int height, RGB start, RGB end) {
        super(width, height);
        this.start = start;
        this.end = end;
    }

    @Override
    public RGB get(int x, int y) {
        double alpha = 1.0 - (double) x / getWidth();
        RGB mixed = RGB.mix(start, end, alpha);
        return mixed;
    }


}

package images;

public class Circle extends BaseImage {
    private int centerX;
    private int centerY;
    private RGB center;
    private RGB outside;
    private int radius;

    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        super(width, height);
        this.centerX = centerX;
        this.centerY = centerY;
        this.center = center;
        this.outside = outside;
        this.radius = radius;
    }

    // Square image
    public Circle(int size, int radius, RGB center, RGB outside) {
        super(size, size);
        this.radius = radius;
        this.center = center;
        this.outside = outside;
        this.centerX = size / 2;
        this.centerY = size / 2;
    }

    @Override
    public RGB get(int x, int y) {

        int dx = x - centerX;
        int dy = y - centerY;
        double distance = Math.sqrt((dx * dx) + (dy * dy));

        double alpha = distance / radius;

        // Out of the circle
        if (alpha > 1.0)
            alpha = 1.0;

        RGB mixed = RGB.mix(outside, center, alpha);
        return mixed;
    }

}

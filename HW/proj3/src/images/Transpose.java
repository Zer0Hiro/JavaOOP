package images;

public class Transpose extends ImageDecorator {

    public Transpose(Image baseImage) {
        super(baseImage, null);
    }

    @Override
    public int getWidth() {
        return super.getHeight();
    }

    @Override
    public int getHeight() {
        return super.getWidth();
    }

    @Override
    public RGB get(int x, int y) {
        RGB swap = super.get(y, x);
        return swap;
    }

}

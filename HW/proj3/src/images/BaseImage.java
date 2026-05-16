package images;

public class BaseImage implements Image {
    private int width;
    private int height;

    public BaseImage(int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public RGB get(int x, int y) {
        return null;
    }

}

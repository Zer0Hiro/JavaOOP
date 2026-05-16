package images;

public class ImageDecorator implements Image {
    protected Image baseImage;
    protected RGB color;

    public ImageDecorator(Image baseImage, RGB color) {
        this.baseImage = baseImage;
        this.color = color;
    }

    @Override
    public int getWidth() {
        return baseImage.getWidth();
    }

    @Override
    public int getHeight() {
        return baseImage.getHeight();
    }

    @Override
    public RGB get(int x, int y) {
        return baseImage.get(x, y);
    }
}

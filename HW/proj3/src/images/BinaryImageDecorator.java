package images;

public class BinaryImageDecorator implements Image {
    protected Image img1;
    protected Image img2;

    public BinaryImageDecorator(Image img1, Image img2) {
        this.img1 = img1;
        this.img2 = img2;
    }

    @Override
    // return the biggest height
    public int getHeight() {
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        if (h1 > h2)
            return h1;
        return h2;
    }

    @Override
    public int getWidth() {
        int h1 = img1.getWidth();
        int h2 = img2.getWidth();
        if (h1 > h2)
            return h1;
        return h2;
    }

    @Override
    public RGB get(int x, int y) {
        return null;
    }


}

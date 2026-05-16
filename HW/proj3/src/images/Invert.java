package images;

public class Invert extends ImageDecorator {

    public Invert(Image baseImage) {
        super(baseImage,null);
    }

    @Override
    public RGB get(int x, int y) {
        RGB currentColor = super.get(x, y);
        return currentColor.invert();
    }


}

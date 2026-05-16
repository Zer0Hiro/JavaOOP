package images;

public class Filter extends ImageDecorator {
    private RGB color;

    public Filter(Image baseImage, RGB color) {
        super(baseImage, null);
        this.color = color;
    }

    @Override
    public RGB get(int x, int y) {
        // get original color from x,y
        RGB originalColor = super.get(x, y);
        return originalColor.filter(color);
    }


}

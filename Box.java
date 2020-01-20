import java.awt.Color;

public class Box extends PixelComponent {

    int w;
    int h;

    Color color;

    public Box(int x, int y, int w, int h, Color color) {
        this(x, y, 0, w, h, color);
    }

    public Box(int x, int y, int z, int w, int h, Color color) {
        super(x, y, z);
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public void setWidth(int w) {
        this.w = w;
    }

    public int getWidth() {
        return w;
    }

    public void setHeight(int h) {
        this.h = h;
    }

    public int getHeight(int h) {
        return h;
    }

    public void setHeight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Color[][] getPixels() {

        Color[][] pixels = new Color[w][h];

        for (int i = 0; i < w; i++)
            for (int j = 0; j < h; j++)
                pixels[i][j] = color;

        return pixels;

    }

}
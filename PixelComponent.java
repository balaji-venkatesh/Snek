import java.awt.Color;

/**
 * A class that returns a grid of color when asked nicely. It has an x, y, and z
 * (level) coordinate. It is comparable with other PixelComponents based on its
 * z-level for drawing purposes.
 * 
 * @see Comparable
 */
public class PixelComponent implements Comparable<PixelComponent> {

    private int x;
    private int y;
    private int z;

    public PixelComponent(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int compareTo(PixelComponent pc) {
        return this.z - pc.z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Color[][] getPixels() {
        return null;
    }

}
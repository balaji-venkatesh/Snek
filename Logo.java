import java.awt.Color;

public class Logo extends PixelComponent {

    public Logo(int x, int y, int z) {
        super(x, y, z);
    }

    public Color[][] getPixels() {

        // sorry about this

        Color[][] pixels = {{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,null,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,Color.yellow,Color.yellow,null},
        {null,null,Color.yellow,Color.yellow,Color.yellow,null,null,null,null,null,null,null,null,null,Color.yellow,Color.yellow,Color.yellow,null,null},
        {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}};

        return pixels;
        
    }

}
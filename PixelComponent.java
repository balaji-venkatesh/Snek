import java.awt.Color;

public abstract class PixelComponent implements Comparable<PixelComponent>{

    private int priority;
    private int x;
    private int y;

    public int compareTo(PixelComponent pc){
        return this.priority - pc.priority;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(){
        this.x=x;
    }

    public void setY(){
        this.y=y;
    }

    public abstract Color[][] getPixels();

}
import java.awt.Color;
import java.awt.Graphics;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JPanel implements Clockable {

    JFrame frame;
    Color[][] pixels;

    int rows = 100;
    int cols = 150;

    private PriorityQueue<PixelComponent> pq = new PriorityQueue<PixelComponent>();

    public Engine(String name) {
        frame = new JFrame(name);
        frame.add(this);
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        pixels = new Color[cols][rows];
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                pixels[i][j] = Color.gray;
    }

    public Engine() {
        this("Window");
    }

    public void showWindow() {
        frame.show();
    }

    public void paint(Graphics g) {

        int height = this.getHeight();
        int width = this.getWidth();

        int side = Math.min((height-10) / rows, (width-10) / cols);

        int hgap = (height - rows * side) / 2;
        int wgap = (width - cols * side) / 2;

        g.setColor(Color.lightGray);

        g.fillRect(0, 0, width, height);

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                //System.out.println(x + " " + y + pixels[x][y]);
                g.setColor(pixels[x][y]);
                g.fillRect(x*side+wgap+1,y*side+hgap+1,side-1,side-1);
            }
        }

    }

    public void setPixel(int x, int y, Color c) {
        if(c!= null && 0<=x && x<cols && 0<=y && y < rows) pixels[x][y] = c;
    }

    public void delay(long time){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start < time);
    }

    public void act(){
        for(PixelComponent pc : pq){

            int x = pc.getX();
            int y = pc.getY();
            Color[][] pixels = pc.getPixels();

            for(int i = 0; i < pixels.length; i++){
                for(int j = 0; j < pixels[0].length; j++){
                    this.setPixel(i+x, j+y, pixels[i][j]);
                }
            }
        }

        this.repaint();

    }

    public boolean addPixelComponent(PixelComponent pc){
        return pq.add(pc);
    }

    public boolean removePixelComponent(PixelComponent pc){
        return pq.remove(pc);
    }

}
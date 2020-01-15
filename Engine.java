import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine extends JPanel {

    JFrame frame;
    Color[][] pixels;

    int rows = 100;
    int cols = 150;

    private ArrayList<PixelComponent> components = new ArrayList<PixelComponent>();

    public Engine(String name) {
        frame = new JFrame(name);
        frame.add(this);
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        pixels = new Color[cols][rows];
        clear();
        frame.addKeyListener(new Keyboard());
    }

    public void showWindow() {
        frame.show();
    }

    public void paint(Graphics g) {

        int height = this.getHeight();
        int width = this.getWidth();

        int side = Math.min((height - 10) / rows, (width - 10) / cols);

        int hgap = (height - rows * side) / 2;
        int wgap = (width - cols * side) / 2;

        //g.setColor(new Color(112, 66, 20)); //sepia
        g.setColor(Color.darkGray);

        g.fillRect(0, 0, width, height);

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                // System.out.println(x + " " + y + pixels[x][y]);
                g.setColor(pixels[x][y]);
                g.fillRect(x * side + wgap, y * side + hgap, side, side);
            }
        }

    }

    public void clear(){
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                pixels[i][j] = Color.gray;
    }

    public void setPixel(int x, int y, Color c) {
        if (c != null && 0 <= x && x < cols && 0 <= y && y < rows)
            pixels[x][y] = c;
    }

    public void update() {
        
        clear();

        for (PixelComponent pc : components) {

            //System.out.println(pc.getZ());

            int x = pc.getX();
            int y = pc.getY();
            Color[][] pcp = pc.getPixels();

            for (int i = 0; i < pcp.length; i++) {
                for (int j = 0; j < pcp[0].length; j++) {
                    this.setPixel(i + x, j + y, pcp[i][j]);
                }
            }
        }

        this.repaint();

    }

    public boolean addPixelComponent(PixelComponent pc) {
        boolean added = components.add(pc);
        Collections.sort(components);
        return added;
    }

    public boolean removePixelComponent(PixelComponent pc) {
        return components.remove(pc);
    }

}
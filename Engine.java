import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Engine {

    private static JFrame frame;
    private static Window window = new Window();

    protected static Color[][] pixels;
    protected static int rows = 30;
    protected static int cols = 30;

    private static ArrayList<PixelComponent> components = new ArrayList<PixelComponent>();

    public static void showWindow(String name) {
        frame = new JFrame(name);
        frame.add(window);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pixels = new Color[cols][rows];
        clear();
        frame.addKeyListener(new Keyboard());
        frame.show();
    }

    public static void clear() {
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                pixels[i][j] = Color.gray;
    }

    public static void setPixel(int x, int y, Color c) {
        if (c != null && 0 <= x && x < cols && 0 <= y && y < rows)
            pixels[x][y] = c;
    }

    public static void setSize(int nRows, int nCols) {
        rows = nRows;
        cols = nCols;
        pixels = new Color[cols][rows];
    }

    public static void update() {

        clear();

        for (PixelComponent pc : components) {

            int x = pc.getX();
            int y = pc.getY();
            Color[][] pcp = pc.getPixels();

            for (int i = 0; i < pcp.length; i++) {
                for (int j = 0; j < pcp[0].length; j++) {
                    setPixel(i + x, j + y, pcp[i][j]);
                }
            }
        }

        window.repaint();

    }

    public static boolean addPixelComponent(PixelComponent pc) {
        boolean added = components.add(pc);
        Collections.sort(components);
        return added;
    }

    public static boolean removePixelComponent(PixelComponent pc) {
        return components.remove(pc);
    }

    public static void removeAllPixelComponents() {
        components = new ArrayList<PixelComponent>();
    }

}

class Window extends JPanel {

    public void paint(Graphics g) {

        int height = this.getHeight();
        int width = this.getWidth();

        int side = Math.min((height - 10) / Engine.rows, (width - 10) / Engine.cols);

        int hgap = (height - Engine.rows * side) / 2;
        int wgap = (width - Engine.cols * side) / 2;

        g.setColor(Color.darkGray);

        g.fillRect(0, 0, width, height);

        for (int x = 0; x < Engine.cols; x++) {
            for (int y = 0; y < Engine.rows; y++) {
                g.setColor(Engine.pixels[x][y]);
                g.fillRect(x * side + wgap, y * side + hgap, side - Settings.getSetting("Visual Grid"),
                        side - Settings.getSetting("Visual Grid"));
            }
        }

    }

}
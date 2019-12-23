import java.awt.Color;

public class Grid {

    int[][] grid;
    int length;
    int width;
    Color color[] = new Color[] { 
        Color.white,
        Color.red
    };

    public Grid(int width, int length) {
        this.length = length;
        this.width = width;
        grid = new int[width][length];

        for (int i = 0; i < length; i++) {
            grid[0][i] = 1;
            grid[width-1][i] = 1;
        }

        for (int i = 0; i < width; i++) {
            grid[i][0] = 1;
            grid[i][length-1] = 1;
        }
    }

    public void render(Engine engine, int x, int y){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < length; j++){
                engine.setPixel(i*2+x, j*2+y, color[grid[i][j]]);
                engine.setPixel(i*2+x+1, j*2+y, color[grid[i][j]]);
                engine.setPixel(i*2+x, j*2+y+1, color[grid[i][j]]);
                engine.setPixel(i*2+x+1, j*2+y+1, color[grid[i][j]]);
            }
        }
    }
}
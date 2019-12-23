import java.awt.Color;

public class Main {

    static long time;

    public static void main(String[]args){

        Engine engine = new Engine();
        Grid grid = new Grid(40,40);

        grid.render(engine, (150-40*2)/2, 15);
        
        Text.draw(engine, 2, 2, "Score: 2546", Color.darkGray);

        engine.showWindow();
        //engine.start();

    }

}
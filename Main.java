import java.awt.Color;

public class Main {

    static long time;

    public static void main(String[]args){

        Engine engine = new Engine("Snek");

        Text score = new Text(105, 8, 10, "You lose", Color.black);
        Grid grid = new Grid(5, 5, 45, 45);
        Box box = new Box(100, 5, 45, 90, Color.lightGray);

        Clock clock = new Clock(1000);
        clock.schedule(engine);
        
        engine.showWindow();
        engine.addPixelComponent(score);
        engine.addPixelComponent(grid);
        engine.addPixelComponent(box);

        //engine.act();
        clock.start(); // starts the game ticks

    }

}
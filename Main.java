import java.awt.Color;

public class Main {

    static long time;

    public static void main(String[]args){

        int num = 0;

        Engine engine = new Engine("Snek");

        Text score = new Text(2, 2, "Score: " + num, Color.white);

        Clock clock = new Clock(1000);

        clock.schedule(engine);
        
        engine.showWindow();

        engine.addPixelComponent(score);

        clock.start();

        while(true){
            engine.delay(10);
            num++;
            score.setText("Score: " + num);
        }

    }

}
public class Main {

    public static Clock clock = new Clock(100);
    public static Engine engine = new Engine("Snek");
    public static Grid grid = new Grid(5, 5, 45, 45);

    public static void main(String[] args) {

        /*Text score = new Text(105, 8, 10, "You lose", Color.black);
        
        Box box = new Box(100, 5, 45, 90, Color.lightGray);
        
        engine.addPixelComponent(score);
        engine.addPixelComponent(box);
        */

        engine.addPixelComponent(grid);

        clock.schedule(new Action(10000) {void act(){engine.update();}});

        engine.showWindow();

        clock.start(); // starts the game ticks

        /*Keyboard.addAction("heya", () -> {
            System.out.println("hello");
        });

        Keyboard.updateBinding(81, "heya");*/
        //Snek s1 = new Snek(2, 1, 2, true, 2);
        //Snek s2 = new Snek(2, 2, 2, true, 2);
        //Snek s3 = new Snek(2, 3, 2, true, 2);
        Snek youSnek = new Snek(30, 35, 1, true, 6);
        //Snek meSnek = new Snek(29, 35, 1, true, 8);
        
    }

}
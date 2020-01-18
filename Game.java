import java.awt.Color;

public class Game{

    public static Grid grid;
    public static Clock clock;
    public static int score = 0;
    public static int bgScore = 0;

    public static void start(){

        Engine.setSize(Settings.getSetting("Grid Length") * 2 + 10, Settings.getSetting("Grid Width") * 2 + 90);

        //public static Grid grid = new Grid(5, 5, 45, 45);
        //public static Clock clock = new Clock(100);

        grid = new Grid(5, 5, Settings.getSetting("Grid Width"), Settings.getSetting("Grid Length"));
        clock = new Clock(Settings.getSetting("Tick Delay"));

        Text scoreText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 8, 10, "Score: 0", Color.black);

        clock.schedule(new Action(100000) {
            void act() {
                if (bgScore >= 5) {

                    int x = 0;
                    int y = 0;

                    while (grid.getCell(x, y) != 0) {
                        x = (int) (Math.random() * Settings.getSetting("Grid Width"));
                        y = (int) (Math.random() * Settings.getSetting("Grid Length"));
                    }


                    Snek ouchSnek = new Snek(x, y, (int) (Math.random() * 3) + 1, false, Settings.getSetting("Snek Size"));
                    bgScore -= 5;
                }
                scoreText.setText("Score: " + score);
            }
        });

        Engine.addPixelComponent(scoreText);

        Text enermyText = new Text(Settings.getSetting("Grid Width") * 2 + 15, 16, 10, "Enermeyo: 0", Color.black);

        clock.schedule(new Action(100000) {
            void act() {
                enermyText.setText("Enermeyo: " + Snek.numEnermeyoSneks);
            }
        });

        Engine.addPixelComponent(enermyText);

        Box box = new Box(Settings.getSetting("Grid Width") * 2 + 10, 5, 75, 90, Color.lightGray);

        Engine.addPixelComponent(box);

        Engine.addPixelComponent(grid);

        clock.schedule(new Action(10000) {
            void act() {
                Engine.update();
            }
        });

        
        Snek youSnek = new Snek(Settings.getSetting("Grid Width") * 2 / 3, Settings.getSetting("Grid Length") * 2 / 3, Settings.getSetting("Player 1 Starting Direction"), true, Settings.getSetting("Snek Size"));
        Snek meSnek = new Snek(Settings.getSetting("Grid Width") / 3, Settings.getSetting("Grid Length")  / 3, Settings.getSetting("Player 2 Starting Direction"), true, Settings.getSetting("Snek Size"));

        for (int i = 0; i < Settings.getSetting("Num of Apples"); i++)
            grid.addApple();

        clock.start(); // starts the game ticks

    }

}